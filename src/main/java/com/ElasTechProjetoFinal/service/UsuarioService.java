package com.ElasTechProjetoFinal.service;

import com.ElasTechProjetoFinal.model.Tecnico;
import com.ElasTechProjetoFinal.model.Usuario;
import com.ElasTechProjetoFinal.model.UsuarioLogin;
import com.ElasTechProjetoFinal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario save(Usuario usuario) {

        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmailContainingIgnoreCase(usuario.getEmail());
        if (usuarioExistente.isPresent()) {
            throw new RuntimeException("O email ja foi cadastrado");
        }else {
        usuario.setSenha(criptografarSenha(usuario.getSenha()));
            return usuarioRepository.save(usuario);
        }
    }

    private String criptografarSenha(String senha) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(senha);
    }

    public UsuarioLogin autenticarUsuario(UsuarioLogin usuarioLogin){
        Optional<Usuario> usuario = usuarioRepository.findByEmailContainingIgnoreCase(usuarioLogin.getEmail());
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

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id) {
        Optional<Usuario> resultado = this.usuarioRepository.findById(id);
        if(resultado.isEmpty()) {
            throw new RuntimeException("O cliente não foi encontrada");
        }else {
            return resultado.get();
        }
    }
    public Usuario deleteById(Long id) {
        Usuario usuario= findById(id);
        this.usuarioRepository.delete(usuario);
        return usuario;
    }

    public Usuario updateById(Long id, Usuario usuario) {
        this.findById(id);
        usuario.setId(id);
        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmailContainingIgnoreCase(usuario.getEmail());
        if (usuarioExistente.isPresent() && (usuarioExistente.get().getId() != usuario.getId())) {
            throw new RuntimeException("O email ja foi cadastrado");
        } else {
            usuario.setSenha(criptografarSenha(usuario.getSenha()));
            return usuarioRepository.save(usuario);
        }
    }

}





