package com.ElasTechProjetoFinal.controller;


import com.ElasTechProjetoFinal.dto.response.ChamadoResponse;
import com.ElasTechProjetoFinal.dto.response.TecnicoResponse;
import com.ElasTechProjetoFinal.dto.response.UsuarioResponse;
import com.ElasTechProjetoFinal.model.*;
import com.ElasTechProjetoFinal.service.AdminService;


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

    private final UsuarioController usuarioController;
    private final ChamadoController chamadoController;
    private final TecnicoController tecnicoController;

    public AdminController(UsuarioController usuarioController, ChamadoController chamadoController, TecnicoController tecnicoController) {
        this.usuarioController = usuarioController;
        this.chamadoController = chamadoController;
        this.tecnicoController = tecnicoController;
    }

    @PostMapping()
    public Admin save(@RequestBody @Valid Admin admin) {
        return this.adminService.save(admin);
    }

    @PostMapping()
    public UsuarioLogin login(@RequestBody @Valid UsuarioLogin usuarioLogin) {
        UsuarioLogin usuarioAutenticado = adminService.autenticarUsuario(usuarioLogin);
        return usuarioAutenticado;
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<UsuarioResponse>> findAllUsuarios() {
        ResponseEntity<List<UsuarioResponse>> responseEntity = usuarioController.findAll();
        if(responseEntity.getStatusCode() == HttpStatus.OK){
            return responseEntity;
        } else {
            return ResponseEntity.status(responseEntity.getStatusCode()).build();
        }

    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<UsuarioResponse> findByUsuarioId(@PathVariable Long id) {
        ResponseEntity<UsuarioResponse> responseEntity = usuarioController.findById(id);
        if(responseEntity.getStatusCode() == HttpStatus.OK){
            return responseEntity;
        } else {
            return ResponseEntity.status(responseEntity.getStatusCode()).build();
        }
    }

    @GetMapping("/tecnicos")
    public ResponseEntity<List<TecnicoResponse>> findAllTecnicos(){
        ResponseEntity<List<TecnicoResponse>> responseEntity = tecnicoController.findAll();
        if(responseEntity.getStatusCode() == HttpStatus.OK){
            return responseEntity;
        } else {
            return ResponseEntity.status(responseEntity.getStatusCode()).build();
        }
    }

    @GetMapping("/tecnicos/{id}")
    public ResponseEntity<TecnicoResponse> findTecnicoById(@PathVariable Long id) {
        ResponseEntity<TecnicoResponse> responseEntity = tecnicoController.findById(id);
        if(responseEntity.getStatusCode() == HttpStatus.OK){
            return responseEntity;
        } else {
            return ResponseEntity.status(responseEntity.getStatusCode()).build();
        }
    }

    @GetMapping("/chamados")
    public ResponseEntity<List<ChamadoResponse>> findAllChamados(){
        ResponseEntity<List<ChamadoResponse>> responseEntity = chamadoController.findAll();
        if(responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity;
        } else {
            return ResponseEntity.status(responseEntity.getStatusCode()).build();
        }
    }


    @GetMapping("/chamados/{id}")
    public ResponseEntity<ChamadoResponse> findChamadoById(@PathVariable UUID id){
        ResponseEntity<ChamadoResponse> responseEntity = chamadoController.findById(id);
        if(responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity;
        } else {
            return ResponseEntity.status(responseEntity.getStatusCode()).build();
        }
    }

    @PatchMapping("/{id}")
    public Admin updateById(@PathVariable @Valid Long id, @RequestBody Admin admin) {
        return this.adminService.updateById(id, admin);
    }

}
