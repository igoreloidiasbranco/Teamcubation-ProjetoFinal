package com.futebol.partidas.repository;

import com.futebol.partidas.dto.Sigla;
import com.futebol.partidas.entity.ClubeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubeRepository extends JpaRepository<ClubeEntity, Long> {

    boolean existsByNomeAndSigla(String nome, Sigla sigla);
}
