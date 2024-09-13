package br.com.targettrust.javacore.lambda;

import java.util.List;

public class RelatorioVendas {
    private final VendaService vendaService;

    public RelatorioVendas(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    public void relatorioVendasDoMes() {

       List<Venda> vendas = vendaService.vendasDoMes(Mes.SETEMBRO);

       List<Double> valores = vendas.stream().map(v -> v.getValor()).toList();

       Double valorTotalMes = valores.stream().reduce(0.0, (x, y) -> x + y);

       System.out.println("Total de vendas do mes " + valorTotalMes);


    }

    public void relatorioVendasDoMes2() {
        Double valorTotalMes = vendaService.vendasDoMes(Mes.SETEMBRO).stream()
                .map(Venda::getValor)
                .map(valor -> calcularDesconto(valor, Mes.SETEMBRO))
                .reduce(0.0, (x, y) -> x + y);
        System.out.println("Total de vendas do mes " + valorTotalMes);
    }

    public Double calcularDesconto(Double valor, Mes mes) {
        return valor * 0.05;
    }

}
