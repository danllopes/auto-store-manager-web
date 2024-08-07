package br.com.danllopes.autostoreweb.domain.exceptions;

public class LoginAlreadyExistsException extends RuntimeException{
    public LoginAlreadyExistsException(String message) {super(message);}
}