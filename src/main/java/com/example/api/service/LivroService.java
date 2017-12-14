package com.example.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.api.dto.LivroDTO;
import com.example.api.model.Livro;
import com.example.api.repository.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	public Livro save(Livro livro)
	{
		return livroRepository.save(livro);
	}

	public Livro update(String isbn, LivroDTO livroDTO)
	{
		Livro livroSalvo = livroRepository.findOne(isbn);
		if(livroSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		this.updateData(livroSalvo, livroDTO);
		return livroRepository.save(livroSalvo);
	}
	
	public List<Livro> searchByAuthor(String nome)
	{
		List<Livro> livros = livroRepository.searchByAuthor(nome);
		return livros;
	}
	
	public void delete(String isbn) 
	{
		livroRepository.delete(isbn);
	}
	
	public Livro findOne (String isbn)
	{
		return livroRepository.findOne(isbn);
	}
	
	public List<Livro> findAll()
	{
		return livroRepository.findAll();
	}
	
	private void updateData(Livro livro, LivroDTO livroDTO)
	{
		livro.setTitulo(livroDTO.getTitulo());
		livro.setEditora(livroDTO.getEditora());
		livro.setDataDePublicacao(livroDTO.getDataDePublicacao());
		livro.setPreco(livroDTO.getPreco());
		livro.setAutores(livroDTO.getAutores());
	}

}
