package com.experis.project.springilmiofotoalbum.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "fotografie")
public class Fotografia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titolo;
    @Lob
    private String descrizione;
    @Lob
    private String url;
    private boolean visibile;

    @ManyToMany
    private List<Categoria> categorie;

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
