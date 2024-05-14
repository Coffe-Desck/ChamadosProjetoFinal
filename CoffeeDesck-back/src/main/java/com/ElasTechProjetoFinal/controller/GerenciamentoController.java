package com.ElasTechProjetoFinal.controller;


import com.ElasTechProjetoFinal.model.Prioridade;
import com.ElasTechProjetoFinal.model.Setor;
import com.ElasTechProjetoFinal.service.GerenciamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gerenciamento")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GerenciamentoController {

    @Autowired
    private GerenciamentoService gerenciamentoService;

    @PostMapping("/cadastrosetor")
    public Setor save(@RequestBody @Valid Setor setor) {
        return this.gerenciamentoService.save(setor);
    }

    @GetMapping("/setor/{id}")
    public Setor findByIdSetor(@PathVariable Long id) {
        return this.gerenciamentoService.findByIdSetor(id);
    }

    @GetMapping("/todossetores")
    public List<Setor> findAllSetores() {
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

    @GetMapping("/allprioridade")
    public List<Prioridade> findAllPrioridade() {
        return this.gerenciamentoService.findAllPrioridade();
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
