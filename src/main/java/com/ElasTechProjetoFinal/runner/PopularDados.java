package com.ElasTechProjetoFinal.runner;
import com.ElasTechProjetoFinal.model.*;
import com.ElasTechProjetoFinal.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Configuration
public class PopularDados implements CommandLineRunner {

    private final AdminRepository adminRepository;
    private final UsuarioRepository usuarioRepository;
    private final TecnicoRepository tecnicoRepository;
    private final ChamadoRepository chamadoRepository;
    private final PrioridadeRepository prioridadeRepository;
    private final SetorRepository setorRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final StatusRepository statusRepository;

    @Autowired
    public PopularDados(AdminRepository adminRepository,
                        UsuarioRepository usuarioRepository,
                        TecnicoRepository tecnicoRepository,
                        ChamadoRepository chamadoRepository,
                        PrioridadeRepository prioridadeRepository,
                        SetorRepository setorRepository,
                        StatusRepository statusRepository) {
        this.adminRepository = adminRepository;
        this.usuarioRepository = usuarioRepository;
        this.tecnicoRepository = tecnicoRepository;
        this.chamadoRepository = chamadoRepository;
        this.prioridadeRepository = prioridadeRepository;
        this.setorRepository = setorRepository;
        this.statusRepository = statusRepository;

    }


    @Override
    public void run(String... args) throws Exception {

        jdbcTemplate.execute("ALTER TABLE admin ADD COLUMN IF NOT EXISTS role VARCHAR(50)");
        jdbcTemplate.execute("UPDATE admin SET role = 'USER' WHERE role IS NULL");
        jdbcTemplate.execute("ALTER TABLE admin ALTER COLUMN role SET NOT NULL");
        jdbcTemplate.execute("ALTER TABLE admin ADD CONSTRAINT check_role CHECK (role IN ('ADMIN', 'USER', 'TECHNICIAN'))");


        //Setor-----------------------------------
        Optional<Setor> setor = setorRepository.findByNomeContainingIgnoreCase("Administrativo");
        if(setor.isEmpty()) {
            setor = Optional.of(new Setor());
            setor.get().setNome("Administrativo");
            setorRepository.save(setor.get());
        }
        Optional<Setor> setor1 = setorRepository.findByNomeContainingIgnoreCase("Financeiro");
        if(setor1.isEmpty()) {
            setor1 = Optional.of(new Setor());
            setor1.get().setNome("Financeiro");
            setorRepository.save(setor1.get());
        }
        Optional<Setor> setor2= setorRepository.findByNomeContainingIgnoreCase("Recursos Humanos");
        if(setor2.isEmpty()) {
            setor2 = Optional.of(new Setor());
            setor2.get().setNome("Recursos Humanos");
        }
        Optional<Setor> setor3 = setorRepository.findByNomeContainingIgnoreCase("Comercial");
        if(setor3.isEmpty()) {
            setor3 = Optional.of(new Setor());
            setor3.get().setNome("Comercial");
            setorRepository.save(setor3.get());
        }
        Optional<Setor> setor4 = setorRepository.findByNomeContainingIgnoreCase("Operacional");
        if(setor4.isEmpty()) {
            setor4 = Optional.of(new Setor());
            setor4.get().setNome("Operacional");
            setorRepository.save(setor4.get());
        }

        Optional<Setor> setor5 = setorRepository.findByNomeContainingIgnoreCase("Tecnologia da Informação");
        if(setor5.isEmpty()) {
            setor5 = Optional.of(new Setor());
            setor5.get().setNome("Tecnologia da Informação");
            setorRepository.save(setor5.get());
        }

        Optional<Setor> setor6 = setorRepository.findByNomeContainingIgnoreCase("Recursos Humanos");
        if(setor6.isEmpty()) {
            setor6 = Optional.of(new Setor());
            setor6.get().setNome("Recursos Humanos");
            setorRepository.save(setor6.get());
        }
        //Setor-----------------------------------

        //Status------------------------------------
        Optional<Status> statusAguardando = statusRepository.findByNomeContainingIgnoreCase("Aguardando técnico");
        if (statusAguardando.isEmpty()) {
            statusAguardando = Optional.of(new Status());
            statusAguardando.get().setNome("Aguardando técnico");
            statusRepository.save(statusAguardando.get());
        }

        // Verifica se o status "Em atendimento" existe
        Optional<Status> statusEmAtendimento = statusRepository.findByNomeContainingIgnoreCase("Em atendimento");

        // Se não existir, cria um novo
        if (statusEmAtendimento.isEmpty()) {
            statusEmAtendimento = Optional.of(new Status());
            statusEmAtendimento.get().setNome("Em atendimento");
            statusRepository.save(statusEmAtendimento.get());
        }

        // Verifica se o status "Escalado para outro setor" existe
        Optional<Status> statusEscalado = statusRepository.findByNomeContainingIgnoreCase("Escalado para outro setor");

        // Se não existir, cria um novo
        if (statusEscalado.isEmpty()) {
            statusEscalado = Optional.of(new Status());
            statusEscalado.get().setNome("Escalado para outro setor");
            statusRepository.save(statusEscalado.get());
        }
        //status ---------------------------------------------
        //Prioridades---------------------------------

        Optional<Prioridade> prioridade = prioridadeRepository.findByNameContainingIgnoreCase("Alta");
        if(prioridade.isEmpty()) {
            prioridade = Optional.of(new Prioridade());
            prioridade.get().setNome("Alta");
            prioridadeRepository.save(prioridade.get());
        }
        Optional<Prioridade> prioridade1 = prioridadeRepository.findByNameContainingIgnoreCase("Media");
        if(prioridade1.isEmpty()) {
            prioridade1 = Optional.of(new Prioridade());
            prioridade1.get().setNome("Media");
            prioridadeRepository.save(prioridade1.get());
        }

        Optional<Prioridade> prioridade2 = prioridadeRepository.findByNameContainingIgnoreCase("Baixa");
        if(prioridade2.isEmpty()) {
            prioridade2 = Optional.of(new Prioridade());
            prioridade2.get().setNome("Baixa");
            prioridadeRepository.save(prioridade2.get());
        }
        //Prioridades-------------------------------

        //Adimin------------------------------------
        Optional<Admin> admin = adminRepository.findByEmailContainingIgnoreCase("marcelo@admin.com");
        if(admin.isEmpty()){
            admin = Optional.of(new Admin());
            admin.get().setNome("Marcelo");
            admin.get().setSenha(passwordEncoder.encode("12345678"));
            admin.get().setEmail("marcelo@admin.com");
            admin.get().setRole(EnumRole.ADMIN);
            adminRepository.save(admin.get());
        }

        Optional<Admin> admin2 = adminRepository.findByEmailContainingIgnoreCase("juliana@admin.com");
        if(admin2.isEmpty()) {
            admin2 = Optional.of(new Admin());
            admin2.get().setNome("Juliana");
            admin2.get().setSenha(passwordEncoder.encode("12345678"));
            admin2.get().setEmail("juliana@admin.com");
            admin2.get().setRole(EnumRole.ADMIN);
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
            usuario.get().setRole(EnumRole.USER);
            usuarioRepository.save(usuario.get());

        }

        Optional<Usuario> usuario1 = usuarioRepository.findByEmailContainingIgnoreCase("pedro@exemplo.com");
        if(usuario1.isEmpty()) {
            usuario1= Optional.of(new Usuario());
            usuario1.get().setNome("Pedro");
            usuario1.get().setSenha(passwordEncoder.encode("senhaUsuario"));
            usuario1.get().setEmail("pedro@exemplo.com");
            usuario1.get().setRole(EnumRole.USER);
            usuarioRepository.save(usuario1.get());
        }

        Optional<Usuario> usuario2 = usuarioRepository.findByEmailContainingIgnoreCase("jose@exemplo.com");
        if(usuario2.isEmpty()) {
            usuario2= Optional.of(new Usuario());
            usuario2.get().setNome("Jose");
            usuario2.get().setSenha(passwordEncoder.encode("senhaUsuario"));
            usuario2.get().setEmail("jose@exemplo.com");
            usuario2.get().setRole(EnumRole.USER);
            usuarioRepository.save(usuario2.get());
        }

        Optional<Usuario> usuario3 = usuarioRepository.findByEmailContainingIgnoreCase("maria@exemplo.com");
        if(usuario3.isEmpty()) {
            usuario3= Optional.of(new Usuario());
            usuario3.get().setNome("Maria");
            usuario3.get().setSenha(passwordEncoder.encode("senhaUsuario"));
            usuario3.get().setEmail("maria@exemplo.com");
            usuario3.get().setRole(EnumRole.USER);
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
            tecnico.get().setRole(EnumRole.TECHNICIAN);
            tecnicoRepository.save(tecnico.get());
        }
        Optional<Tecnico> tecnico1 = tecnicoRepository.findByEmailContainingIgnoreCase("juliano@exemplo.com");
        if(tecnico1.isEmpty()) {
            tecnico1= Optional.of(new Tecnico());
            tecnico1.get().setNome("Juliano");
            tecnico1.get().setSenha(passwordEncoder.encode("senhaUsuario"));
            tecnico1.get().setEmail("juliano@exemplo.com");
            tecnico1.get().setRole(EnumRole.TECHNICIAN);
            tecnicoRepository.save(tecnico1.get());
        }
        Optional<Tecnico> tecnico2 = tecnicoRepository.findByEmailContainingIgnoreCase("giselly@exemplo.com");
        if(tecnico2.isEmpty()) {
            tecnico2= Optional.of(new Tecnico());
            tecnico2.get().setNome("Giselly");
            tecnico2.get().setSenha(passwordEncoder.encode("senhaUsuario"));
            tecnico2.get().setEmail("giselly@exemplo.com");
            tecnico2.get().setRole(EnumRole.TECHNICIAN);
            tecnicoRepository.save(tecnico2.get());
        }
        Optional<Tecnico> tecnico3 = tecnicoRepository.findByEmailContainingIgnoreCase("luana@exemplo.com");
        if(tecnico3.isEmpty()) {
            tecnico3= Optional.of(new Tecnico());
            tecnico3.get().setNome("Luana");
            tecnico3.get().setSenha(passwordEncoder.encode("senhaUsuario"));
            tecnico3.get().setEmail("luana@exemplo.com");
            tecnico3.get().setRole(EnumRole.TECHNICIAN);
            tecnicoRepository.save(tecnico3.get());
        }
        //Tecnico---------------------------------

    }

}
