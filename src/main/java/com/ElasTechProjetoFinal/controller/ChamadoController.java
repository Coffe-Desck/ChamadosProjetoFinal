package com.ElasTechProjetoFinal.controller;

import com.ElasTechProjetoFinal.dto.request.ChamadoRequest;
import com.ElasTechProjetoFinal.dto.response.ChamadoResponse;
import com.ElasTechProjetoFinal.model.Chamado;
import com.ElasTechProjetoFinal.service.ChamadoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/chamados")
public class ChamadoController {

    private final ChamadoService chamadoService;
    private final ObjectMapper mapper;

    public ChamadoController(ChamadoService chamadoService, ObjectMapper mapper) {
        this.chamadoService = chamadoService;
        this.mapper = mapper;
    }


    @PostMapping("/chamados")
    public ResponseEntity<ChamadoResponse> create(@RequestBody ChamadoRequest request) {
        Chamado chamado = mapper.convertValue(request, Chamado.class);
        Chamado createdChamado = chamadoService.created(chamado);

        ChamadoResponse chamadoResponse = mapper.convertValue(createdChamado, ChamadoResponse.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(chamadoResponse);
    }



    public List<Chamado> findAll() {
        return List.of();
    }


    public Chamado findById(UUID id) {
        return null;
    }


    public Chamado update(UUID id, Map<String, Object> params) {
        return null;
    }


    public void delete(UUID id) {

    }
}
