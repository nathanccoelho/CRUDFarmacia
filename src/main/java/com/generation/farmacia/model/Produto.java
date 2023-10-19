package com.generation.farmacia.model;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table (name= "tb_produtos")
public class Produto {

	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank (message = "O atributo nome é obrigatório!")
	@Size(min = 2, max = 40, message = "O atributo nome tem no mínimo 2 e no máximo 40 caracteres!")
	private String nome;
	
	@NotBlank
	@Size (min=5, max =5000, message = "O atributo foto deve conter no mínimo 5 e no máximo 5000 catacteres!")
	private String foto;
	
	@Digits (integer = 5, fraction = 2, message = "O atributo price deve conter um valos 3 antes da vírgula e 2 depois.")
	private BigDecimal preco;
	
	@NotBlank (message = "O atributo descrição é obrigatório!")
	@Size(min = 2, max = 600, message = "O atributo descrição tem no mínimo 2 e no máximo 600 caracteres!")
	private String descricao;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;

	
	// Getters and Setters;
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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}