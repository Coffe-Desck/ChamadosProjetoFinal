package com.ElasTechProjetoFinal.controller;


import com.ElasTechProjetoFinal.dto.request.TecnicoRequest;
import com.ElasTechProjetoFinal.dto.response.ChamadoResponse;
import com.ElasTechProjetoFinal.dto.response.TecnicoResponse;
import com.ElasTechProjetoFinal.dto.response.UsuarioResponse;
import com.ElasTechProjetoFinal.model.*;
import com.ElasTechProjetoFinal.service.AdminService;


import com.ElasTechProjetoFinal.service.TecnicoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/admins")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Tag(name = "Administrador")
public class AdminController {

    @Autowired
    private AdminService adminService;

    private final ObjectMapper mapper;

    private final UsuarioController usuarioController;
    private final ChamadoController chamadoController;
    private final TecnicoController tecnicoController;


    public AdminController(UsuarioController usuarioController, ChamadoController chamadoController, TecnicoController tecnicoController, ObjectMapper mapper) {
        this.usuarioController = usuarioController;
        this.chamadoController = chamadoController;
        this.tecnicoController = tecnicoController;
        this.mapper = mapper;
    }


    @Operation(summary = "Realiza o login de um administrador", method = "POST")
    @PostMapping("/logar")
    public UsuarioLogin login(@RequestBody @Valid UsuarioLogin usuarioLogin) {
        UsuarioLogin usuarioAutenticado = adminService.autenticarUsuario(usuarioLogin);
        return usuarioAutenticado;
    }

    @Operation(summary = "Busca todos os usuarios", method = "GET")
    @GetMapping("/usuarios")
    public ResponseEntity<List<UsuarioResponse>> findAllUsuarios() {
        ResponseEntity<List<UsuarioResponse>> responseEntity = usuarioController.findAll();
        if(responseEntity.getStatusCode() == HttpStatus.OK){
            return responseEntity;
        } else {
            return ResponseEntity.status(responseEntity.getStatusCode()).build();
        }

    }

    @Operation(summary = "Busca um usuário pelo ID", method = "GET")
    @GetMapping("/usuarios/{id}")
    public ResponseEntity<UsuarioResponse> findByUsuarioId(@PathVariable Long id) {
        ResponseEntity<UsuarioResponse> responseEntity = usuarioController.findById(id);
        if(responseEntity.getStatusCode() == HttpStatus.OK){
            return responseEntity;
        } else {
            return ResponseEntity.status(responseEntity.getStatusCode()).build();
        }
    }

    @Operation(summary = "Busca todos os técnicos", method = "GET")
    @GetMapping("/tecnicos")
    public ResponseEntity<List<TecnicoResponse>> findAllTecnicos(){
        ResponseEntity<List<TecnicoResponse>> responseEntity = tecnicoController.findAll();
        if(responseEntity.getStatusCode() == HttpStatus.OK){
            return responseEntity;
        } else {
            return ResponseEntity.status(responseEntity.getStatusCode()).build();
        }
    }

    @Operation(summary = "Busca um técnico pelo ID", method = "GET")
    @GetMapping("/tecnicos/{id}")
    public ResponseEntity<TecnicoResponse> findTecnicoById (@PathVariable Long id) {
        ResponseEntity<TecnicoResponse> responseEntity = tecnicoController.findById(id);
        if(responseEntity.getStatusCode() == HttpStatus.OK){
            return responseEntity;
        } else {
            return ResponseEntity.status(responseEntity.getStatusCode()).build();
        }
    }

    @Operation(summary = "Busca todos os chamados", method = "GET")
    @GetMapping("/chamados")
    public ResponseEntity<List<ChamadoResponse>> findAllChamados(){
        ResponseEntity<List<ChamadoResponse>> responseEntity = chamadoController.findAll();
        if(responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity;
        } else {
            return ResponseEntity.status(responseEntity.getStatusCode()).build();
        }
    }

    @Operation(summary = "Cria um novo tecnico", method = "POST")
    @PostMapping("/tecnicos")
    public ResponseEntity<TecnicoResponse> saveTecnico(@RequestBody @Valid TecnicoRequest tecnicoRequest) {
       try {
            Tecnico tecnico = mapper.convertValue(tecnicoRequest, Tecnico.class);
            Tecnico saveTecnico = adminService.saveTecnico(tecnico);
            TecnicoResponse tecnicoResponse = mapper.convertValue(saveTecnico, TecnicoResponse.class);
            return ResponseEntity.status(HttpStatus.CREATED).body(tecnicoResponse);
        } catch (RuntimeException e) {
           return ResponseEntity.badRequest().body(null);
       }
    }

    @Operation(summary = "Atualiza um técnico pelo Id", method = "PUT")
    @PutMapping("/tecnicos/{id}")
    public ResponseEntity<TecnicoResponse> updateTecnico(@PathVariable Long id,@RequestBody String novoEmail ) {
        try {
            Tecnico updateTecnico = adminService.updateTecnico(id, novoEmail);
            TecnicoResponse tecnicoResponse = mapper.convertValue(updateTecnico, TecnicoResponse.class);
            return ResponseEntity.status(HttpStatus.OK).body(tecnicoResponse);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @Operation(summary = "Busca um chamado por id", method = "GET")
    @GetMapping("/chamados/{id}")
    public ResponseEntity<ChamadoResponse> findChamadoById(@PathVariable UUID id){
        ResponseEntity<ChamadoResponse> responseEntity = chamadoController.findById(id);
        if(responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity;
        } else {
            return ResponseEntity.status(responseEntity.getStatusCode()).build();
        }
    }

    @Operation(summary = "Atualiza um administrador pelo ID", method = "PUT")
    @PutMapping("/{id}")
    public Admin updateById(@PathVariable @Valid Long id, @RequestBody Admin admin) {
        return this.adminService.updateById(id, admin);
    }

}
