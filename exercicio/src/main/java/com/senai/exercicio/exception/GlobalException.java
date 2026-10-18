package com.senai.exercicio.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

// PACOTE EXCEPTION:
// Centraliza o tratamento global de erros da aplicação.
// Converte exceções internas em respostas HTTP padronizadas e amigáveis (JSON),
// garantindo segurança, organização e evitando vazamento de dados sensíveis.

@RestControllerAdvice
public class GlobalException {

    //mostra a mensagem d erro mais amigavel.
    //a mensagem sera definida no pacote service.
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgumentException(IllegalArgumentException erro) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("mensagem", erro.getMessage()));
    }
}