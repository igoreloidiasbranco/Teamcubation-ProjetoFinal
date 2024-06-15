package com.futebol.partidas.dto.response;

import com.futebol.partidas.dto.Sigla;
import com.futebol.partidas.entity.ClubeEntity;

import java.time.LocalDate;

public record ClubeResponseDTO(Long id, String nome, Sigla sigla, LocalDate data, Boolean ativo) {

    public ClubeResponseDTO(ClubeEntity clubeEntity) {
        this(clubeEntity.getId(), clubeEntity.getNome(), clubeEntity.getSigla(),
                clubeEntity.getData(),clubeEntity.getAtivo());
    }
}
