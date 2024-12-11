package com.VagaPro.vaga_pro.modules.company.useCases;

import com.VagaPro.vaga_pro.modules.company.entities.JobEntity;
import com.VagaPro.vaga_pro.modules.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateJobUseCase {

    @Autowired
    private JobRepository jobRepository;

    public JobEntity execute(JobEntity jobEntity) {
        return this.jobRepository.save(jobEntity);
    }
}
