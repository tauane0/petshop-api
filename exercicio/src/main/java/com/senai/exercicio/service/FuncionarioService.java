package com.senai.exercicio.service;

import com.senai.exercicio.entity.FuncionarioEntity;
import com.senai.exercicio.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    // READ - LISTAR TODOS OS FUNCIONÁRIOS
    public List<FuncionarioEntity> listarTodos() {
        return repository.findAll();
    }

    // READ - BUSCAR FUNCIONÁRIO POR ID (ESTAVA FALTANDO ESTE MÉTODO)
    public FuncionarioEntity buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Funcionário não encontrado."));
    }

    // INSERT - SALVAR UM FUNCIONÁRIO
    // INSERT - SALVAR UM FUNCIONÁRIO
    public FuncionarioEntity salvarFuncionario(FuncionarioEntity funcionario) {
        // Verifica se já existe um funcionário com esse e-mail
        if (repository.findByEmail(funcionario.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Já existe um funcionário cadastrado com este e-mail.");
        }
        return repository.save(funcionario);
    }


    // UPDATE - PUT - ATUALIZAR DADOS
    public FuncionarioEntity atualizar(Long id, FuncionarioEntity funcionario) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Funcionário não encontrado.");
        }
        funcionario.setId(id);
        return repository.save(funcionario);
    }

    // DELETE - DELETE - EXCLUIR DADOS
    public void excluirFuncionario(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("FUNCIONÁRIO NÃO ENCONTRADO!");
        }
        repository.deleteById(id);
    }
}