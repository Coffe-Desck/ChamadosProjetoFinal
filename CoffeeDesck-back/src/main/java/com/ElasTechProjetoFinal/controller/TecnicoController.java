package com.ElasTechProjetoFinal.controller;


import com.ElasTechProjetoFinal.dto.response.TecnicoResponse;
import com.ElasTechProjetoFinal.model.Tecnico;
import com.ElasTechProjetoFinal.model.UsuarioLogin;
import com.ElasTechProjetoFinal.service.TecnicoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/tecnicos")
@Tag(name = "Tecnicos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TecnicoController {

    private final TecnicoService tecnicoService;
    private final ObjectMapper mapper;

    public TecnicoController(TecnicoService tecnicoService, ObjectMapper mapper) {
        this.tecnicoService = tecnicoService;
        this.mapper = mapper;
    }

    @Operation(summary = "Cria um técnico", method = "POST")
    @PostMapping()
    public ResponseEntity<Tecnico> save(@RequestBody @Valid Tecnico tecnico) {
        Tecnico savedTecnico = tecnicoService.save(tecnico);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTecnico);
    }

    @Operation(summary = "Realiza o login de um técnico", method = "POST")
    @PostMapping("/logar")
    public ResponseEntity<UsuarioLogin> login(@RequestBody @Valid UsuarioLogin usuarioLogin) {
        UsuarioLogin usuarioAutenticado = tecnicoService.autenticarUsuario(usuarioLogin);
        return ResponseEntity.ok(usuarioAutenticado);
    }

    @Operation(summary = "Busca todos os técnicos", method = "GET")
    @GetMapping
    public ResponseEntity<List<TecnicoResponse>> findAll() {
        List<Tecnico> tecnicos = tecnicoService.findAll();
        if (!tecnicos.isEmpty()) {
            List<TecnicoResponse> resposta = tecnicos.stream()
                    .map(tecnico -> mapper.convertValue(tecnico, TecnicoResponse.class))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(resposta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Atualiza um técnico pelo ID", method = "PUT")
    @PutMapping("/{id}")
    public ResponseEntity<TecnicoResponse> updateById(@PathVariable @Valid Long id, @RequestBody @Valid Tecnico tecnico) {
        Tecnico updatedTecnico = tecnicoService.updateById(id, tecnico);
        TecnicoResponse resposta = mapper.convertValue(updatedTecnico, TecnicoResponse.class);
        return ResponseEntity.ok(resposta);
    }

    @Operation(summary = "Busca um técnico pelo ID", method = "GET")
    @GetMapping("/{id}")
    public ResponseEntity<Tecnico> findById(@PathVariable @Valid Long id) {
        Tecnico tecnico = tecnicoService.findById(id);
        if (tecnico != null) {
            return ResponseEntity.ok(tecnico);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Deleta um técnico pelo ID", method = "DELETE")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable @Valid Long id) {
        tecnicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}