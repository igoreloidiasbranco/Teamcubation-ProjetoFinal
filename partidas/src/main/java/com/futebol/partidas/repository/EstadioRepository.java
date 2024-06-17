package com.futebol.partidas.repository;

import com.futebol.partidas.entity.EstadioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadioRepository extends JpaRepository<EstadioEntity, Long> {

    boolean existsByNome(String nome);
}
