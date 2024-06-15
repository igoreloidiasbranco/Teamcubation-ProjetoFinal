package com.futebol.partidas.service;

import com.futebol.partidas.entity.ClubeEntity;
import com.futebol.partidas.repository.ClubeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClubeServiceImpl implements ClubeService{

    private final ClubeRepository clubeRepository;

    public ClubeServiceImpl(ClubeRepository clubeRepository) {
        this.clubeRepository = clubeRepository;
    }

    @Override
    public ClubeEntity salvar(ClubeEntity clubeEntity) {

        return clubeRepository.save(clubeEntity);
    }

    @Override
    public Optional<ClubeEntity> buscarPorId(Long id) {
        return clubeRepository.findById(id);
    }
}
