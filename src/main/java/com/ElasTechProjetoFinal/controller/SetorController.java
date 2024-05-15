package com.ElasTechProjetoFinal.controller;

import com.ElasTechProjetoFinal.model.Setor;
import com.ElasTechProjetoFinal.service.GerenciamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gerenciamento")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SetorController {

    @Autowired
    private GerenciamentoService gerenciamentoService;

    @PostMapping("/cadastrosetor")
    public Setor save(@RequestBody @Valid Setor setor) {
        return this.gerenciamentoService.save(setor);
    }

    @GetMapping("/setor/{id}")
    public Setor findById(@PathVariable Long id) {
        return this.gerenciamentoService.findByIdSetor(id);
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






}
