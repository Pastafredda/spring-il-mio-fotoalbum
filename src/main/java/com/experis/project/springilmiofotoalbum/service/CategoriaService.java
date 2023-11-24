package com.experis.project.springilmiofotoalbum.service;

import com.experis.project.springilmiofotoalbum.exception.CategoriaNomeException;
import com.experis.project.springilmiofotoalbum.exception.CategoriaNotFoundException;
import com.experis.project.springilmiofotoalbum.model.Categoria;
import com.experis.project.springilmiofotoalbum.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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

    //metodo per prendere l'id della categoria
    public Categoria getCategoriaId(Integer id)throws CategoriaNotFoundException{
        //con l'optional può esserci o meno l'id
        Optional<Categoria> result = categoriaRepository.findById(id);
        //se è presente
        if (result.isPresent()){
            //passo l'oggetto al template
            return result.get();
        }else{
            throw new CategoriaNotFoundException("id della categoria " + id + " non è stato trovato");
        }
    }

    //metodo per l'eliminazione
    public void deleteCategory(Integer id){
        categoriaRepository.deleteById(id);
    }

}
