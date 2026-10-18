package com.senai.exercicio.controller;

import com.senai.exercicio.entity.PetEntity;
import com.senai.exercicio.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pets")

public class PetController {

    @Autowired
    private PetService service;

    // GET - LISTAR TODOS OS PETS
    @GetMapping
    public List<PetEntity> listar() {
        return service.listarTodos();
    }


    // INSERT - SALVAR UM PET
    @PostMapping
    public ResponseEntity<PetEntity> salvar(@RequestBody PetEntity pet) {
        service.salvarPet(pet);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(pet);
    }

    // UPDATE - PUT - ATUALIZAR DADOS
    @PutMapping("/{id}")
    public ResponseEntity<Map<?, ?>> atualizar(
            @PathVariable Long id,
            @RequestBody PetEntity pet) {

        service.atualizar(id, pet);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Pet atualizado com sucesso."));
    }

    // DELETE - DELETE - EXCLUIR DADOS
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<?, ?>> excluir(@PathVariable Long id) {
        service.excluirPet(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Pet excluído com sucesso."));
    }
}