package com.ElasTechProjetoFinal.controller;

import com.ElasTechProjetoFinal.model.Prioridade;
import com.ElasTechProjetoFinal.model.Setor;
import com.ElasTechProjetoFinal.service.GerenciamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gerenciamentos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Tag(name = "Gerenciamento")
public class GerencimanetoController {

    @Autowired
    private GerenciamentoService gerenciamentoService;


    @Operation(summary = "Cria um novo setor", method = "POST")
    @PostMapping("/cadastrosetor")
    public Setor save(@RequestBody @Valid Setor setor) {
        return this.gerenciamentoService.save(setor);
    }


    @Operation(summary = "Busca todos os setores", method = "GET")
    @GetMapping("/todossetores")
    public List<Setor> findAllSetores() {
        return this.gerenciamentoService.findAll();
    }


    @Operation(summary = "Busca um setor por ID", method = "GET")
    @GetMapping("/setor/{id}")
    public Setor findByIdSetor(@PathVariable Long id) {
        return this.gerenciamentoService.findByIdSetor(id);
    }



    @Operation(summary = "Atualiza um setor por ID", method = "PUT")
    @PutMapping("/alterarsetor/{id}")
    public Setor updateById(@PathVariable @Valid Long id, @RequestBody Setor setor) {
        return this.gerenciamentoService.updateById(id, setor);
    }

    @Operation(summary = "Deleta um setor pelo ID", method = "DELETE")
    @DeleteMapping("/deletarsetor/{id}")
    public Setor deleteById(@PathVariable Long id) {
        return this.gerenciamentoService.deleteById(id);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////


    @Operation(summary = "Cria uma novo prioridade", method = "POST")
    @PostMapping("/prioridade")
    public Prioridade save(@RequestBody @Valid Prioridade prioridade) {
        return this.gerenciamentoService.save(prioridade);
    }


    @Operation(summary = "Busca todas as prioridades", method = "GET")
    @GetMapping("/allprioridade")
    public List<Prioridade> findAllPrioridade() {
        return this.gerenciamentoService.findAllPrioridade();
    }


    @Operation(summary = "Busca uma prioridade por ID", method = "GET")
    @GetMapping("/prioridade/{id}")
    public Prioridade findByIdPrioridade(@PathVariable Long id){
        return this.gerenciamentoService.findByIdPrioridade(id);
    }


    @Operation(summary = "Atualiza uma prioridade pelo ID", method = "PUT")
    @PutMapping("/alterarprioridade/{id}")
    public Prioridade updateByIdPrioridade(@PathVariable @Valid Long id, @RequestBody Prioridade prioridade) {
        return this.gerenciamentoService.updateByIdPrioridade(id, prioridade);
    }


    @Operation(summary = "Deleta uma prioridade pelo ID", method = "DELETE")
    @DeleteMapping("/deletarprioridade/{id}")
    public Prioridade deleteByIdprioridade(@PathVariable Long id){
        return this.gerenciamentoService.deleteByIdprioridade(id);
    }


}
