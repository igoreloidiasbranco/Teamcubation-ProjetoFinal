package com.futebol.partidas.controller;

import com.futebol.partidas.dto.request.ClubeRequestDTO;
import com.futebol.partidas.dto.response.ClubeResponseDTO;
import com.futebol.partidas.entity.ClubeEntity;
import com.futebol.partidas.service.ClubeServiceImpl;
import com.futebol.partidas.exception.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/clubes")
public class ClubeController {

    private final ClubeServiceImpl clubeServiceImpl;

    public ClubeController(ClubeServiceImpl clubeServiceImpl) {
        this.clubeServiceImpl = clubeServiceImpl;
    }

    @PostMapping
    public ResponseEntity<ClubeResponseDTO> salvar(@RequestBody ClubeRequestDTO clubeRequestDTO) {

        ClubeEntity clubeEntity = new ClubeEntity();

        BeanUtils.copyProperties(clubeRequestDTO, clubeEntity);

        clubeEntity = clubeServiceImpl.salvar(clubeEntity);

        ClubeResponseDTO clubeResponseDTO = new ClubeResponseDTO(clubeEntity.getId(), clubeEntity.getNome(),
                clubeEntity.getSigla(), clubeEntity.getData(), clubeEntity.getAtivo());

        return ResponseEntity.status(HttpStatus.CREATED).body(clubeResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClubeResponseDTO> editar(@PathVariable Long id, @RequestBody ClubeRequestDTO clubeRequestDTO) {

        Optional<ClubeEntity> clubeEntityOptional = clubeServiceImpl.buscarPorId(id);

        if (clubeEntityOptional.isEmpty()) {

            throw new NotFoundException("Id não encontrado");
        }

        ClubeEntity clubeEntityEditado = new ClubeEntity(id, clubeRequestDTO.nome(),
                clubeRequestDTO.sigla(), clubeRequestDTO.data(), clubeRequestDTO.ativo());

        clubeEntityEditado = clubeServiceImpl.salvar(clubeEntityEditado);

        ClubeResponseDTO clubeResponseDTO = new ClubeResponseDTO(clubeEntityEditado.getId(), clubeEntityEditado.getNome(),
                clubeEntityEditado.getSigla(), clubeEntityEditado.getData(), clubeEntityEditado.getAtivo());

        return ResponseEntity.ok(clubeResponseDTO);
    }
}
