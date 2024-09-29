package br.com.targettrust.javacore.optional.repository;

import br.com.targettrust.javacore.exceptionSpring.model.Carro;

import java.util.Optional;

public interface CarroRepository {

    Optional<Carro> findById(String id);

    void save(Carro carro);
}
