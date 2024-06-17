package com.futebol.partidas.dto.response;

import com.futebol.partidas.dto.Sigla;

public record EstadioResponseDTO(Long id, String nome, Sigla sigla) {
}
