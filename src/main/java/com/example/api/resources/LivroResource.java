package com.example.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.model.Livro;
import com.example.api.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroResource {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@GetMapping
	public List<Livro> findAll()
	{
		return livroRepository.findAll();
	}
	
	@GetMapping("/{isbn}")
	public ResponseEntity<?> findOne(@PathVariable Long isbn) 
	{
		Livro livro = livroRepository.findOne(isbn);
		return livro != null ? ResponseEntity.ok(livro) : ResponseEntity.notFound().build();
	}

}
