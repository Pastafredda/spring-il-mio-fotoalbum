package com.experis.project.springilmiofotoalbum.controller;

import com.experis.project.springilmiofotoalbum.service.MessaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/messaggi")
public class MessaggioController {

    @Autowired
    private MessaggioService messaggioService;

    @GetMapping
    public String index(Model model){
        model.addAttribute("listaMessaggi", messaggioService.getListaMessaggi());
        return "messaggi/index";
    }
}
