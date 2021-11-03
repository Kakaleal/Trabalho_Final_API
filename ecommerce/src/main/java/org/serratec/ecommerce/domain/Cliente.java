package org.serratec.ecommerce.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CPF;

//CLIENTE SERÁ A CLASSE COM LOGIN
//CLIENTE RECEBE UMA PK DE USUARIO PARA CONTER AS INFO QUE CONTÉM LÁ NOME/SOBRENOME ETC..
@Entity
public class Cliente{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Email
	private String email;
	
	@Column
	private String senha;
	
	@CPF
	private String cpf;
	
	/* RELACIONAMENTO DE UM PARA UM COM ENDERECO DO TIPO BI
	@OneToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	*/
	
	@OneToMany(mappedBy = "cliente")
	private List<Endereco> enderecos;
	
	//FETCH UTILIZADO PARA QUANDO FOR BUSCAR OS ENDERECOS TRAZER TODOS OS ENDERECOS
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;
	
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
