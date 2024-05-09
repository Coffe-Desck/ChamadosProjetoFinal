package com.ElasTechProjetoFinal.service;


import com.ElasTechProjetoFinal.model.Admin;
import com.ElasTechProjetoFinal.model.UsuarioLogin;
import com.ElasTechProjetoFinal.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin save(Admin admin) {
        Optional<Admin> adminExistente = adminRepository.findByEmailContainingIgnoreCase(admin.getEmail());
        if (adminExistente.isPresent()) {
            throw new RuntimeException("O email ja foi cadastrado");
        }else {
            admin.setSenha(criptografarSenha(admin.getSenha()));
            return adminRepository.save(admin);
        }
    }

    private String criptografarSenha(String senha) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(senha);
    }

    public UsuarioLogin autenticarUsuario(UsuarioLogin usuarioLogin){
        Optional<Admin> admin = adminRepository.findByEmailContainingIgnoreCase(usuarioLogin.getEmail());
        if(admin.isPresent()) {
            if (compararSenhas(usuarioLogin.getSenha(), admin.get().getSenha())) {
                usuarioLogin.setId(admin.get().getId());
                usuarioLogin.setEmail(admin.get().getEmail());
                usuarioLogin.setNome(admin.get().getNome());
                usuarioLogin.setSenha(admin.get().getSenha());
                return usuarioLogin;
            }
        }
        throw new RuntimeException("Senha ou email invalidos");
    }

    private boolean compararSenhas(String senhaDigitada, String senhaBanco) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(senhaDigitada, senhaBanco);
    }

    public Admin updateById(Long id, Admin admin) {
        //this.findById(id);
        admin.setId(id);
        Optional<Admin> adminExistente = adminRepository.findByEmailContainingIgnoreCase(admin.getEmail());
        if (adminExistente.isPresent() && (adminExistente.get().getId() != admin.getId())) {
            throw new RuntimeException("O email ja foi cadastrado");
        } else {
            admin.setSenha(criptografarSenha(admin.getSenha()));
            return adminRepository.save(admin);
        }

    }
}
