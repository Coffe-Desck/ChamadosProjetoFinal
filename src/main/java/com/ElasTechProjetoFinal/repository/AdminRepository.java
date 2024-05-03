package com.ElasTechProjetoFinal.repository;

import com.ElasTechProjetoFinal.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
