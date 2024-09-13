package br.com.targettrust.javacore.exceptions;

public class MinhaClasse {

    void abrirArquivo() throws Exception {
        System.out.println("Simulando abrir arquivo");
        throw new Exception("Simulação");
    }

    void gravarArquivo() throws RuntimeException {
        System.out.println("Simulando gravar arquivo");
        throw new RuntimeException("Simulação");
    }
}
