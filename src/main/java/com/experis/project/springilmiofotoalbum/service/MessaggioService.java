package com.experis.project.springilmiofotoalbum.service;

import com.experis.project.springilmiofotoalbum.model.Messaggio;
import com.experis.project.springilmiofotoalbum.repository.MessaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessaggioService {

    @Autowired
    private MessaggioRepository messaggioRepository;

    public Messaggio create(Messaggio messaggio){
        return messaggioRepository.save(messaggio);
    }

    public List<Messaggio>getListaMessaggi(){
        return messaggioRepository.findAll();
    }
}
