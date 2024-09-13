package br.com.targettrust.javacore.exceptionSpring.api;

import br.com.targettrust.javacore.exceptionSpring.model.Carro;
import br.com.targettrust.javacore.exceptionSpring.service.CarroService;

public class CarroController {
    private final CarroService service;

    public CarroController(CarroService service) {
        this.service = service;
    }
    // pseudo controlle
    public void cadastrarCarro(Carro carro) {
        service.save(carro);
    }
}
