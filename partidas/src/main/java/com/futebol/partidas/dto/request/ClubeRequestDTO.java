package com.futebol.partidas.dto.request;

import com.futebol.partidas.dto.Sigla;

import java.time.LocalDate;

public record ClubeRequestDTO(String nome, Sigla sigla, LocalDate data, Boolean ativo) {
}
