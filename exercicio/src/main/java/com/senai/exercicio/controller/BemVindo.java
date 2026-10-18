package com.senai.exercicio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")

// ENPOINTS  - caminhos web
public class BemVindo {
    @GetMapping
    public String mensagem () {
        return "<H1>BEM-VINDO! Olá visitante. </H1>";
    }

    @GetMapping("/dev")
    public String dev() {
        return " <H2>Desenvolvedora Tauane Borges.</H2>";
    }
}
