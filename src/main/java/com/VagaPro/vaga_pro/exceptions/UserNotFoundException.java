package com.VagaPro.vaga_pro.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("Usuário não existe");
    }
}
