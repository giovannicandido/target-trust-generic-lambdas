package br.com.targettrust.javacore.lambda;

import java.util.function.Function;

public class Executavel {

    public void executar(Funcao funcao) {
        System.out.println("Inicado execução");
        funcao.execute();
        System.out.println("Teminado execução");
    }

    public void executarLambda(Runnable funcao) {
        System.out.println("Inicado execução");
        funcao.run();
        System.out.println("Teminado execução");
    }
}
