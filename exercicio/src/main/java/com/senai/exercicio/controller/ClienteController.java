package com.senai.exercicio.controller;

import com.senai.exercicio.entity.ClienteEntity;
import com.senai.exercicio.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    // READ - LISTAR TODOS OS CLIENTES
    @GetMapping
    public List<ClienteEntity> listar() {

        return service.listarTodos();
    }

    // INSERT - SALVAR UM CLIENTE
    @PostMapping
    public ResponseEntity<Map<?, ?>> salvar(@RequestBody ClienteEntity cliente) {
        service.salvarCliente(cliente);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem", "Cliente cadastrado com sucesso."));
    }

    // UPDATE - PUT - ATUALIZAR DADOS
    @PutMapping("/{id}")
    public ResponseEntity<Map<?, ?>> atualizar(
            @PathVariable Long id,
            @RequestBody ClienteEntity cliente) {

        service.atualizar(id, cliente);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Cliente atualizado com sucesso."));
    }

    // DELETE - DELETE - EXCLUIR DADOS
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<?, ?>> excluir(@PathVariable Long id) {
        service.excluirCliente(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Cliente excluído com sucesso."));
    }
}
