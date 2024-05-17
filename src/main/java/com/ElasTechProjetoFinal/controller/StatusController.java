package com.ElasTechProjetoFinal.controller;

import com.ElasTechProjetoFinal.model.Status;
import com.ElasTechProjetoFinal.service.StatusService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status")
@CrossOrigin(origins = ("*"), allowedHeaders = ("*"))
@Tag(name = "Status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @Operation(summary = "Cria um status", method = "POST")
    @PostMapping("/cadastrostatus")
    public Status save(@RequestBody @Valid Status status) {
        return this.statusService.save(status
        );
    }


    @Operation(summary = "Busca todos os status", method = "GET")
    @GetMapping("/todosstatus")
    public List<Status> findAllStatus() {
        return this.statusService.findAll();
    }


    @Operation(summary = "Busca um status pelo ID", method = "GET")
    @GetMapping("{id}")
    public Status findByIdStatus(@PathVariable Long id) {
        return this.statusService.findByIdStatus(id);
    }



    @Operation(summary = "Atualiza um status pelo ID", method = "PUT")
    @PutMapping("/alterarstatus/{id}")
    public Status updateById(@PathVariable @Valid Long id, @RequestBody Status setor) {
        return this.statusService.updateById(id, setor);
    }

    @Operation(summary = "Deleta um status pelo ID", method = "DELETE")
    @DeleteMapping("/deletarstatus/{id}")
    public Status deleteById(@PathVariable Long id) {
        return this.statusService.deleteById(id);
    }

}
