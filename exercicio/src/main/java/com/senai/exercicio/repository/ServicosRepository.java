package com.senai.exercicio.repository;

import com.senai.exercicio.entity.ServicosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface ServicosRepository extends JpaRepository<ServicosEntity, Long> {
    Optional<ServicosEntity> findByDescricao(String descricao); // será usado para buscar a descrição no banco de dados antes de realizar alguma operação.
}
