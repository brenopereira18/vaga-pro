package com.VagaPro.vaga_pro.modules.company.useCases;

import com.VagaPro.vaga_pro.exceptions.CompanyNotFoundException;
import com.VagaPro.vaga_pro.modules.company.entities.JobEntity;
import com.VagaPro.vaga_pro.modules.company.repositories.CompanyRepository;
import com.VagaPro.vaga_pro.modules.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateJobUseCase {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public JobEntity execute(JobEntity jobEntity) {
        companyRepository.findById(jobEntity.getCompanyId()).orElseThrow(() -> {
            throw new CompanyNotFoundException();
        });
        return this.jobRepository.save(jobEntity);
    }
}
