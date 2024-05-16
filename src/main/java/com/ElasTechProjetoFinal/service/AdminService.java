package com.ElasTechProjetoFinal.service;


import com.ElasTechProjetoFinal.model.*;
import com.ElasTechProjetoFinal.repository.AdminRepository;
import com.ElasTechProjetoFinal.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;



@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private TecnicoRepository tecnicoRepository;


    public Admin save(Admin admin) {
        Optional<Admin> adminExistente = adminRepository.findByEmailContainingIgnoreCase(admin.getEmail());
        if (adminExistente.isPresent()) {
            throw new RuntimeException("O email ja foi cadastrado");
        } else {
            admin.setSenha(criptografarSenha(admin.getSenha()));
            return adminRepository.save(admin);
        }
    }

    private String criptografarSenha(String senha) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(senha);
    }

    public UsuarioLogin autenticarUsuario(UsuarioLogin usuarioLogin) {
        Optional<Admin> admin = adminRepository.findByEmailContainingIgnoreCase(usuarioLogin.getEmail());
        if (admin.isPresent()) {
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

    public Admin findById(Long id) {
        Optional<Admin> resultado = this.adminRepository.findById(id);
        if (resultado.isEmpty()) {
            throw new RuntimeException(" O técnico não foi encontrado");
        } else {
            return resultado.get();
        }
    }

    public Admin updateById(Long id, Admin admin) {
        this.findById(id);
        admin.setId(id);
        Optional<Admin> adminExistente = adminRepository.findByEmailContainingIgnoreCase(admin.getEmail());
        if (adminExistente.isPresent() && (adminExistente.get().getId() != admin.getId())) {
            throw new RuntimeException("O email ja foi cadastrado");
        } else {
            admin.setSenha(criptografarSenha(admin.getSenha()));
            return adminRepository.save(admin);
        }
    }


    public Tecnico saveTecnico( Tecnico tecnico) {
        Optional<Tecnico> tecnicoExistente = tecnicoRepository.findByEmailContainingIgnoreCase(tecnico.getEmail());
        if(tecnicoExistente.isPresent()) {
            throw new RuntimeException("O e-mail já está cadastrado");
        }
        return tecnicoRepository.save(tecnico);
    }


    public Tecnico updateTecnico(Long id, String novoEmail) {
        Tecnico tecnicoExiste = tecnicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(" Técnico não encontrado"));

        Optional<Tecnico> emailJaCadastrado = tecnicoRepository.findByEmailContainingIgnoreCase(novoEmail);
        if(emailJaCadastrado.isPresent() && !emailJaCadastrado.get().getId().equals(id)){
            throw new RuntimeException("O e-mail já está cadastrado para outro técnico");
        }

            tecnicoExiste.setEmail(novoEmail);

        return tecnicoRepository.save(tecnicoExiste);
    }

}
