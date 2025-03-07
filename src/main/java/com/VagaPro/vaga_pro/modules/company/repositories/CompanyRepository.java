package com.VagaPro.vaga_pro.modules.company.repositories;

import com.VagaPro.vaga_pro.modules.company.entities.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {
    Optional<CompanyEntity> findByUsernameOrEmail(String username, String email);
    Optional<CompanyEntity> findByUsername(String username);
    Optional<CompanyEntity> findById(UUID id);
}
