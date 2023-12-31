package com.experis.project.springilmiofotoalbum.controller;

import com.experis.project.springilmiofotoalbum.exception.FotoNotFoundException;
import com.experis.project.springilmiofotoalbum.model.Fotografia;
import com.experis.project.springilmiofotoalbum.service.CategoriaService;
import com.experis.project.springilmiofotoalbum.service.FotografiaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.Binding;
import java.util.Optional;

@Controller
@RequestMapping("/foto")
public class FotografiaController {

    @Autowired
    FotografiaService fotografiaService;

    @Autowired
    CategoriaService categoriaService;

    //lista e filtro attraverso il titolo
    @GetMapping
    public String index(@RequestParam Optional<String>search, Model model){
        model.addAttribute("list",fotografiaService.getFotoList(search));
        return "fotografie/index";
    }

    //pagina di dettaglio
    @GetMapping("/show/{id}")
    public String Show(@PathVariable Integer id,Model model){
        //prendo l'id della foto tramite il service
        try {
            Fotografia fotografia= fotografiaService.getFotoId(id);
            //tramite model passo l'oggetto al template
            model.addAttribute("fotografia", fotografia);
            //ritorno il template
            return "fotografie/show";
        } catch (FotoNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    //creazione
    @GetMapping("/create")
    public String create(Model model){
        //creazione di una nuova foto attualmente vuota
        model.addAttribute("fotografia", new Fotografia());
        //aggiungo la lista delle categorie
        model.addAttribute("categorie", categoriaService.getAll());
        return "fotografie/create";
    }

    //controller che prende i parametri in post
    //con il valid, validiamo le annotazioni della classe fotografia
    //bindingResult catcha gli errori
    //model attribute ci per ricaricare la pagina con i campi compilati in caso di errore
    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("fotografia") Fotografia fotografia, BindingResult bindingResult, Model model){
        //Se ci sono errori ricarico la pagina con il form compilato
        if (bindingResult.hasErrors()){
            //Aggiungo il model e richiamo la lista delle categorie in caso di errori
            model.addAttribute("categorie",categoriaService.getAll());
            return "fotografie/create";
        }
        Fotografia saveFoto = fotografiaService.saveFotoCreate(fotografia);
        return "redirect:/foto";
    }

    //modifica
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        try {
            //tramite model recupero l'id
            model.addAttribute("fotografia", fotografiaService.getFotoId(id));
            //come nella create richiamo la lista di categoria
            model.addAttribute("categorie", categoriaService.getAll());
            return "fotografie/edit";
        } catch (FotoNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("/edit/{id}")
    public String doEdit(@PathVariable Integer id, @Valid @ModelAttribute Fotografia fotografia, BindingResult bindingResult,Model model){
        //se ci sono errori nel compilare il form
        if (bindingResult.hasErrors()){
            //nel caso di errore la lista di categorie sparirebbe quindi la richiamiamo
            model.addAttribute("categorie", categoriaService.getAll());
            //ritorno il form
            return "fotografie/edit";
        }
        try {
            Fotografia saveFoto = fotografiaService.saveFotoEdit(fotografia);
             return "redirect:/foto/show/" + saveFoto.getId();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        //Se esiste la elimino altrimenti eccezione
        try {
            //recupero la foto con id
            Fotografia fotografia = fotografiaService.getFotoId(id);
            //la elimino
            fotografiaService.deleteFoto(id);
            //messaggio di avvenuta eliminazione
            redirectAttributes.addFlashAttribute("message", "la foto: " + fotografia.getTitolo()+ " è stata eliminata");
            //ritorno alla lista
            return "redirect:/foto";
        } catch (FotoNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
