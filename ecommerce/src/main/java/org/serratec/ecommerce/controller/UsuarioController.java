package org.serratec.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.ecommerce.domain.Categoria;
import org.serratec.ecommerce.repository.CategoriaRepository;
import org.serratec.ecommerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	//Visualizar todas as categorias ou uma catogira específica pelo nome
	
	//VISUALIZAR TODAS AS CATEGORIAS
	@GetMapping
	public ResponseEntity<List<Categoria>> listarTodas(){
		List<Categoria> categorias = categoriaRepository.findAll();
		return ResponseEntity.ok(categorias);
	}
	
	//VISUALIZAR UMA CATEGORIA EM ESPECIFICO PELO NOME
	
	@GetMapping("{nomeDaCategoria}")
	public ResponseEntity<List<Categoria>> findByName(@RequestParam String nomeDaCategoria){
		return ResponseEntity.ok(categoriaRepository.findByName(nomeDaCategoria));
	}
	
	//Criar uma nova categoria
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria criarCat(@RequestBody Categoria categoria){
		return categoriaRepository.save(categoria);
	}
	
	//Visualizar todos os produtos ou um produto específico pelo nome
	
	//Criar um novo produto (com imagem)
	
	//Visualizar todos os pedidos.
}
