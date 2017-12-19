package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
