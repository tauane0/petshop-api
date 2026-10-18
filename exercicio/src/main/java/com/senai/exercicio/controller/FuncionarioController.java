package com.senai.exercicio.controller;

import com.senai.exercicio.entity.FuncionarioEntity;
import com.senai.exercicio.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    // READ - LISTAR TODOS
    @GetMapping
    public List<FuncionarioEntity> listarTodos() {
        return service.listarTodos();
    }

    // READ - BUSCAR POR ID (ESTA É A ROTA QUE RESOLVE O ERRO 405)
    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioEntity> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    // INSERT - SALVAR
    @PostMapping
    public ResponseEntity<Map<?, ?>> salvar(@RequestBody FuncionarioEntity funcionario) {
        service.salvarFuncionario(funcionario);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Funcionário cadastrado com sucesso."));
    }

    // UPDATE - ATUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<Map<?, ?>> atualizar(
            @PathVariable Long id,
            @RequestBody FuncionarioEntity funcionario) {
        service.atualizar(id, funcionario);
        return ResponseEntity
                .ok(Map.of("mensagem", "Funcionário atualizado com sucesso."));
    }

    // DELETE - EXCLUIR
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<?, ?>> excluir(@PathVariable Long id) {
        service.excluirFuncionario(id);
        return ResponseEntity
                .ok(Map.of("mensagem", "Funcionário excluído com sucesso."));
    }
}