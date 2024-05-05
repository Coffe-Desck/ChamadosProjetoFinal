package com.ElasTechProjetoFinal.controller;


import com.ElasTechProjetoFinal.model.Tecnico;
import com.ElasTechProjetoFinal.model.UsuarioLogin;
import com.ElasTechProjetoFinal.service.TecnicoServise;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tecnico")
public class TecnicoController {

    @Autowired
    private TecnicoServise tecnicoService;

    @PostMapping("/cadastro")
    public Tecnico save(@RequestBody @Valid Tecnico tecnico) {
        return this.tecnicoService.save(tecnico);
    }

    @PostMapping("/logar")
    public UsuarioLogin login(@RequestBody @Valid UsuarioLogin usuarioLogin) {
        UsuarioLogin usuarioAutenticado = tecnicoService.autenticarUsuario(usuarioLogin);
        return usuarioAutenticado;
    }

    @PutMapping("/alterar/{id}")
    public Tecnico updateById(@PathVariable @Valid Long id, @RequestBody Tecnico tecnico) {
        return this.tecnicoService.updateById(id, tecnico);
    }
}
