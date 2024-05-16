package com.ElasTechProjetoFinal.controller;

import com.ElasTechProjetoFinal.model.Setor;
import com.ElasTechProjetoFinal.service.GerenciamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/setores")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Tag(name = "Setor")
public class SetorController {

    @Autowired
    private GerenciamentoService gerenciamentoService;


    @Operation(summary = "Cria um setor", method = "POST")
    @PostMapping()
    public Setor save(@RequestBody @Valid Setor setor) {
        return gerenciamentoService.save(setor);
    }


    @Operation(summary = "Busca todos os setores", method = "GET")
    @GetMapping()
    public List<Setor> findAll() {
        return this.gerenciamentoService.findAll();
    }


    @Operation(summary = "Busca um setor pelo ID", method = "GET")
    @GetMapping("/{id}")
    public Setor findById(@PathVariable Long id) {
        return this.gerenciamentoService.findByIdSetor(id);
    }


    @Operation(summary = "Atualiza um setor pelo ID", method = "PUT")
    @PutMapping("/{id}")
    public Setor updateById(@PathVariable @Valid Long id, @RequestBody Setor setor) {
        return this.gerenciamentoService.updateById(id, setor);
    }


    @Operation(summary = "Deleta um setor pelo ID", method = "DELETE")
    @DeleteMapping("/{id}")
    public Setor deleteById(@PathVariable Long id) {
        return this.gerenciamentoService.deleteById(id);
    }
}
