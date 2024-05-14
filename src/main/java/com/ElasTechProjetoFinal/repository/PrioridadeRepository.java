package com.ElasTechProjetoFinal.repository;

import com.ElasTechProjetoFinal.model.Prioridade;
import com.ElasTechProjetoFinal.model.Setor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrioridadeRepository extends JpaRepository<Prioridade, Long> {
    @Query("SELECT prioridade FROM Prioridade prioridade WHERE prioridade.prioridade = :prioridade")
    Optional<Prioridade> findByPrioridadeContainingIgnoreCase(String prioridade);
}
