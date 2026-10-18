package com.senai.exercicio.service;

import com.senai.exercicio.entity.PetEntity;
import com.senai.exercicio.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository repository;

    // READ - LISTAR TODOS OS PETS
    public List<PetEntity> listarTodos() {
        return repository.findAll();
    }

    // INSERT - SALVAR UM PET
    public PetEntity salvarPet(PetEntity pet) {
        return repository.save(pet);
    }

    // UPDATE - PUT - ATUALIZAR DADOS
    public PetEntity atualizar(Long id, PetEntity pet) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Pet não encontrado.");
        }
        pet.setId(id);
        return repository.save(pet);
    }

    // DELETE - DELETE - EXCLUIR DADOS
    public void excluirPet(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("PET NÃO ENCONTRADO!");
        }
        repository.deleteById(id);
    }
}