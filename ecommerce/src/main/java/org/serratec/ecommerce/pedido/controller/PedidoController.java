package org.serratec.ecommerce.pedido.controller;

import org.serratec.ecommerce.pedido.domain.Pedido;
import org.serratec.ecommerce.pedido.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> pesquisar(){
        return this.pedidoService.pesquisar();
    }

    @GetMapping("/id")
    public ResponseEntity<Pedido> pesquisar(@PathVariable Long id){
        return this.pedidoService.pesquisar(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido inserir(@Valid @RequestBody Pedido pedido) {
        return this.pedidoService.inserir(pedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> editar(@Valid @RequestBody Pedido pedido, @PathVariable Long id) {
        return this.pedidoService.editar(pedido, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pedido> remover(@PathVariable Long id) {
        return this.pedidoService.remover(id);
    }
}
