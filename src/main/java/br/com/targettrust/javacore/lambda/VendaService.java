package br.com.targettrust.javacore.lambda;

import java.util.List;

public class VendaService {

    public List<Venda> vendasDoMes(Mes mes) {
        return List.of(
                new Venda("Sabonete", 20, 105.00 ),
                new Venda("Café", 100, 504.56),
                new Venda("Mate", 500, 1204.67),
                new Venda("Chocolate", 43, 205.78),
                new Venda("Papel", 30, 304.5)
        );
    }
}
