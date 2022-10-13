package br.com.people.exception;

import java.util.List;

public class ErrorDetails {

    private List<String> message;

    public ErrorDetails(final List<String> message) {
        this.message = message;
    }

    public ErrorDetails(final String message) {
        this.message = List.of(message);
    }

    public List<String> getMessage() {
        return message;
    }

}
