package org.serratec.ecommerce.controller;

import java.util.List;

import org.serratec.ecommerce.domain.Categoria;
import org.serratec.ecommerce.domain.Cliente;
import org.serratec.ecommerce.repository.CategoriaRepository;
import org.serratec.ecommerce.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clientes")
public class ClienteController extends UsuarioController{

	@Autowired
	private ClienteRepository clienteRepository;
		
	
	//Atualizar seus próprios dados pessoais.
	@PutMapping("{id}")
	public ResponseEntity<Cliente> atualizarUser(@PathVariable Long id, @RequestBody Cliente cliente){
		if(clienteRepository.existsById(id)) {
			cliente.setId(id);
			cliente = clienteRepository.save(cliente);
			
			return ResponseEntity.ok(cliente);
		}
		return ResponseEntity.notFound().build();
	}
	
	//Deletar sua prórpia conta.
	@DeleteMapping("{id}")
	public ResponseEntity<Void> DeletarUser(@PathVariable Long id){
		
		if(clienteRepository.existsById(id)) {
			clienteRepository.deleteById(id);
			
			return ResponseEntity.accepted().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	//Criar um novo Pedido

	
	//Editar um pedido com status de não finalizado.
	
	
	//Ao finalizar o pedido, enviar e-mail para o cliente informando data de envio, data de entrega, produtos, quantidades e vaor final do pedido.
	
	
	
}
