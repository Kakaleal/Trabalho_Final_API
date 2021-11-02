package org.serratec.ecommerce.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_usuario")
	private Long id;
	
	@Column(name = "nome_usuario" , unique = true)
	@NotBlank(message = "Nome nÃ£o pode ser nulo")
	@Size(min = 1, max = 50, message = "Nome nÃ£o pode ser abaixo de {min} ou {max} Letras")
	private String nome;

	@Column
	@Email
	@Size(min = 5, max = 120, message = "Nome nÃ£o pode ser abaixo de {min} ou {max} Letras")
	private String email;
	
	@Column
	@NotBlank(message = "Senha não pode ser em branco")
	//@VERIFICAR SE TEM ALGUM TIPO DE VALIDAÃ‡ÃƒO PARA SENHA
	private String senha;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
