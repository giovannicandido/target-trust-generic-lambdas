package br.com.targettrust.javacore.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ExemploLambda {

    public static void main(String[] args) {
        Funcao funcao = new Funcao() {
            @Override
            public void execute() {
                System.out.println("Executando função lambda");
            }
        };

        Executavel executavel = new Executavel();
        executavel.executar(funcao);

        executavel.executar(() -> System.out.println("Exemplo de @FunctionalInterface"));

        Runnable lambda = () -> System.out.println("Executando função lambda");

        executavel.executarLambda(lambda);
        executavel.executarLambda(() -> System.out.println("Executando funçao lambda"));

        executavel.executarLambda(() -> {
            System.out.println("Executando linha 1");
            System.out.println("Executando linha 2");
        });

        List<Integer> integers = List.of(1, 2, 3, 4, 5);

        integers.forEach((i) -> {
            System.out.println("Tenho um numero da lista");
            System.out.printf("Esse numero é %s", i);
        });

        List<Integer> doubleInt = integers.stream().map(item -> item * 4).toList();

        doubleInt.forEach(System.out::println);

        RelatorioVendas relatorioVendas = new RelatorioVendas(new VendaService());
        relatorioVendas.relatorioVendasDoMes();

        exemploTranformacao();

        exemploFlatMap();
        exemploReduce();
    }


    public static void exemploTranformacao() {

        List<String> palavras = List.of("BANANA", "MORANGO", "ABACATE", "CARRO", "PARALELEPIPIDO", "ABACAXI");
        List<Character> primeirasLetras = palavras.stream()
                .filter(p -> p.length() > 5)
                .map(String::toLowerCase)
                .map(p -> p.charAt(0))
                .toList();
        List<Venda> vendas = List.of(new Venda("Sabonete", 20, 105.00),
                new Venda("Chocolate", 20, 15.00),
                new Venda("Sabonete", 10, 20.00));

        Map<String, Double> valoresAgrupados = vendas.stream()
                .collect(Collectors.groupingBy(Venda::getProduto, Collectors.summingDouble(Venda::getValor)));

        for (Character primeirasLetra : primeirasLetras) {
            System.out.println(primeirasLetra);
        }

        valoresAgrupados.forEach((key, value) -> {
            System.out.println(key + " - " + value);
        });
    }

    public static void exemploFlatMap() {
        List<List<Integer>> numeros = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9, 1)
        );
        System.out.println(numeros);
        Set<Integer> todosNumeros = numeros.stream().flatMap(List::stream).collect(Collectors.toSet());

        System.out.println(todosNumeros);

    }

    public static void exemploReduce() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer soma = numeros.stream().reduce(0, (x, y) ->
            {
                Integer sum = x + y;
                return sum;
            }
        );
        System.out.println(soma);
    }

}
