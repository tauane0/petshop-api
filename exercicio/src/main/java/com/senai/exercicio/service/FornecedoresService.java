package com.senai.exercicio.service;

import com.senai.exercicio.entity.FornecedoresEntity;
import com.senai.exercicio.repository.FornecedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class FornecedoresService {
    @Autowired
    private FornecedoresRepository repository;

    // READ - LISTAR TODOS OS FORNECEDORES
    public List<FornecedoresEntity> listarTodos() {
        return repository.findAll();
    }

    // INSERT - SALVAR  FORNECEDOR
    public FornecedoresEntity salvarFornecedor(FornecedoresEntity fornecedor) {
        if (repository.findByCnpj(fornecedor.getCnpj()).isPresent()) {
            throw new IllegalArgumentException("Fornecedor já cadastrado.");
        }
        return repository.save(fornecedor);
    }

    // UPDATE - PUT - ATUALIZAR DADOS
    public FornecedoresEntity atualizar(Long id, FornecedoresEntity fornecedores) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Fornecedor não encontrado.");
        }
        fornecedores.setId(id);
        return repository.save(fornecedores);
    }

    // DELETE - DELETE - EXCLUIR DADOS
    public void excluirFornecedor(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("FORNECEDOR NÃO ENCONTRADO!");
        }
        repository.deleteById(id);
    }
}