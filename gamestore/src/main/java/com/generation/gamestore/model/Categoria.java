package com.generation.gamestore.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

//Entidade JPA
@Entity
@Table(name = "tb_categorias") //Nome da tabela no banco de dados
public class Categoria {

	//ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//Nome da categoria
	@NotBlank(message = "O atributo categoria é obrigatório!") //Não pode estar vazio
	@Size(min = 5, max = 75, message = "O atributo categoria deve conter de 05-75 caracteres") //Tamanho
	private String nomecategoria;
	
	//Cardinalidade do relacionamento - One to Many/Um para Muitos
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria", cascade = CascadeType.REMOVE)
	@JsonIncludeProperties("categoria")
	private List<Produto> produto;

	//Getters e Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomecategoria() {
		return nomecategoria;
	}

	public void setNomecategoria(String nomecategoria) {
		this.nomecategoria = nomecategoria;
	}
	
	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	
}
