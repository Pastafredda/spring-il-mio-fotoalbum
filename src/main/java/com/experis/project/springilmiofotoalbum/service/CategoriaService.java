package com.experis.project.springilmiofotoalbum.service;

import com.experis.project.springilmiofotoalbum.exception.CategoriaNomeException;
import com.experis.project.springilmiofotoalbum.model.Categoria;
import com.experis.project.springilmiofotoalbum.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    //lista delle categorie in ordine
    public List<Categoria> getAll(){
        return categoriaRepository.findByOrderByNome();
    }

    //metodo per salvare una nuova categoria
    public Categoria save(Categoria categoria) throws CategoriaNomeException{
        //se il nome della categoria esiste già
        if (categoriaRepository.existsByNome(categoria.getNome())){
            //tiro un eccezione
            throw new CategoriaNomeException(categoria.getNome());
            //altrimenti
        }else {
            //trasformo il nome in minuscolo
            categoria.setNome(categoria.getNome().toLowerCase());
            //salvo sul database
            return categoriaRepository.save(categoria);
        }
    }

}
