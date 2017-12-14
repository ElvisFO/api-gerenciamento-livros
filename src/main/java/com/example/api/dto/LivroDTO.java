package com.example.api.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.api.model.Autor;
import com.example.api.model.Livro;

public class LivroDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotNull
	@Size(min=3, max=200)
	private String titulo;
	
	@NotNull
	@Size(min=3, max=200)
	private String editora;
	
	@NotNull
	private LocalDate dataDePublicacao;
	
	@NotNull
	private BigDecimal preco;
	
	private List<String> criticas = new ArrayList<>();
	
	@Size(min=1, message="Autor(es) do livro é obrigatório")
	private List<Autor> autores = new ArrayList<>();

	public LivroDTO(){}
	
	public LivroDTO(Livro livro)
	{
		this.titulo = livro.getTitulo();
		this.editora = livro.getEditora();
		this.dataDePublicacao = livro.getDataDePublicacao();
		this.preco = livro.getPreco();
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
	
}
