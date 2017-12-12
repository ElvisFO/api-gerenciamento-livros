package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
