package com.ElasTechProjetoFinal.controller;

import com.ElasTechProjetoFinal.dto.response.UsuarioResponse;
import com.ElasTechProjetoFinal.model.Usuario;
import com.ElasTechProjetoFinal.model.UsuarioLogin;
import com.ElasTechProjetoFinal.service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/usuarios")
@Tag(name = "Usuários")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final ObjectMapper mapper;

    public UsuarioController(UsuarioService usuarioService, ObjectMapper mapper) {
        this.usuarioService = usuarioService;
        this.mapper = mapper;
    }

    @Operation(summary = "Cria um usuário", method = "POST")
    @PostMapping()
    public ResponseEntity<Usuario> save(@RequestBody @Valid Usuario usuario) {
        Usuario savedUsuario = usuarioService.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUsuario);
    }

    @Operation(summary = "Realiza o login de um usuário", method = "POST")
    @PostMapping("/logar")
    public ResponseEntity<UsuarioLogin> login(@RequestBody @Valid UsuarioLogin usuarioLogin) {
        UsuarioLogin usuarioAutenticado = usuarioService.autenticarUsuario(usuarioLogin);
        return ResponseEntity.ok(usuarioAutenticado);
    }

    @Operation(summary = "Busca todos os usuários", method = "GET")
    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> findAll() {
        List<Usuario> usuarios = usuarioService.findAll();
        if (!usuarios.isEmpty()) {
            List<UsuarioResponse> resposta = usuarios.stream()
                    .map(usuario -> mapper.convertValue(usuario, UsuarioResponse.class))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(resposta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
/*

    @Operation(summary = "Atualiza um usuário pelo ID", method = "PUT")
    @PatchMapping("/{id}")
    public ResponseEntity<UsuarioResponse> updateById(@PathVariable @Valid Long id, @RequestBody @Valid Usuario usuario) {
        Usuario updatedUsuario = usuarioService.updateById(id, usuario);
        UsuarioResponse resposta = mapper.convertValue(updatedUsuario, UsuarioResponse.class);
        return ResponseEntity.ok(resposta);
        
    @GetMapping("/todosusuarios")
    public List<Usuario> findAll() {
        return this.usuarioService.findAll();
    }
    @DeleteMapping("/deletar/{id}")
    public Usuario deleteById(@PathVariable Long id) {
        return this.usuarioService.deleteById(id);

    }
  */

    @Operation(summary = "Busca um usuário pelo ID", method = "GET")
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable @Valid Long id) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Deleta um usuário pelo ID", method = "DELETE")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable @Valid Long id) {
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

