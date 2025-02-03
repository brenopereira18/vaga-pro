package com.VagaPro.vaga_pro.exceptions;

public class JobNotFoundException extends RuntimeException {
    public JobNotFoundException() {
        super("Vaga não existe");
    }
}
