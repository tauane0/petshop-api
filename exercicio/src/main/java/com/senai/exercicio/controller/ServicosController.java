package com.senai.exercicio.controller;

import com.senai.exercicio.entity.ServicosEntity;
import com.senai.exercicio.service.ServicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicosController {

    @Autowired
    private ServicosService servicosService; // Nome padronizado para evitar confusão

    // READ - LISTAR TODOS OS SERVIÇOS
    @GetMapping
    public List<ServicosEntity> listar() {
        return servicosService.listarTodos();
    }

    // INSERT - SALVAR UM SERVIÇO
    @PostMapping
    public ResponseEntity<ServicosEntity> salvar(@RequestBody ServicosEntity servico) {
        ServicosEntity servicoSalvo = servicosService.salvarServico(servico);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(servicoSalvo);
    }

    // UPDATE - PUT - ATUALIZAR DADOS
    @PutMapping("/{id}")
    public ResponseEntity<ServicosEntity> atualizar(
            @PathVariable Long id,
            @RequestBody ServicosEntity servico) {
        ServicosEntity servicoAtualizado = servicosService.atualizar(id, servico);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(servicoAtualizado);
    }

    // DELETE - DELETE - EXCLUIR DADOS
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        servicosService.excluirServicos(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}