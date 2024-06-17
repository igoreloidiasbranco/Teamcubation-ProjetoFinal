package com.futebol.partidas.dto.request;

import com.futebol.partidas.dto.Sigla;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record EstadioRequestDTO(

        @NotBlank
        @Pattern(regexp = "^.{3,}$")
        String nome,

        Sigla sigla) {
}
