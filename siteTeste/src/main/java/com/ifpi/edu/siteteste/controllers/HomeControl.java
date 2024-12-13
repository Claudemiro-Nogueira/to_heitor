package com.ifpi.edu.siteteste.controllers;


import com.ifpi.edu.siteteste.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class HomeControl {

//  Criação de uma lista de usuários
    List<Usuario> listaUsuarios = new ArrayList<>();


//
    @GetMapping("/home")
    public String home( Model model ) {
        model.addAttribute("user", new Usuario());
        return "home";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Usuario a, Model model) {
        listaUsuarios.add(a);
        String var = a.toString();
        System.out.println(var);
        return "redirect:/usuarios/home";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("userList", listaUsuarios);
        return "listaProdutos";
    }

    @DeleteMapping("/{id}/deletar")
    public String deletar(@PathVariable String id) {
        listaUsuarios.removeIf(p -> p.getEmail().equals(id));
        return "redirect:/usuarios/listar";
    }






}
