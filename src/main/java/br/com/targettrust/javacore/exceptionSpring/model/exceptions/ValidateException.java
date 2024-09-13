package br.com.targettrust.javacore.exceptionSpring.model.exceptions;

public class ValidateException extends DomainException {
    private final String field;
    private final String message;

    public ValidateException(String field, String message) {
        this.field = field;
        this.message = message;
    }
}
