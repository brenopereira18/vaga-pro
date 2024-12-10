package com.VagaPro.vaga_pro.exceptions;

public class UserFoundException extends RuntimeException{
    public UserFoundException() {
        super("Usuário já existe.");
    }
}
