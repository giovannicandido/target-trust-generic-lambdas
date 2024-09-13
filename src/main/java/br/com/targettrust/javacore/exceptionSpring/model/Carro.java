package br.com.targettrust.javacore.exceptionSpring.model;

import br.com.targettrust.javacore.exceptionSpring.model.exceptions.ValidateException;

public class Carro {

    private String marca;

    public void validate() {
        if(marca == null) {
            throw new ValidateException("marca", "Não pode ser nula");
        }
    }
}
