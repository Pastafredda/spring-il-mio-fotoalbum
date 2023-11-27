package com.experis.project.springilmiofotoalbum.api;

import com.experis.project.springilmiofotoalbum.model.Fotografia;
import com.experis.project.springilmiofotoalbum.service.FotografiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/foto")
@CrossOrigin
public class FotoRestController {
    @Autowired
    FotografiaService fotografiaService;

    //lista di tutte le foto tramite service
    @GetMapping
    public List<Fotografia> index(@RequestParam Optional<String> searchString) {

        return fotografiaService.getFotoListApi(searchString);
    }

}
