package org.serratec.ecommerce.pedido.impl;

import org.serratec.ecommerce.exception.ErroResposta;
import org.serratec.ecommerce.pedido.domain.Pedido;
import org.serratec.ecommerce.pedido.exception.PedidoException;
import org.serratec.ecommerce.pedido.repository.PedidoRepository;
import org.serratec.ecommerce.pedido.service.PedidoService;
import org.serratec.ecommerce.utils.Mensagens;
import org.serratec.ecommerce.pedido.utils.StatusPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public ResponseEntity<List<Pedido>> pesquisar() {
        List<Pedido> pedidos = this.pedidoRepository.findAll();
        return ResponseEntity.ok(pedidos);
    }

    @Override
    public ResponseEntity<Pedido> pesquisar(Long id) {
        Optional<Pedido> pedido = this.pedidoRepository.findById(id);
        if (pedido.isPresent()) {
            return ResponseEntity.ok(pedido.get());
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public Pedido inserir(Pedido pedido) {
        return this.pedidoRepository.save(pedido);
    }

    @Override
    public boolean existe(Long id) {
        return this.pedidoRepository.existsById(id);
    }

    @Override
    public ResponseEntity<Pedido> remover(Long id) {
        if (!this.pedidoRepository.existsById(id)) {
            throw new PedidoException(new ErroResposta(HttpStatus.NOT_FOUND,
                    Mensagens.Exceptions.EXCLUSAO_FALHOU,
                    Arrays.asList(new StringBuilder()
                            .append(Mensagens.Exceptions.PESQUISA_FALHOU)
                            .append(id)
                            .toString())));
        }

        //Pedido pedido = this.pedidoRepository.getById(id);
        this.pedidoRepository.deleteById(id);
        //return ResponseEntity.ok(pedido);  // With pedido response
        return ResponseEntity.noContent().build();
    }

    @Override
    public List<Pedido> inserir(List<Pedido> pedidos) {
        return this.pedidoRepository.saveAll(pedidos);
    }

    @Override
    public ResponseEntity<Pedido> editar(Pedido pedido, Long id) throws PedidoException {
        if (!this.pedidoRepository.existsById(id)) {
            throw new PedidoException(new ErroResposta(HttpStatus.NOT_FOUND,
                    Mensagens.Exceptions.EDICAO_FALHOU,
                    Arrays.asList(new StringBuilder()
                            .append(Mensagens.Exceptions.PESQUISA_FALHOU)
                            .append(id)
                            .toString())));
        }

        if (!this.pedidoRepository.getById(id).getStatusPedido().equals(StatusPedido.PROCESSANDO)) {
            throw new PedidoException(new ErroResposta(HttpStatus.NOT_FOUND,
                    Mensagens.Exceptions.EXCLUSAO_FALHOU,
                    Arrays.asList(this.pedidoRepository.getById(id).getStatusPedido().getTipo())));
        }

        pedido.setId(id);
        pedido = this.pedidoRepository.save(pedido);
        return ResponseEntity.ok(pedido);
    }
}
