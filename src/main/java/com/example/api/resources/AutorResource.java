package com.example.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.model.Autor;
import com.example.api.repository.AutorRepository;

@RestController
@RequestMapping("/autores")
public class AutorResource {
	
	@Autowired
	private AutorRepository autorRepository;
	
	@GetMapping
	public List<Autor> findAll()
	{
		return autorRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findOne(@PathVariable Long id) 
	{
		Autor autor = autorRepository.findOne(id);
		return autor != null ? ResponseEntity.ok(autor) : ResponseEntity.notFound().build();
	}


}
