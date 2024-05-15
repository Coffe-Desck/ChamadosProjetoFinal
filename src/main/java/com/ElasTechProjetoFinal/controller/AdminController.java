package com.ElasTechProjetoFinal.controller;


import com.ElasTechProjetoFinal.model.*;
import com.ElasTechProjetoFinal.service.AdminService;
import com.ElasTechProjetoFinal.service.ChamadoService;
import com.ElasTechProjetoFinal.service.TecnicoService;
import com.ElasTechProjetoFinal.service.UsuarioService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/admins")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private TecnicoService tecnicoService;
    @Autowired
    private ChamadoService chamadoService;

    @PostMapping()
    public Admin save(@RequestBody @Valid Admin admin) {
        return this.adminService.save(admin);
    }

    @PostMapping("/login")
    public UsuarioLogin login(@RequestBody @Valid UsuarioLogin usuarioLogin) {
        UsuarioLogin usuarioAutenticado = adminService.autenticarUsuario(usuarioLogin);
        return usuarioAutenticado;
    }


//    @GetMapping("/listarUsuarios")
//    public List<Usuario> findAll() {
//        return this.usuarioService.findAll();
//    }
//
//    @GetMapping("/listarTecnicos")
//    public List<Tecnico> findAll() { return this.tecnicoService.findAll();
//    }
//
//
//    @GetMapping("/listarChamados")
//    public List<Chamado> findAll() { return this.chamadoService.findAll();
//    }
//
//
//    @PatchMapping("/{id}")
//    public Admin updateById(@PathVariable @Valid Long id, @RequestBody Admin admin) {
//        return this.adminService.updateById(id, admin);
//    }

}
