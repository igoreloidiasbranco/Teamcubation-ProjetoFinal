package com.futebol.partidas.service;

import com.futebol.partidas.entity.ClubeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Optional;

public interface ClubeService {

    ClubeEntity salvar(ClubeEntity clubeEntity);

    Optional<ClubeEntity> buscarPorId(Long id);

    void inativarPorId(Long id);

    Page<ClubeEntity> listar(Pageable paginacao);
}
