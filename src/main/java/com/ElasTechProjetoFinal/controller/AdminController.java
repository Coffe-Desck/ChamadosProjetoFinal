package com.ElasTechProjetoFinal.controller;


import com.ElasTechProjetoFinal.model.Admin;
import com.ElasTechProjetoFinal.model.UsuarioLogin;
import com.ElasTechProjetoFinal.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/cadastro")
    public Admin save(@RequestBody @Valid Admin admin) {
        return this.adminService.save(admin);
    }

    @PostMapping("/logar")
    public UsuarioLogin login(@RequestBody @Valid UsuarioLogin usuarioLogin) {
        UsuarioLogin usuarioAutenticado = adminService.autenticarUsuario(usuarioLogin);
        return usuarioAutenticado;
    }

    @PutMapping("/alterar/{id}")
    public Admin updateById(@PathVariable @Valid Long id, @RequestBody Admin admin) {
        return this.adminService.updateById(id, admin);
    }



}
