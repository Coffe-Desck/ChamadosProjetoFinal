package com.ElasTechProjetoFinal.controller;


import com.ElasTechProjetoFinal.dto.response.TecnicoResponse;
import com.ElasTechProjetoFinal.model.Tecnico;
import com.ElasTechProjetoFinal.model.UsuarioLogin;
import com.ElasTechProjetoFinal.service.TecnicoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoController {


    private final TecnicoService tecnicoService;

    private final ObjectMapper mapper;

    public TecnicoController(TecnicoService tecnicoService, ObjectMapper mapper) {
        this.tecnicoService = tecnicoService;
        this.mapper = mapper;
    }

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
    public ResponseEntity<TecnicoResponse> updateById(@PathVariable @Valid Long id, @RequestBody Tecnico tecnico) {
         tecnicoService.updateById(id, tecnico);
         TecnicoResponse resposta = new TecnicoResponse();pit
         return ResponseEntity.accepted().body(resposta);
    }

    @GetMapping("/{id}")
    public Tecnico findById(@PathVariable @Valid Long id) {
        return this.tecnicoService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable @Valid Long id) {
       tecnicoService.deleteById(id);
       return ResponseEntity.noContent().build();
    }
}
