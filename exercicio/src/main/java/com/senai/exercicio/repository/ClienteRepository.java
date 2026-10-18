package com.senai.exercicio.repository;


import com.senai.exercicio.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
// Serve para ir ao banco e dados e fazer alguma coisa sem que eu escreva o codigo para buscar um usuario.o.
//logo o Repository (JPA) busca as coisas (JPA) nem eu ter de buscar por conta propria.

public interface ClienteRepository  extends JpaRepository<ClienteEntity, Long> {
    // será usado para buscar o email no banco de dados antes de
    // realizar alguma operação.
    Optional<ClienteEntity>findByEmail(String Email);

}
