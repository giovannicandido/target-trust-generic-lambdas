package br.com.targettrust.javacore.exceptionSpring.repository;

public class UniqueContraintException extends RuntimeException {
    public UniqueContraintException(String message) {
        super(message);
    }
}
