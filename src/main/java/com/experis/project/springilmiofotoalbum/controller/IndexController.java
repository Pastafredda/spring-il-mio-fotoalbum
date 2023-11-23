package com.experis.project.springilmiofotoalbum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
    //redirect alla pagina delle foto quando andiamo in localhost
    @GetMapping
    public String home(){
        return "redirect:/foto";
    }
}
