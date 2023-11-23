package com.experis.project.springilmiofotoalbum.controller;

import com.experis.project.springilmiofotoalbum.service.FotografiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/foto")
public class FotografiaController {

    @Autowired
    FotografiaService fotografiaService;

    @GetMapping
    public String index(@RequestParam Optional<String>search, Model model){
        model.addAttribute("list",fotografiaService.getFotoList(search));
        return "fotografie/index";
    }
}
