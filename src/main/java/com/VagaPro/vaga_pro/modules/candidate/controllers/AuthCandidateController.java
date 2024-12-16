package com.VagaPro.vaga_pro.modules.candidate.controllers;

import com.VagaPro.vaga_pro.modules.candidate.dto.AuthCandidateDTO;
import com.VagaPro.vaga_pro.modules.candidate.dto.AuthCandidateResponseDTO;
import com.VagaPro.vaga_pro.modules.candidate.useCases.AuthCandidateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthCandidateController {

    @Autowired
    private AuthCandidateUseCase authCandidateUseCase;

    @PostMapping("/candidate")
    public ResponseEntity<Object> auth(@RequestBody AuthCandidateDTO authCandidateDTO) {
        try {
            var token = authCandidateUseCase.execute(authCandidateDTO);
            return ResponseEntity.ok().body(token);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
