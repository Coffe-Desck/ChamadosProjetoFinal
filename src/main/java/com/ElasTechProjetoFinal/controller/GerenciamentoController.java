package com.ElasTechProjetoFinal.controller;

import com.ElasTechProjetoFinal.model.Prioridade;
import com.ElasTechProjetoFinal.model.Setor;
import com.ElasTechProjetoFinal.model.Usuario;
import com.ElasTechProjetoFinal.model.UsuarioLogin;
import com.ElasTechProjetoFinal.service.GerenciamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gerenciamento")
public class GerenciamentoController {

    @Autowired
    private GerenciamentoService gerenciamentoService;

    @PostMapping("/cadastrosetor")
    public Setor save(@RequestBody @Valid Setor setor) {
        return this.gerenciamentoService.save(setor);
    }

    @GetMapping("/setor/{id}")
    public Setor findById(@PathVariable Long id) {
        return this.gerenciamentoService.findById(id);
    }

    @GetMapping("/todossetores")
    public List<Setor> findAll() {
        return this.gerenciamentoService.findAll();
    }

    @DeleteMapping("/deletarsetor/{id}")
    public Setor deleteById(@PathVariable Long id) {
        return this.gerenciamentoService.deleteById(id);
    }

    @PutMapping("/alterarsetor/{id}")
    public Setor updateById(@PathVariable @Valid Long id, @RequestBody Setor setor) {
        return this.gerenciamentoService.updateById(id, setor);
    }


    @PostMapping("/prioridade")
    public Prioridade save(@RequestBody @Valid Prioridade prioridade) {
        return this.gerenciamentoService.save(prioridade);
    }

    @GetMapping("/prioridade/{id}")
    public Prioridade findByIdPrioridade(@PathVariable Long id){
        return this.gerenciamentoService.findByIdPrioridade(id);
    }

    @DeleteMapping("/deletarprioridade/{id}")
    public Prioridade deleteByIdprioridade(@PathVariable Long id){
        return this.gerenciamentoService.deleteByIdprioridade(id);
    }

    @PutMapping("/alterarprioridade/{id}")
    public Prioridade updateByIdPrioridade(@PathVariable @Valid Long id, @RequestBody Prioridade prioridade) {
        return this.gerenciamentoService.updateByIdPrioridade(id, prioridade);
    }



}
