package com.ElasTechProjetoFinal.repository;

import com.ElasTechProjetoFinal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    @Query("SELECT usuario FROM Usuario usuario WHERE usuario.email = :email")
    Optional<Usuario> findByEmailContainingIgnoreCase(String email);
    Optional<Usuario> findById(Long id);

}
