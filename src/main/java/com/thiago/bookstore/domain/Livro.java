/* Motivo por se usar o JPA em um projeto:
 * Não apenas pelas ofertas de persistência, ele também
 * é usado para criar pequenas funcionalidades de banco de dados
 * para que não precisemos criar tudo na mão.
 */
package com.thiago.bookstore.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Livro implements Serializable{
	
	//1L é o valor padrão gerado para a serialVersion
	private static final long serialVersionUID = 1L; 
	
	// Variáveis
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private String nomeAutor;
	private String texto;

	// Iniciando a conexão
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	// Construtor sem parâmetros da superclasse
	public Livro() {
		super();
	}
	
	/*
	 * Construtor com parâmetros -> Neste a variável categoria foi posta pois ela
	 * não é um array
	 */
	public Livro(Integer id, String titulo, String nomeAutor, String texto, Categoria categoria) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.nomeAutor = nomeAutor;
		this.texto = texto;
		this.categoria = categoria;
	}
	// Construtor com parâmetros --

	// Acessores e modificadores ---
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	// Acessores e modificadores ---

	// Hashcode e Equals---
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
		Livro other = (Livro) obj;
		return Objects.equals(id, other.id);
	}
	// Hashcode e Equals---

}
