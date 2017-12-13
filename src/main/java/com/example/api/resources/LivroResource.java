package com.example.api.resources;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.event.RecursoCriadoEvent;
import com.example.api.model.Livro;
import com.example.api.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroResource {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
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
	
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody Livro livro, HttpServletResponse response)
	{
		Livro livroSalvo = livroRepository.save(livro);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, livro.getIsbn()));
		return ResponseEntity.status(HttpStatus.CREATED).body(livroSalvo);
	}
	
	@DeleteMapping("/{isbn}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long isbn)
	{
		livroRepository.delete(isbn);
	}
	
	@GetMapping("/page")
	public ResponseEntity<?> searchByAutor(@RequestParam(value="nome", defaultValue="") String nome)
	{
		List<Livro> livros = livroRepository.searchByAuthor(nome);
		return ResponseEntity.ok(livros);
	}

}
