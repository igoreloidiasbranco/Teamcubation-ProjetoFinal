package com.futebol.partidas.controller;

import com.futebol.partidas.dto.request.ClubeRequestDTO;
import com.futebol.partidas.dto.response.ClubeResponseDTO;
import com.futebol.partidas.entity.ClubeEntity;
import com.futebol.partidas.service.ClubeServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clubes")
public class ClubeController {

    private final ClubeServiceImpl clubeServiceImpl;

    public ClubeController(ClubeServiceImpl clubeServiceImpl) {
        this.clubeServiceImpl = clubeServiceImpl;
    }

    @PostMapping
    public ResponseEntity<ClubeResponseDTO> cadastrar(@RequestBody ClubeRequestDTO clubeRequestDTO) {

        ClubeEntity clubeEntity = new ClubeEntity();

        BeanUtils.copyProperties(clubeRequestDTO, clubeEntity);

        clubeEntity = clubeServiceImpl.cadastrar(clubeEntity);

        ClubeResponseDTO clubeResponseDTO = new ClubeResponseDTO(clubeEntity.getId(), clubeEntity.getNome(),
                clubeEntity.getSigla(), clubeEntity.getData(), clubeEntity.getAtivo());

        return ResponseEntity.status(HttpStatus.CREATED).body(clubeResponseDTO);
    }
}
