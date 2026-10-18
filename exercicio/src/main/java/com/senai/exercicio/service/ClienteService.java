package com.senai.exercicio.service;

import com.senai.exercicio.entity.ClienteEntity;
import com.senai.exercicio.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    // READ - LISTAR TODOS OS CLIENTES
    public List<ClienteEntity> listarTodos() {

        return repository.findAll();
    }

    // INSERT - SALVAR UM CLIENTE
    public ClienteEntity salvarCliente(ClienteEntity cliente) {
        if (repository.findByEmail(cliente.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Cliente já cadastrado.");
        }
        return repository.save(cliente);
    }

    // UPDATE - PUT - ATUALIZAR DADOS
    public ClienteEntity atualizar(Long id, ClienteEntity cliente) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Cliente não encontrado.");
        }
        cliente.setId(id);
        return repository.save(cliente);
    }

    // DELETE - DELETE - EXCLUIR DADOS
    public void excluirCliente(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("CLIENTE NÃO ENCONTRADO! ACÉFALO");
        }
        repository.deleteById(id);
    }
}
