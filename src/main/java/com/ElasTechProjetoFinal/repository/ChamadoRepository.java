package com.ElasTechProjetoFinal.repository;

import com.ElasTechProjetoFinal.model.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, UUID> {
}
