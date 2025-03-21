package com.example.sistemavendas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class ControllerMain {
    @GetMapping("/administrativo")
    public String acessoPrincipal() {
        return "administrativo/home";
    }
}
