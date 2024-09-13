package br.com.targettrust.javacore.sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SortExample {
    public static void main(String[] args) {
        List<Conta> contas = new ArrayList<>(List.of(
             new Conta(1.0),
             new Conta(2.0),
             new Conta(4.0),
             new Conta(3.0),
             new Conta(6.0),
             new Conta(5.0)
        ));

//        Collections.sort(contas); // Se tem acesso ao codigo fonte de conta, é o melhor implementar Comparable
        Collections.sort(contas, new SortContaBySaldo()); // Se não tem acesso ao codigo fonte de Conta
        System.out.println(contas);

    }

}
