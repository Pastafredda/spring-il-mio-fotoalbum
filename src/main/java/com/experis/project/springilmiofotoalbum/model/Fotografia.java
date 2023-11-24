package com.experis.project.springilmiofotoalbum.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "fotografie")
public class Fotografia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Questo campo non può essere vuoto")
    @Size(min= 3,max = 24, message = "Inserisci un titolo tra i 3 e i 255 caratteri")
    private String titolo;
    @Lob
    @NotBlank(message = "La descrizione non può essere vuota")
    @Size(min = 3, max = 255, message = "Inserisci una descrizione tra i 3 e i 255 caratteri")
    private String descrizione;
    @Lob
    @NotBlank(message = "Questo campo non può essere vuoto")
    private String url;
    private boolean visibile;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Categoria> categorie;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Categoria> getCategorie() {
        return categorie;
    }

    public void setCategorie(List<Categoria> categorie) {
        this.categorie = categorie;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isVisibile() {
        return visibile;
    }

    public void setVisibile(boolean visibile) {
        this.visibile = visibile;
    }
}
