package com.senai.exercicio.controller;

import com.senai.exercicio.entity.FornecedoresEntity;
import com.senai.exercicio.entity.ProdutoEntity;
import com.senai.exercicio.repository.FornecedoresRepository;
import com.senai.exercicio.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fornecedores")

public class FornecedorController {

    @Autowired // Injeção de dependência do serviço de produtos
    private FornecedoresRepository fornecedoresRepository;

    // READ - LISTAR TODOS OS PRODUTOS
    @GetMapping
    public List<FornecedoresEntity> listar() {

        return fornecedoresRepository.findAll();
    }

    // INSERT - SALVAR UM PRODUTO
    //<Map<?, ?> é um tipo genérico que representa um mapa de chave-valor, onde a chave e o valor podem ser de qualquer tipo. Neste caso, ele é usado para retornar uma mensagem de sucesso após a operação de salvar um produto
    @PostMapping
    public ResponseEntity<Map<?, ?>> salvar(@RequestBody FornecedoresEntity fornecedor) {
        fornecedoresRepository.save(fornecedor);
        return ResponseEntity
                .status(HttpStatus.CREATED) // Retorna o status HTTP 201 (Created) indicando que o recurso foi criado com sucesso
                .body(Map.of("Mensagem", "Fornecedor cadastrado com sucesso.")); //.body(Map.of("Mensagem", "Fornecedor cadastrado com sucesso.")) cria um corpo de resposta contendo uma mensagem de sucesso em formato de mapa (chave-valor), onde a chave é "Mensagem" e o valor é "Fornecedor cadastrado com sucesso."
    }

    // UPDATE - PUT - ATUALIZAR DADOS
    @PutMapping("/{id}")
    public ResponseEntity<Map<?, ?>> atualizar(
            @PathVariable Long id, // @PathVariable é uma anotação que indica que o valor do parâmetro id será extraído da URL da requisição. Por exemplo, se a URL for /produtos/1, o valor 1 será atribuído ao parâmetro id
            @RequestBody FornecedoresEntity fornecedor) { //@RequestBody é uma anotação que indica que o corpo da requisição HTTP será convertido em um objeto FornecedoresEntity. Isso permite que os dados do fornecedor sejam enviados no corpo da requisição em formato JSON e mapeados para o objeto fornecedor

        fornecedoresRepository.save(fornecedor);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Fornecedor atualizado com sucesso."));
    }

    // DELETE - DELETE - EXCLUIR DADOS
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<?, ?>> excluirFornecedor(@PathVariable Long id) {
        fornecedoresRepository.deleteById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Fornecedor excluído com sucesso."));
    }
}

