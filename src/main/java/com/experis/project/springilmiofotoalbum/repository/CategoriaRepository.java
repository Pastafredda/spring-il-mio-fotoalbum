package com.experis.project.springilmiofotoalbum.repository;

import com.experis.project.springilmiofotoalbum.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    //restituisco la lista di ogni categoria
    List<Categoria> findByOrderByNome();

    boolean existsByNome(String nome);
}
