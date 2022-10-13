package br.com.people.exception;

import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;

@ControllerAdvice
public class ErrorHandler {

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String validateExceptionHandler(final MethodArgumentNotValidException ex) {
        var errors = new ArrayList<String>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            var errorMessage = error.getDefaultMessage();
            var fieldName = ((FieldError) error).getField();
            var arguments = ((FieldError) error).getRejectedValue();
            errors.add("Campo: " + fieldName + " | Erro: " + errorMessage + " | Valor Incorreto: " + arguments);
        });
        final ErrorDetails errorDetails = new ErrorDetails(errors);
        String json = new Gson().toJson(errorDetails);
        return json.toString();
    }

    @ResponseBody
    @ExceptionHandler(TokenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String validateExceptionHandler(final TokenException ex) {
        final ErrorDetails errorDetails = new ErrorDetails(ex.getMessage());
        String json = new Gson().toJson(errorDetails);
        return json.toString();
    }







}
