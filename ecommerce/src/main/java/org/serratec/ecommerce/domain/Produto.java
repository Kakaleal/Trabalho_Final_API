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

import org.springframework.lang.Nullable;

@Entity
public class Produto {
		  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codProduto;
	
	@NotBlank(message = "Nome do produto")
	@Size(max = 50)
	@Column(nullable = false, length = 50)
	private String nomeProduto;
	
	@NotBlank(message = "Descrição do produto")
	@Size(max = 200)
	@Column(nullable = false, length = 200)
	private String decricao;
	
	@NotBlank(message = "Quantidade em estoque")
	@Column (nullable = false)
	private float qtdEstoque;
	
	@NotBlank(message = "Data de fabricação")
	@Column(nullable = false)
	private Date dataFabricacao;
	
	@NotBlank(message = "Valor unitário")
	@Column (nullable = false)
	private float valor_unitario;
	
	@OneToOne
	@JoinColumn(name = "codCategoria") /* CHAVE ESTRANGEIRA fk_cod_catergoria */
	private Categoria categoria;
	
	
	
	


}
