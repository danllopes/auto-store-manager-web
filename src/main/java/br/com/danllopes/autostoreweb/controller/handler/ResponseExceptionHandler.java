package br.com.danllopes.autostoreweb.controller.handler;

import br.com.danllopes.autostoreweb.domain.exceptions.*;
import com.sun.net.httpserver.HttpsServer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

@ControllerAdvice
@RestController
public class ResponseExceptionHandler {

    @ExceptionHandler(CarNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleCarNotFoundException(Exception ex, WebRequest request) {
        ExceptionResponse response = this.buildExceptionResponse(ex, request, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MotorcycleNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleMotorcycleNotFoundException(Exception ex, WebRequest request) {
        ExceptionResponse response = this.buildExceptionResponse(ex, request, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<ExceptionResponse> handleInvalidTokenException(Exception ex, WebRequest request) {
        ExceptionResponse response = this.buildExceptionResponse(ex, request, HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity<ExceptionResponse> handleDuplicateEmailException(Exception ex, WebRequest request) {
        ExceptionResponse response = this.buildExceptionResponse(ex, request, HttpStatus.CONFLICT);
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(LoginAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleLoginAlreadyExistsException(Exception ex, WebRequest request) {
        ExceptionResponse response = this.buildExceptionResponse(ex, request, HttpStatus.CONFLICT);
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleUserNotFoundException(Exception ex, WebRequest request) {
        ExceptionResponse response = this.buildExceptionResponse(ex, request, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    private ExceptionResponse buildExceptionResponse(Exception ex, WebRequest request, HttpStatus status) {
        return new ExceptionResponse(LocalDate.now(), ex.getMessage(), request.getDescription(false), status);
    }
}
