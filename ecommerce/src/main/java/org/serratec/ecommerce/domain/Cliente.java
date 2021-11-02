package org.serratec.ecommerce.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_cliente")
	private Long id;
	
	@Column(name = "nome_completo")
	@NotBlank(message = "Nome não pode ser nulo")
	@Size(max = 120, message = "Nome não pode ultrapassar {max} caracteres")
	private String nome;
	
	@Column
	@CPF
	private String cpf;
	
	@Column(name = "data_nascimento")
	private Date dataNascimento;
	
	//PROCURAR COMO UTILIZAR A API VIA CEP PARA VALIDAÃ‡ÃƒO DO ENDEREÃ‡O
	private String endereco;
	
	//FK DO NOME_USUARIO
	@OneToOne
	@JoinColumn(name = "fk_cod_usuario")
	private Usuario usuario;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}