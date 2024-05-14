package com.ElasTechProjetoFinal.repository;

import com.ElasTechProjetoFinal.model.Prioridade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrioridadeRepository extends JpaRepository<Prioridade, Long> {
    @Query("SELECT prioridade FROM Prioridade prioridade WHERE prioridade.nome = :nome")
    Optional<Prioridade> findByNameContainingIgnoreCase(String nome);
}
