package com.VagaPro.vaga_pro.modules.company.repositories;

import com.VagaPro.vaga_pro.modules.company.entities.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {

}
