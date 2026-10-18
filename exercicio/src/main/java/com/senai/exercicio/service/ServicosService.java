package com.senai.exercicio.service;

import com.senai.exercicio.entity.ServicosEntity;
import com.senai.exercicio.repository.ServicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicosService {

    @Autowired
    private ServicosRepository repository;

    // READ - LISTAR TODOS OS SERVIÇOS
    public List<ServicosEntity> listarTodos() {
        return repository.findAll();
    }

    // INSERT - SALVAR UM SERVIÇO
    public ServicosEntity salvarServico(ServicosEntity servico) {
        if (repository.findByDescricao(servico.getDescricao()).isPresent()) {
            throw new IllegalArgumentException("Serviço já cadastrado.");
        }
        return repository.save(servico);
    }

    // UPDATE - PUT - ATUALIZAR DADOS
    public ServicosEntity atualizar(Long id, ServicosEntity servico) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Serviço não encontrado.");
        }
        servico.setId(id);
        return repository.save(servico);
    }

    // DELETE - DELETE - EXCLUIR DADOS
    public void excluirServicos(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("SERVIÇO NÃO ENCONTRADO! ACÉFALO");
        }
        repository.deleteById(id);
    }
}