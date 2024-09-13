package br.com.targettrust.javacore.exceptionSpring.service;

import br.com.targettrust.javacore.exceptionSpring.model.Carro;
import br.com.targettrust.javacore.exceptionSpring.repository.CarroRepository;

public class CarroService {
    private CarroRepository repository;
    public void save(Carro carro) {
        // Logica de negocio
        //....
        // No spring deixamos a execeção ser lançada
        carro.validate();
        // continua
        repository.save(carro);
    }
}
