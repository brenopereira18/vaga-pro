package com.VagaPro.vaga_pro.modules.candidate.useCases;

import com.VagaPro.vaga_pro.exceptions.UserNotFoundException;
import com.VagaPro.vaga_pro.modules.candidate.repositories.CandidateRepository;
import com.VagaPro.vaga_pro.modules.candidate.dto.ProfileCandidateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProfileCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    public ProfileCandidateDTO execute(UUID idCandidate) {
       var candidate = this.candidateRepository.findById(idCandidate)
               .orElseThrow(() -> {
                   throw new UserNotFoundException();
               });

       var candidateDTO = ProfileCandidateDTO.builder()
               .email(candidate.getEmail())
               .id(candidate.getId())
               .name(candidate.getName())
               .description(candidate.getDescription())
               .username(candidate.getUsername())
               .build();

       return candidateDTO;
    }
}
