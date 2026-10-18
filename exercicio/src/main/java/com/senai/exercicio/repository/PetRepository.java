package com.senai.exercicio.repository;

import com.senai.exercicio.entity.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PetRepository  extends JpaRepository<PetEntity, Long> {

}
