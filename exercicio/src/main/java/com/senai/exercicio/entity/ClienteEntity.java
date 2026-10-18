package com.senai.exercicio.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // tranforma esta classe em tabela no banco de dados.
@Table (name = "tab_cliente") // cria a tabela com o nome TAb_cliente
@NoArgsConstructor // cria construto vazio
@AllArgsConstructor // cria construtor completp
@Data //cria metodos GET e SEt

public class ClienteEntity {
    @Id // define o campo com chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increnimento
    private Long id;
    private  String nome;
    private String telefone;
    private String email;
    private String endereco;
}
