package com.senai.exercicio.controller;

import com.senai.exercicio.entity.ProdutoEntity;
import com.senai.exercicio.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService; // Nome da variável padronizado em minúsculo

    // READ - LISTAR TODOS OS PRODUTOS
    @GetMapping
    public List<ProdutoEntity> listar() {
        return produtoService.listarTodos();
    }

    // READ - BUSCAR PRODUTO POR ID (FALTAVA ESTA ROTA PARA O GET /produtos/{id})
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoEntity> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.buscarPorId(id));
    }

    // INSERT - SALVAR UM PRODUTO
    @PostMapping
    public ResponseEntity<Map<?, ?>> salvar(@RequestBody ProdutoEntity produto) {
        produtoService.salvarProduto(produto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem", "Produto cadastrado com sucesso."));
    }

    // UPDATE - PUT - ATUALIZAR DADOS
    @PutMapping("/{id}")
    public ResponseEntity<Map<?, ?>> atualizar(
            @PathVariable Long id,
            @RequestBody ProdutoEntity produto) {

        produtoService.atualizar(id, produto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Produto atualizado com sucesso."));
    }

    // DELETE - DELETE - EXCLUIR DADOS
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<?, ?>> excluirProduto(@PathVariable Long id) {
        produtoService.excluirProduto(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Produto excluído com sucesso."));
    }
}