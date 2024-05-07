package com.ElasTechProjetoFinal.service;


import com.ElasTechProjetoFinal.model.Tecnico;
import com.ElasTechProjetoFinal.model.UsuarioLogin;

import com.ElasTechProjetoFinal.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {
    @Autowired
    private TecnicoRepository tecnicoRepository;

    public Tecnico save(Tecnico tecnico) {

        Optional<Tecnico> tecnicoExistente = tecnicoRepository.findByEmailContainingIgnoreCase(tecnico.getEmail());
        if (tecnicoExistente.isPresent()) {
            throw new RuntimeException("O email ja foi cadastrado");
        }else {
            tecnico.setSenha(criptografarSenha(tecnico.getSenha()));
            return tecnicoRepository.save(tecnico);
        }
    }

    private String criptografarSenha(String senha) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(senha);
    }

    public UsuarioLogin autenticarUsuario(UsuarioLogin usuarioLogin){
        Optional<Tecnico> usuario = tecnicoRepository.findByEmailContainingIgnoreCase(usuarioLogin.getEmail());
        if(usuario.isPresent()) {
            if (compararSenhas(usuarioLogin.getSenha(), usuario.get().getSenha())) {
                usuarioLogin.setId(usuario.get().getId());
                usuarioLogin.setEmail(usuario.get().getEmail());
                usuarioLogin.setNome(usuario.get().getNome());
                usuarioLogin.setSenha(usuario.get().getSenha());
                return usuarioLogin;
            }
        }
        throw new RuntimeException("Senha ou email invalidos");
    }

    private boolean compararSenhas(String senhaDigitada, String senhaBanco) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(senhaDigitada, senhaBanco);
    }

    public List<Tecnico> findAll() {
        return tecnicoRepository.findAll();
    }

    public Tecnico findById(Long id) {
        Optional<Tecnico> resultado = this.tecnicoRepository.findById(id);
      if (resultado.isEmpty()) {
          throw new RuntimeException(" O técnico não foi encontrado");
      } else {
          return resultado.get();
      }
    }

    public Tecnico updateById(Long id, Tecnico tecnico) {
        this.findById(id);
        tecnico.setId(id);
        Optional<Tecnico> tecnicoExistente = tecnicoRepository.findByEmailContainingIgnoreCase(tecnico.getEmail());
        if (tecnicoExistente.isPresent() && (tecnicoExistente.get().getId() != tecnico.getId())) {
            throw new RuntimeException("O email ja foi cadastrado");
        } else {
            tecnico.setSenha(criptografarSenha(tecnico.getSenha()));
            return tecnicoRepository.save(tecnico);
        }

    }

    public Tecnico deleteById(Long id) {
        Tecnico tecnico = findById(id);
        this.tecnicoRepository.delete(tecnico);
        return tecnico;
    }
}
