package com.VagaPro.vaga_pro;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.VagaPro.vaga_pro")
@OpenAPIDefinition(info = @Info(title = "Gestão de Vagas", description = "API responsável pela gestão de vagas", version = "1"))
public class VagaProApplication {

    public static void main(String[] args) {
        SpringApplication.run(VagaProApplication.class, args);
    }
}
