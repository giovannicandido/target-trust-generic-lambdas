package br.com.targettrust.javacore.generic;

import java.util.List;

public class ExemploGenerics {
    public static void main(String[] args) {
//        MinhaCaixa caixa = new MinhaCaixa();
//        caixa.add("");
//        caixa.add(1);
//        caixa.remove("");
//        caixa.remove(1);
//        caixa.get();
//        caixa.getInteger();

        MinhaCaixa<String> caixaString = new MinhaCaixa<>();
        MinhaCaixa<Integer> caixaInteger = new MinhaCaixa<>();
        MinhaCaixa<Boolean> caixaBoolean = new MinhaCaixa<>();

        caixaString.add("");
        caixaInteger.add(1);
        caixaBoolean.add(true);

        MinhaCaixa2 minhaCaixa2 = new MinhaCaixa2();
        minhaCaixa2.add("");
        minhaCaixa2.add(1);
        minhaCaixa2.add(true);

        // Exemplos

        List<Integer> integerList = List.of(1, 2, 3);

        integerList.forEach(item -> {
            System.out.printf("soma: %s" + item + integerList.get(2));
        } );

        MinhaCaixa minhaCaixaObject = new MinhaCaixa<>();

        minhaCaixaObject.add("");
        minhaCaixaObject.add(1L);
        minhaCaixaObject.add(true);

        Par<CountryCode, String> brasil = new Par<>(CountryCode.BR, "Brasil");
        Par<CountryCode, String> us = new Par<>(CountryCode.US, "United States of America");
        Par<CountryCode, String> ar = new Par<>(CountryCode.AR, "Argentina");

        Par<String, String> codigo = new Par<>("BR", "Brasil");
    }
}