package com.futebol.partidas.controller;

import com.futebol.partidas.dto.request.EstadioRequestDTO;
import com.futebol.partidas.dto.response.EstadioResponseDTO;
import com.futebol.partidas.entity.EstadioEntity;
import com.futebol.partidas.service.EstadioServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estadios")
public class EstadioController {

    private final EstadioServiceImpl estadioServiceImpl;

    public EstadioController(EstadioServiceImpl estadioServiceImpl){
        this.estadioServiceImpl = estadioServiceImpl;
    }

    @PostMapping
    public ResponseEntity<EstadioResponseDTO> salvar(@RequestBody @Valid EstadioRequestDTO estadioDTO) {

        EstadioEntity estadioEntity = new EstadioEntity();
        BeanUtils.copyProperties(estadioDTO, estadioEntity);

        estadioEntity = estadioServiceImpl.salvar(estadioEntity);

        EstadioResponseDTO estadioResponseDTO = new EstadioResponseDTO(
                estadioEntity.getId(),
                estadioEntity.getNome(),
                estadioEntity.getSigla());

        return ResponseEntity.status(HttpStatus.CREATED).body(estadioResponseDTO);
    }

    @GetMapping
    public ResponseEntity<Page<EstadioResponseDTO>> listar(@PageableDefault(size = 5, sort = {"nome"})Pageable paginacao){
        Page page = estadioServiceImpl.listar(paginacao);
        return ResponseEntity.ok(page);
    }
}
