package com.VagaPro.vaga_pro.modules.candidate.repositories;

import com.VagaPro.vaga_pro.modules.candidate.entities.ApplyJobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApplyJobRepositoy extends JpaRepository<ApplyJobEntity, UUID> {
}
