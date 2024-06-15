package com.futebol.partidas.service;

import com.futebol.partidas.entity.ClubeEntity;
import com.futebol.partidas.repository.ClubeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public void inativarPorId(Long id) {
        ClubeEntity clubeEntity = clubeRepository.getReferenceById(id);
        clubeEntity.desativar();
    }

    @Override
    public Page<ClubeEntity> listar(Pageable paginacao) {
        return clubeRepository.findAll(paginacao);
    }
}
