package com.experis.project.springilmiofotoalbum.controller;

import com.experis.project.springilmiofotoalbum.exception.CategoriaNomeException;
import com.experis.project.springilmiofotoalbum.exception.CategoriaNotFoundException;
import com.experis.project.springilmiofotoalbum.model.Categoria;
import com.experis.project.springilmiofotoalbum.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/categorie")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    //gestiamo il form e la lista di categorie nella stessa pagina
    @GetMapping
    public String index(Model model){
        //prendo la lista di categorie
        model.addAttribute("categorie", categoriaService.getAll());
        //stesso da qui mi creo una nuova categoria
        model.addAttribute("categoria",new Categoria());
        //ritorno il template
        return "/categorie/index";
    }

    //creazione della nuova categoria
    @PostMapping
    public String doSave(@Valid @ModelAttribute Categoria categoria, BindingResult bindingResult, Model model){
        //se ci sono errori
        if (bindingResult.hasErrors()){
            //ricarico il form compilato
            model.addAttribute("categorie", categoriaService.getAll());
            //ricarico il template
            return "/categorie/index";
        }
        try {
            //salvo la nuova categoria tramite il service
            categoriaService.save(categoria);
            //ricarico la pagina
            return "redirect:/categorie";
        } catch (CategoriaNomeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"La categoria con il nome: " + categoria.getNome() + " esiste già" );
        }
    }

    //eliminazione categoria
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        try {
            //prendo l'id della categoria
            Categoria categoriaDelete= categoriaService.getCategoriaId(id);
            //se esiste lo elimino
            categoriaService.deleteCategory(id);
            //messaggio di eliminazione
            redirectAttributes.addFlashAttribute("message", "la categoria: " + categoriaDelete.getNome() + " è stata eliminata");
            //redirect
            return "redirect:/categorie";
        } catch (CategoriaNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

    }
}
