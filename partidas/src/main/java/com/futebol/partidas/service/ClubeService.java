package com.futebol.partidas.service;

import com.futebol.partidas.entity.ClubeEntity;

import java.util.Optional;

public interface ClubeService {

    ClubeEntity salvar(ClubeEntity clubeEntity);

    Optional<ClubeEntity> buscarPorId(Long id);

}
