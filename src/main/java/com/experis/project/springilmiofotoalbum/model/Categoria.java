package com.experis.project.springilmiofotoalbum.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "categorie")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Il campo non può essere vuoto")
    @Column(nullable = false, unique = true)
    private String nome;

    @ManyToMany(mappedBy = "categorie")
    private List<Fotografia> fotografie;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Fotografia> getFotografie() {
        return fotografie;
    }

    public void setFotografie(List<Fotografia> fotografie) {
        this.fotografie = fotografie;
    }
}
