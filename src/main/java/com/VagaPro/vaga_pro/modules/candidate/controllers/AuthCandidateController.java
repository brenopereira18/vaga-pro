package com.VagaPro.vaga_pro.modules.candidate.controllers;

import com.VagaPro.vaga_pro.modules.candidate.dto.AuthCandidateDTO;
import com.VagaPro.vaga_pro.modules.candidate.useCases.AuthCandidateUseCase;
import com.VagaPro.vaga_pro.providers.JWTCandidateProvider;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
@Tag(name = "Candidato", description = "Informações do candidato")

public class AuthCandidateController {

    @Autowired
    private AuthCandidateUseCase authCandidateUseCase;

    @PostMapping("/auth")
    @Operation(summary = "Autenticação de candidato", description = "Essa função é responsavel pela autenticação do candidato")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = JWTCandidateProvider.class))
            }),
            @ApiResponse(responseCode = "400", description = "Usuário não cadastrado")
    })
    public ResponseEntity<Object> auth(@RequestBody AuthCandidateDTO authCandidateDTO) {
        try {
            var token = authCandidateUseCase.execute(authCandidateDTO);
            return ResponseEntity.ok().body(token);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
