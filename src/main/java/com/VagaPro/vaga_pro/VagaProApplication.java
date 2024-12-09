package com.VagaPro.vaga_pro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.VagaPro.vaga_pro")
public class VagaProApplication {

	public static void main(String[] args) {
		SpringApplication.run(VagaProApplication.class, args);
	}

}
