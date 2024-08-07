package br.com.danllopes.autostoreweb.domain.exceptions;

public class DuplicateEmailException extends RuntimeException{
    public DuplicateEmailException(String message) {super(message);}
}
