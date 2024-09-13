package br.com.targettrust.javacore.exceptionSpring.repository;

import br.com.targettrust.javacore.exceptionSpring.model.Carro;

public class CarroRepository {
    public void save(Carro carro) {
        // Tenta salvar;

        throw new UniqueContraintException("Marca do carro tem que ser única");

    }
}
