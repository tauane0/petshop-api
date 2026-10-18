package com.senai.exercicio.repository;

import com.senai.exercicio.entity.FornecedoresEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface FornecedoresRepository extends JpaRepository<FornecedoresEntity, Long> {
    Optional<FornecedoresEntity> findByCnpj(String cnpj);

}
