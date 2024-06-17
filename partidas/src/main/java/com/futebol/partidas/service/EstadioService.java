package com.futebol.partidas.service;

import com.futebol.partidas.entity.EstadioEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EstadioService {

    EstadioEntity salvar(EstadioEntity estadioEntity);

    Page<EstadioEntity> listar(Pageable paginacao);

}
