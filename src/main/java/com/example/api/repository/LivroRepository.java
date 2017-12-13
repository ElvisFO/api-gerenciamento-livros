package com.example.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.api.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

	@Query(nativeQuery=true, value="SELECT * FROM livro l inner " + 
			"join livro_autor la on l.isbn = la.livro_isbn " + 
			"inner join autor a on a.id = la.autor_id " + 
			"where a.nome like %:nome%")
	List<Livro> searchByAuthor(@Param("nome") String nome);
}
