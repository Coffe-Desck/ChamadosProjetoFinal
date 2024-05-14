package com.ElasTechProjetoFinal.controller;

import com.ElasTechProjetoFinal.dto.request.ChamadoRequest;
import com.ElasTechProjetoFinal.dto.response.ChamadoResponse;
import com.ElasTechProjetoFinal.model.Chamado;
import com.ElasTechProjetoFinal.service.ChamadoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/chamados")
@Tag(name = "Chamados")
public class ChamadoController {

    private final ChamadoService chamadoService;
    private final ObjectMapper mapper;

    public ChamadoController(ChamadoService chamadoService, ObjectMapper mapper) {
        this.chamadoService = chamadoService;
        this.mapper = mapper;
    }

    @Operation(summary = "Cria um Chamado", method = "POST")
    @PostMapping()
    public ResponseEntity<ChamadoResponse> create(@RequestBody ChamadoRequest request) {
        Chamado chamado = mapper.convertValue(request, Chamado.class);
        Chamado createdChamado = chamadoService.created(chamado);

        ChamadoResponse chamadoResponse = mapper.convertValue(createdChamado, ChamadoResponse.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(chamadoResponse);
    }

    @Operation(summary = "Busca todos os chamados", method = "GET")
    @GetMapping()
    public ResponseEntity<List<ChamadoResponse>> findAll() {
        List<Chamado> chamados = chamadoService.findAll();
        List<ChamadoResponse> chamadoResponses = chamados.stream()
                .map(chamado -> new ChamadoResponse(chamado.getId(), chamado.getTitulo(), chamado.getDescricao(), chamado.getSetor(),
                        chamado.getPrioridade(), chamado.getDataInicio(), chamado.getDataTermino()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(chamadoResponses);
    }

    @Operation(summary = "Busca um chamado por id", method = "GET")
    @GetMapping("/{id}")
    public ResponseEntity<ChamadoResponse> findById(@PathVariable UUID id) {
        Chamado chamado = chamadoService.findById(id);
        if (chamado != null) {
            ChamadoResponse chamadoResponse = new ChamadoResponse(chamado.getId(), chamado.getTitulo(), chamado.getDescricao(), chamado.getSetor(),
                    chamado.getPrioridade(), chamado.getDataInicio(), chamado.getDataTermino());
            return ResponseEntity.ok(chamadoResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Atualiza um chamado por id", method = "PATCH")
    @PatchMapping("/{id}")
    public ResponseEntity<ChamadoResponse> update(@PathVariable UUID id, @RequestBody Map<String, Object> params) {
        Chamado chamado = chamadoService.update(id, params);
        if (chamado != null) {
            ChamadoResponse chamadoResponse = new ChamadoResponse(chamado.getId(), chamado.getTitulo(), chamado.getDescricao(), chamado.getSetor(),
                    chamado.getPrioridade(), chamado.getDataInicio(), chamado.getDataTermino());
            return ResponseEntity.accepted().body(chamadoResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Deleta um chamado", method = "DELETE")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        chamadoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
