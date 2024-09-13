package br.com.targettrust.javacore.exceptionSpring.api;

import br.com.targettrust.javacore.exceptionSpring.model.exceptions.DomainException;
import br.com.targettrust.javacore.exceptionSpring.model.exceptions.ValidateException;

public class ApiExceptionHandler {

    // No spring é possivel capturar a exceção em um so lugar
    public ApiError handle(ValidateException e) {
        return new ApiError(String.format("Formulario invalido veja a mensagem para corrigir: %s", e.getMessage()));
    }


    public ApiError handle(DomainException e) {

        return new ApiError(String.format("Encontramos um error favor tentar mais tarde novamente"));
    }


}
