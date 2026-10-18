package com.senai.exercicio.service;

import com.senai.exercicio.entity.ProdutoEntity;
import com.senai.exercicio.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    // READ - LISTAR TODOS
    public List<ProdutoEntity> listarTodos() {
        return repository.findAll();
    }

    // READ - BUSCAR POR ID (ADICIONE ESTE MÉTODO)
    public ProdutoEntity buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado."));
    }

    // INSERT - SALVAR PRODUTO
    public ProdutoEntity salvarProduto(ProdutoEntity produto) {
        return repository.save(produto);
    }

    // UPDATE - ATUALIZAR PRODUTO
    public ProdutoEntity atualizar(Long id, ProdutoEntity produto) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Produto não encontrado.");
        }
        produto.setId(id);
        return repository.save(produto);
    }

    // DELETE - EXCLUIR PRODUTO
    public void excluirProduto(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Produto não encontrado.");
        }
        repository.deleteById(id);
    }
}