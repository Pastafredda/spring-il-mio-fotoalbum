package com.experis.project.springilmiofotoalbum.service;

import com.experis.project.springilmiofotoalbum.model.Fotografia;
import com.experis.project.springilmiofotoalbum.repository.FotografiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FotografiaService {
    @Autowired
    FotografiaRepository fotografiaRepository;

    //metodo per la lista di tutte le fotografie
    public List<Fotografia> getFotoList(Optional<String> search){
        //se il parametro è presente filtro la lista per nome
        if (search.isPresent()){
            return fotografiaRepository.findByTitoloContainingIgnoreCase(search.get());
        }else {
            //altrimenti prendo tutta la lista
            return fotografiaRepository.findAll();
        }
    }
}
