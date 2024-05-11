package com.ElasTechProjetoFinal.popularDados;
import com.ElasTechProjetoFinal.model.Admin;
import com.ElasTechProjetoFinal.model.Tecnico;
import com.ElasTechProjetoFinal.model.Usuario;
import com.ElasTechProjetoFinal.repository.AdminRepository;
import com.ElasTechProjetoFinal.repository.ChamadoRepository;
import com.ElasTechProjetoFinal.repository.TecnicoRepository;
import com.ElasTechProjetoFinal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;


@Configuration
public class Runner implements CommandLineRunner {

    private final AdminRepository adminRepository;
    private final UsuarioRepository usuarioRepository;
    private final TecnicoRepository tecnicoRepository;
    private final ChamadoRepository chamadoRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public Runner(AdminRepository adminRepository,
                    UsuarioRepository usuarioRepository,
                    TecnicoRepository tecnicoRepository,
                    ChamadoRepository chamadoRepository) {
        this.adminRepository = adminRepository;
        this.usuarioRepository = usuarioRepository;
        this.tecnicoRepository = tecnicoRepository;
        this.chamadoRepository = chamadoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
            //Adimin------------------------------------

            Optional<Admin> admin = adminRepository.findByEmailContainingIgnoreCase("marcelo@admin.com");
            if(admin.isEmpty()){
                admin = Optional.of(new Admin());
                admin.get().setNome("Marcelo");
                admin.get().setSenha(passwordEncoder.encode("12345678"));
                admin.get().setEmail("marcelo@admin.com");
                adminRepository.save(admin.get());
            }

            Optional<Admin> admin2 = adminRepository.findByEmailContainingIgnoreCase("juliana@admin.com");
            if(admin2.isEmpty()) {
                admin2 = Optional.of(new Admin());
                admin2.get().setNome("Juliana");
                admin2.get().setSenha(passwordEncoder.encode("12345678"));
                admin2.get().setEmail("juliana@admin.com");
                adminRepository.save(admin2.get());
            }
            //Admin---------------------------------------

            //Usuarios---------------------------------------
            Optional<Usuario> usuario = usuarioRepository.findByEmailContainingIgnoreCase("alice@exemplo.com");
            if(usuario.isEmpty()) {
                usuario= Optional.of(new Usuario());
                usuario.get().setNome("Alice");
                usuario.get().setSenha(passwordEncoder.encode("senhaUsuario"));
                usuario.get().setEmail("alice@exemplo.com");
                usuarioRepository.save(usuario.get());
            }

            Optional<Usuario> usuario1 = usuarioRepository.findByEmailContainingIgnoreCase("pedro@exemplo.com");
            if(usuario1.isEmpty()) {
                usuario1= Optional.of(new Usuario());
                usuario1.get().setNome("Pedro");
                usuario1.get().setSenha(passwordEncoder.encode("senhaUsuario"));
                usuario1.get().setEmail("pedro@exemplo.com");
                usuarioRepository.save(usuario1.get());
            }

            Optional<Usuario> usuario2 = usuarioRepository.findByEmailContainingIgnoreCase("jose@exemplo.com");
            if(usuario2.isEmpty()) {
                usuario2= Optional.of(new Usuario());
                usuario2.get().setNome("Jose");
                usuario2.get().setSenha(passwordEncoder.encode("senhaUsuario"));
                usuario2.get().setEmail("jose@exemplo.com");
                usuarioRepository.save(usuario2.get());
            }

            Optional<Usuario> usuario3 = usuarioRepository.findByEmailContainingIgnoreCase("maria@exemplo.com");
            if(usuario3.isEmpty()) {
                usuario3= Optional.of(new Usuario());
                usuario3.get().setNome("Maria");
                usuario3.get().setSenha(passwordEncoder.encode("senhaUsuario"));
                usuario3.get().setEmail("maria@exemplo.com");
                usuarioRepository.save(usuario3.get());
            }

            //Usuarios-------------------------------------------

            //Tecnico---------------------------------------------
            Optional<Tecnico> tecnico = tecnicoRepository.findByEmailContainingIgnoreCase("marcelo@exemplo.com");
            if(tecnico.isEmpty()) {
                tecnico= Optional.of(new Tecnico());
                tecnico.get().setNome("Marcelo");
                tecnico.get().setSenha(passwordEncoder.encode("senhaUsuario"));
                tecnico.get().setEmail("marcelo@exemplo.com");
                tecnicoRepository.save(tecnico.get());
            }
        Optional<Tecnico> tecnico1 = tecnicoRepository.findByEmailContainingIgnoreCase("juliano@exemplo.com");
        if(tecnico1.isEmpty()) {
            tecnico1= Optional.of(new Tecnico());
            tecnico1.get().setNome("Juliano");
            tecnico1.get().setSenha(passwordEncoder.encode("senhaUsuario"));
            tecnico1.get().setEmail("juliano@exemplo.com");
            tecnicoRepository.save(tecnico1.get());
        }
        Optional<Tecnico> tecnico2 = tecnicoRepository.findByEmailContainingIgnoreCase("giselly@exemplo.com");
        if(tecnico2.isEmpty()) {
            tecnico2= Optional.of(new Tecnico());
            tecnico2.get().setNome("Giselly");
            tecnico2.get().setSenha(passwordEncoder.encode("senhaUsuario"));
            tecnico2.get().setEmail("giselly@exemplo.com");
            tecnicoRepository.save(tecnico2.get());
        }
        Optional<Tecnico> tecnico3 = tecnicoRepository.findByEmailContainingIgnoreCase("luana@exemplo.com");
        if(tecnico3.isEmpty()) {
            tecnico3= Optional.of(new Tecnico());
            tecnico3.get().setNome("Luana");
            tecnico3.get().setSenha(passwordEncoder.encode("senhaUsuario"));
            tecnico3.get().setEmail("luana@exemplo.com");
            tecnicoRepository.save(tecnico3.get());
        }
            //Tecnico---------------------------------

    }

}
