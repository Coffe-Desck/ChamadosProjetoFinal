package com.ElasTechProjetoFinal.repository;

import com.ElasTechProjetoFinal.model.Setor;
import com.ElasTechProjetoFinal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Long> {
    @Query("SELECT setor FROM Setor setor WHERE setor.nome = :nome")
    Optional<Setor> findByNomeContainingIgnoreCase(String nome);

}

