package com.futebol.partidas.dto.response;

import com.futebol.partidas.dto.Sigla;

import java.time.LocalDate;

public record ClubeResponseDTO(Long id, String nome, Sigla sigla, LocalDate data, Boolean ativo) {
}
