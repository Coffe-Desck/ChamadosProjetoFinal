package com.ElasTechProjetoFinal.repository;

import com.ElasTechProjetoFinal.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StatusRepository extends JpaRepository<Status, Long> {
    @Query("SELECT status FROM Status status WHERE status.nome = :nome")
    Optional<Status> findByNomeContainingIgnoreCase(String nome);
}
