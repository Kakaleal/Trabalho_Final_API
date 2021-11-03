package org.serratec.ecommerce.pedido.service;

import org.serratec.ecommerce.pedido.domain.Pedido;
import org.serratec.ecommerce.pedido.exception.PedidoException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PedidoService {

    /** Pesquisa todos os pedidos.
     * @return Uma lista de {@link Pedido}
     * @author Nathan Guimarães
     */
    ResponseEntity<List<Pedido>> pesquisar();

    /**
     * Pesquisa um pedido pelo ID
     * @param id
     * @return {@link org.springframework.http} {@link Pedido}
     */
    ResponseEntity<Pedido> pesquisar(Long id);

    /**
     * Insere um {@link Pedido}
     * @param pedido
     * @return {@link Pedido}
     */
    Pedido inserir(Pedido pedido);

    /**
     * Insere uma lista de {@link Pedido}
     * @param pedidos
     * @return Uma lista de {@link Pedido}
     */
    List<Pedido> inserir(List<Pedido> pedidos);

    /**
     * Atualiza um {@link Pedido}
     * @param veiculo
     * @param id
     * @return
     */
    ResponseEntity<Pedido> editar(Pedido veiculo, Long id) throws PedidoException;
    boolean existe(Long id);

    /**
     * Remove um {@link Pedido} por ID
     * @param id
     * @return
     */
    ResponseEntity<Pedido> remover(Long id);
}
