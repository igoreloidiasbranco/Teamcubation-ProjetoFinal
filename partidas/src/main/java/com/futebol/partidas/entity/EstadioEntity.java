package com.futebol.partidas.entity;

import com.futebol.partidas.dto.Sigla;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "estadios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstadioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 80 , unique = true)
    private String nome;

    @Column(length = 2)
    private Sigla sigla;

}
