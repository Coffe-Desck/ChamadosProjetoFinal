package com.ElasTechProjetoFinal.controller;

import com.ElasTechProjetoFinal.model.Usuario;
import com.ElasTechProjetoFinal.model.UsuarioLogin;
import com.ElasTechProjetoFinal.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastro")
    public Usuario save(@RequestBody @Valid Usuario usuario) {
        return this.usuarioService.save(usuario);
    }

    @PostMapping("/logar")
    public UsuarioLogin login(@RequestBody @Valid UsuarioLogin usuarioLogin) {
        UsuarioLogin usuarioAutenticado = usuarioService.autenticarUsuario(usuarioLogin);
        return usuarioAutenticado;
    }

    @GetMapping("/{id}")
    public Usuario findById(@PathVariable Long id) {
        return this.usuarioService.findById(id);
    }

    @GetMapping("/todosusuarios")
    public List<Usuario> findAll() {
        return this.usuarioService.findAll();
    }
    @DeleteMapping("/deletar/{id}")
    public Usuario deleteById(@PathVariable Long id) {
        return this.usuarioService.deleteById(id);
    }

    @PutMapping("/alterar/{id}")
    public Usuario updateById(@PathVariable @Valid Long id, @RequestBody Usuario usuario) {
        return this.usuarioService.updateById(id, usuario);
    }

}
