package br.com.danllopes.autostoreweb.domain.exceptions;

public class InvalidTokenException extends RuntimeException{
    public InvalidTokenException(String message) {super(message);}
}
