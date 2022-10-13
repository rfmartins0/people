package br.com.auth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.jsonwebtoken.SignatureException;

@ControllerAdvice
public class ErrorHandler {

    @ResponseBody
    @ExceptionHandler(SignatureException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String validateExceptionHandler(final SignatureException ex) {
        return "Token Inválido";
    }

}
