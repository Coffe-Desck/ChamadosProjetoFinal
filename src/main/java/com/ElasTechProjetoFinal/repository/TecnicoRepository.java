package com.ElasTechProjetoFinal.repository;

import com.ElasTechProjetoFinal.model.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {
}
