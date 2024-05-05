package com.ElasTechProjetoFinal.repository;

import com.ElasTechProjetoFinal.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    @Query("SELECT admin FROM Admin admin WHERE admin.email = :email")
    Optional<Admin> findByEmailContainingIgnoreCase(String email);
}
