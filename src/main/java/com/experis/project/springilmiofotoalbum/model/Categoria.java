package com.experis.project.springilmiofotoalbum.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categorie")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    @ManyToMany(mappedBy = "categorie")
    private List<Fotografia> fotografie;
}
