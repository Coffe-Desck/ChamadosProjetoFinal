package com.ElasTechProjetoFinal.controller;

import com.ElasTechProjetoFinal.model.EnumSetor;
import com.ElasTechProjetoFinal.service.GerenciamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/setores")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SetorController {

    @Autowired
    private GerenciamentoService gerenciamentoService;

    @PostMapping()
    public EnumSetor save(@RequestBody @Valid EnumSetor enumSetor) {
        return gerenciamentoService.save(enumSetor);
    }

    @GetMapping()
    public List<EnumSetor> findAll() {
        return this.gerenciamentoService.findAll();
    }

    @GetMapping("/{nome}")
    public EnumSetor findByName(@PathVariable String nome) {
        return this.gerenciamentoService.findByName(nome);
    }


    @DeleteMapping("/{nome}")
    public EnumSetor deleteByName(@PathVariable String nome) {
        return this.gerenciamentoService.deleteByName(nome);
    }

    @PutMapping("/{nome}")
    public EnumSetor updateByName(@PathVariable @Valid String nome, @RequestBody EnumSetor enumSetor) {
        return this.gerenciamentoService.updateByName(nome, enumSetor);
    }
}
