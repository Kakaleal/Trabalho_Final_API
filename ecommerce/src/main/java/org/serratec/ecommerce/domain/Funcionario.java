package org.serratec.ecommerce.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codFuncionario;
	
	
	@NotBlank(message = "Nome completo ")
	@Size (max = 50)
	@Column(nullable = false, length = 7)
	private String nomeCompleto;
	
	@NotBlank(message = "Insira o CPF")
	@Size ( max = 11)
	@Column (nullable = false, length = 11)
	private String cpf;
	
	

}
