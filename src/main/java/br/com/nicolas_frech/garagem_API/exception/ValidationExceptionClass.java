package br.com.nicolas_frech.garagem_API.exception;

public class ValidationExceptionClass extends RuntimeException {
    public ValidationExceptionClass(String message) {
        super(message);
    }
}
