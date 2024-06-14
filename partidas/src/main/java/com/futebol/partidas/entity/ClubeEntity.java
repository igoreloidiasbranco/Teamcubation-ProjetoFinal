package com.futebol.partidas.entity;

import com.futebol.partidas.dto.Sigla;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "clubes")
@Data
@Getter
@Setter
public class ClubeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 80 , unique = true)
    private String nome;

    @Column(nullable = false, length = 2)
    private Sigla sigla;

    @Column(nullable = false, length = 10)
    private LocalDate data;

    @Column(nullable = false)
    private Boolean ativo;

}
