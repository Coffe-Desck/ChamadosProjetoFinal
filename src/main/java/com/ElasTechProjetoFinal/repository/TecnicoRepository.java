package com.ElasTechProjetoFinal.repository;

import com.ElasTechProjetoFinal.model.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
    @Query("SELECT tecnico FROM Tecnico tecnico WHERE tecnico.email = :email")
    Optional<Tecnico> findByEmailContainingIgnoreCase(String email);
}
