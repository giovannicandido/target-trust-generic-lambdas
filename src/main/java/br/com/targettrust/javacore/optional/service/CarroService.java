package br.com.targettrust.javacore.optional.service;


import br.com.targettrust.javacore.exceptionSpring.model.Carro;
import br.com.targettrust.javacore.optional.repository.CarroRepository;

import java.util.Optional;

public class CarroService {
    private final CarroRepository repository;

    public CarroService(CarroRepository repository) {
        this.repository = repository;
    }

    public void darBaixaEmCarro(String placa, String cpfMotorista) {
        // Validar se dentro de prazo
        // Valida se o motorista não tem multa

        Optional<Carro> carroOptional = repository.findById(placa);

        // Disso para checar se é null não tem diferença
        // if(carroOptional != null)
        if(carroOptional.isPresent()){
            Carro carro = carroOptional.get();

        }
        // bem parecido com exemplo anterior
        carroOptional.ifPresent(carro -> {

        });
        // Retonar valores padrões
        Carro padrao = carroOptional.orElse(new Carro());

        // Essa linha é bem comum em banco de dados
        Carro carro = carroOptional.orElseThrow(() -> new EntityNotFoundException("Carro", placa));
        //
        carro.setEmBaixa(true);
        carro.setMotivoBaixa("Motorista solicitou a baixa");
        repository.save(carro);

        // Mais exemplos

        carroOptional
                .map( carroExistente -> {
                        String marca = carroExistente.getMarca();
                        // ...
                        return carroExistente; // map retornando o mesmo tipo permite encadear operações no carro
                })
                .map(carroExistente -> {
                    String motivoBaixa = carroExistente.getMotivoBaixa();
                    // ...
                    return carroExistente;
                }).orElseThrow(() -> new EntityNotFoundException("Carro", placa)); // Se em qualquer ponto do map o carro for nulo


    }
}
