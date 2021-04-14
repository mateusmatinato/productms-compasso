package com.compasso.productms.config;

import com.compasso.model.Error;
import com.compasso.productms.exception.GenericException;
import com.compasso.productms.exception.ProductNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
@Slf4j
public class ExceptionHandlerConfig{

    @ExceptionHandler({ ProductNotFoundException.class })
    public ResponseEntity<Error> handleException(Exception e) {
        log.error(String.format("-> Erro na requisição: %s", e.getMessage()));
        Error erro = new Error().statusCode(404).message(e.getMessage());
        return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ MethodArgumentNotValidException.class, MethodArgumentTypeMismatchException.class})
    public ResponseEntity<Error> handleErrorPayload(Exception e) {
        log.error(String.format("-> Erro na requisição: %s", e.getMessage()));
        Error erro = new Error().statusCode(400).message("Ocorreu um erro na requisição, verifique os campos enviados.");
        return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<Error> handleErrorMethodNotFound(Exception e) {
        log.error(String.format("-> Erro na requisição: %s", e.getMessage()));
        Error erro = new Error().statusCode(400).message("Esse endpoint não suporta o método solicitado. Verifique a documentação.");
        return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ GenericException.class })
    public ResponseEntity<Error> handleGenericError(GenericException e) {
        log.error(String.format("-> Erro na requisição: %s", e.getError()));
        Error erro = new Error().statusCode(400).message(e.getMessage());
        return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
    }
}
