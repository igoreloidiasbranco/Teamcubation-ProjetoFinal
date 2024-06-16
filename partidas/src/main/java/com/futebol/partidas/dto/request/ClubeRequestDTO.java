package com.futebol.partidas.dto.request;

import com.futebol.partidas.dto.Sigla;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;


import java.time.LocalDate;

public record ClubeRequestDTO(

        @NotBlank
        @Pattern(regexp = "^.{2,}$")
        String nome,

        @NotNull
        Sigla sigla,

        @NotNull
        @Past
        LocalDate data,

        @NotNull
        Boolean ativo) {
}
