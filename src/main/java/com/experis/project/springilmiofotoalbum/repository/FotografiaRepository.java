package com.experis.project.springilmiofotoalbum.repository;

import com.experis.project.springilmiofotoalbum.model.Fotografia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FotografiaRepository extends JpaRepository<Fotografia,Integer> {
    //query per filtrare le foto per nome
    List<Fotografia> findByTitoloContainingIgnoreCase(String nameKeyword);

    //metodo per ricerca per titolo tramite visibilità

    List<Fotografia> findByTitoloContainingIgnoreCaseAndVisibileTrue(String nameKeyword);
    //metodo per la lista di tutte le foto per visibilità
    List<Fotografia> findByVisibileTrue();

}
