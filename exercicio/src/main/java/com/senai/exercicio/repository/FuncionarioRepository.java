package com.senai.exercicio.repository;

import com.senai.exercicio.entity.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Long> {

    Optional<FuncionarioEntity> findByEmail(String email);
}