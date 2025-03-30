package com.example.sistemavendas.controllers;

import com.example.sistemavendas.models.Estado;
import com.example.sistemavendas.repository.EstadoRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class EstadoController {

    @Autowired
    private EstadoRepositories estadoRepositories;

    @GetMapping("/cadastroEstado")
    public ModelAndView cadastrarEstado(Estado estado) {
        ModelAndView mv = new ModelAndView("administrativo/estado/cadastro");


    mv.addObject("estado", estado);
    return mv;
    }
    //salvando estado
    @PostMapping("/salvarEstado")
    public ModelAndView salvarEstado(Estado estado) {
        estadoRepositories.saveAndFlush(estado);
        return cadastrarEstado(new Estado());
    }
    @GetMapping("/editarEstado/{id}")
    public ModelAndView editarEstado(@PathVariable Long id) {
        Optional<Estado> estado = estadoRepositories.findById(id);
        return cadastrarEstado(estado.get());
    }

    @GetMapping("/removerEstado/{id}")
    public ModelAndView removerEstado(@PathVariable Long id) {
        Optional<Estado> estado = estadoRepositories.findById(id);
        estadoRepositories.delete(estado.get());
        return listarEstados();
    }



    @GetMapping("/listarEstados")
    public ModelAndView listarEstados() {
        ModelAndView mv = new ModelAndView("administrativo/estado/lista");
        mv.addObject("listaEstados", estadoRepositories.findAll());
        return mv;
    }

}
