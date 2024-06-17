package com.futebol.partidas.controller;

import com.futebol.partidas.dto.request.ClubeRequestDTO;
import com.futebol.partidas.dto.response.ClubeResponseDTO;
import com.futebol.partidas.entity.ClubeEntity;
import com.futebol.partidas.service.ClubeServiceImpl;
import com.futebol.partidas.exception.NotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional
    public ResponseEntity<ClubeResponseDTO> salvar(@RequestBody @Valid ClubeRequestDTO clubeRequestDTO) {

        ClubeEntity clubeEntity = new ClubeEntity();

        BeanUtils.copyProperties(clubeRequestDTO, clubeEntity);

        clubeEntity = clubeServiceImpl.salvar(clubeEntity);

        ClubeResponseDTO clubeResponseDTO = new ClubeResponseDTO(clubeEntity.getId(), clubeEntity.getNome(),
                clubeEntity.getSigla(), clubeEntity.getData(), clubeEntity.getAtivo());

        return ResponseEntity.status(HttpStatus.CREATED).body(clubeResponseDTO);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ClubeResponseDTO> editar(@PathVariable Long id, @RequestBody @Valid ClubeRequestDTO clubeRequestDTO) {

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

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity inativar(@PathVariable Long id) {

        Optional<ClubeEntity> clubeEntityOptional = clubeServiceImpl.buscarPorId(id);

        if (clubeEntityOptional.isEmpty()) {

            throw new NotFoundException("Id não encontrado");
        }

        clubeServiceImpl.inativarPorId(clubeEntityOptional.get().getId());

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClubeResponseDTO> consultar(@PathVariable Long id) {
        Optional<ClubeEntity> clubeEntityOptional = clubeServiceImpl.buscarPorId(id);

        if (clubeEntityOptional.isEmpty()) {

            throw new NotFoundException("Id não encontrado");
        }

        ClubeResponseDTO clubeResponseDTO = new ClubeResponseDTO(
                clubeEntityOptional.get().getId(),
                clubeEntityOptional.get().getNome(),
                clubeEntityOptional.get().getSigla(),
                clubeEntityOptional.get().getData(),
                clubeEntityOptional.get().getAtivo());

        return ResponseEntity.ok(clubeResponseDTO);

    }

    @GetMapping
    public ResponseEntity<Page<ClubeResponseDTO>> listar(@PageableDefault (size = 5, sort = {"nome"}) Pageable paginacao){
        Page page = clubeServiceImpl.listar(paginacao).map(ClubeResponseDTO::new);
        return ResponseEntity.ok(page);

    }

}
