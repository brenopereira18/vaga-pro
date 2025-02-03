package com.VagaPro.vaga_pro.modules.candidate.useCases;

import com.VagaPro.vaga_pro.exceptions.JobNotFoundException;
import com.VagaPro.vaga_pro.exceptions.UserNotFoundException;
import com.VagaPro.vaga_pro.modules.candidate.entities.ApplyJobEntity;
import com.VagaPro.vaga_pro.modules.candidate.repositories.ApplyJobRepositoy;
import com.VagaPro.vaga_pro.modules.candidate.repositories.CandidateRepository;
import com.VagaPro.vaga_pro.modules.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApplyJobCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplyJobRepositoy applyJobRepositoy;

    public ApplyJobEntity execute(UUID idCandidate, UUID idJob) {
        this.candidateRepository.findById(idCandidate).orElseThrow(() -> {
            throw new UserNotFoundException();
        });

        this.jobRepository.findById(idJob).orElseThrow(() -> {
            throw new JobNotFoundException();
        });

        var applyJob = ApplyJobEntity.builder().candidateId(idCandidate).jobId(idJob).build();
        applyJob = applyJobRepositoy.save(applyJob);
        return applyJob;
    }
}
