package com.futebol.partidas.service;

import com.futebol.partidas.entity.EstadioEntity;
import com.futebol.partidas.exception.NomeExistsException;
import com.futebol.partidas.repository.EstadioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EstadioServiceImpl implements EstadioService{

    private final EstadioRepository estadioRepository;

    public EstadioServiceImpl(EstadioRepository estadioRepository) {
        this.estadioRepository = estadioRepository;
    }


    @Override
    public EstadioEntity salvar(EstadioEntity estadioEntity) {

        boolean nomeExists = estadioRepository.existsByNome(estadioEntity.getNome());

        if(nomeExists) {
            throw new NomeExistsException("Nome já se encontra registrado");
        }

        return estadioRepository.save(estadioEntity);

    }

    @Override
    public Page<EstadioEntity> listar(Pageable paginacao) {
        return estadioRepository.findAll(paginacao);
    }
}
