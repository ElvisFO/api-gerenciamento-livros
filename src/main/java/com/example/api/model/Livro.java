package com.example.api.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.api.conversor.CurrencyWriter;

@Entity
@Table(name="livro")
public class Livro implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull
	private Long isbn;
	
	@NotNull
	@Size(min=3, max=200)
	private String titulo;
	
	@NotNull
	@Size(min=3, max=200)
	private String editora;
	
	@Column(name="data_publicacao")
	@NotNull
	private LocalDate dataDePublicacao;
	
	@NotNull
	private BigDecimal preco;
	
	@ElementCollection
	@CollectionTable(name="critica")
	private List<String> criticas = new ArrayList<>();
	
	@Size(min=1, message="Autor(es) do livro é obrigatório")
	@ManyToMany
	@JoinTable(name="livro_autor", 
		joinColumns = @JoinColumn(name="livro_isbn"),
		inverseJoinColumns = @JoinColumn(name="autor_id"))
	private List<Autor> autores = new ArrayList<>();
	
	public Livro() {
		super();
	}

	public Livro(Long isbn, String titulo, String editora, LocalDate dataDePublicacao, BigDecimal preco) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.editora = editora;
		this.dataDePublicacao = dataDePublicacao;
		this.preco = preco;
	}

	public Long getIsbn() {
		return isbn;
	}

	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public LocalDate getDataDePublicacao() {
		return dataDePublicacao;
	}

	public void setDataDePublicacao(LocalDate dataDePublicacao) {
		this.dataDePublicacao = dataDePublicacao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	public String getPrecoPorExtenso()
	{
		String precoPorExtenso = "";
		CurrencyWriter cw = CurrencyWriter.getInstance();
		precoPorExtenso = cw.write(preco);
		return precoPorExtenso;
	}

	public List<String> getCriticas() {
		return criticas;
	}

	public void setCriticas(List<String> criticas) {
		this.criticas = criticas;
	}
	
	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
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
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}
	

}
