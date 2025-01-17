package com.generation.steam.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity // indica que esta Classe será utilizada para gerar uma tabela no Banco de dados da aplicação.
@Table(name = "tb_produtos") // indica o nome da Tabela no Banco de dados
public class Produto {
	
	@Id //indica que o Atributo anotado será a Chave Primária da tabela tb_produtos
	@GeneratedValue(strategy = GenerationType.IDENTITY) // indica que a Chave Primária será gerada pelo Banco de dados
	private Long id; // criando Atributos da Classe Produto na tb_produtos

	@NotBlank(message = "O atributo nome é Obrigatório")
	@Size(min = 2, max = 100, message = "O atributo nome deve conter no minímo 02 e no máximo 100 caracteres")
	private String nome; //criando Atributos da Classe Produto na tb_produtos
	
	@NotBlank(message = "O atributo descrição é Obrigatório")
	private String descricao; //criando Atributos da Classe Produto na tb_produtos
	
	@NotNull(message = "O atributo preço é Obrigatório")	
	private Double preco; //criando Atributos da Classe Produto na tb_produtos

	@ManyToOne //indica que a Classe Produto será o lado N:1 e terá um Objeto(registro) da Classe Tema que será a Chave Estrangeira na Tabela tb_produtos(categoria_id)
	@JsonIgnoreProperties("produto")
	private Categoria categoria;
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return this.preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
		
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
			
}
