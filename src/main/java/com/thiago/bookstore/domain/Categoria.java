/*
 * Dicas: 
 * -> CTRL + SHIFT + S para criar todos os tipos de métodos (hashcode, 
 * getters and setters e até mesmo outros tipos de funcionalidades...
 * -> CTRL + D deleta uma linha inteira
 * -> CTRL + SHIFT + O arruma as importações 
 * -> CTRL + SHIFT + F para arrumar automaticamente o código
 * 
 */
package com.thiago.bookstore.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany; 

/*
 * Sobre o @Entity: 
 * Ele irá basicamente dizer para o JPA  e o Hibernate que esta classe
 * é uma entidade, que pode criar uma tabela para nossa base de dados, tanto que você pode 
 * até mesmo instanciar ao lado dela o nome da tabela, se for de seu desejo.
 * 
 * Mas caso isso não seja feito, a tabela será criada com o próprio nome da classe.
 */
@Entity
public class Categoria implements Serializable{
	
	//1L é o valor padrão gerado para a serialVersion
	private static final long serialVersionUID = 1L; 
	//Variáveis
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;
	
	@OneToMany(mappedBy = "categoria")
	//Declaração do array de Livro --
	private List<Livro> livros = new ArrayList<>();

	public Categoria() {
		super();
	}

	/* Sobre este construtor:
	 * Não selecionamos livros por que quando formos instanciar uma categoria não
	 * precisamos passar um array de livros
	 */
	public Categoria(Integer id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	// Getters and Setters -> Acessores e modificadores de uma forma mais simples
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	/* Sobre o Hash e o equals:
	 * O hashcode e o equals vão ser usados para fazer a comparação dos dados da
	 * variável em memória (Comparar os ids)
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(id, other.id);
	}

}
