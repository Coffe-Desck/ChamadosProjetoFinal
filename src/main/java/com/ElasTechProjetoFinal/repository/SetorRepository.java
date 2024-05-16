package com.ElasTechProjetoFinal.repository;

import com.ElasTechProjetoFinal.model.EnumSetor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SetorRepository extends JpaRepository<EnumSetor, String> {
    Optional<EnumSetor> findByNome(String nome);

}

