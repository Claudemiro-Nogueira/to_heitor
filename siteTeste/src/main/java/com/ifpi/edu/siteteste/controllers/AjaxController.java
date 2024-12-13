package com.ifpi.edu.siteteste.controllers;

import com.ifpi.edu.siteteste.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/ajax")
public class AjaxController {

    private List<Usuario> userList;


    public AjaxController() {
        this.userList = new ArrayList<>();
    }

    @GetMapping("/exemplo")
    public String exemploAjax() {
        return "exemploAjax";
    }

    @GetMapping("/exemploHTMX")
    public String exemploAjaxHTMX() {
        return "exemploAjaxHTMX";
    }

    @PostMapping("/submit")
    public String submitForm(@RequestParam String name, @RequestParam String email, Model model) {

        Usuario user = new Usuario();
        user.setNome(name);
        user.setEmail(email);
        userList.add(user);
        model.addAttribute("users", userList);


        return "fragments/clienteInfo :: informacoes";
    }
}
