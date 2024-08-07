package br.com.danllopes.autostoreweb.domain.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {super(message);}
}