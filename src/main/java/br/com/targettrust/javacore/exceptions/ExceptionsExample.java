package br.com.targettrust.javacore.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionsExample {
    public static void main(String[] args) throws IOException {
        FileInputStream file = null;
        try {
            file = new FileInputStream("arquivo.txt");

        } catch (FileNotFoundException e) {
            System.out.printf("Erro ao abrir arquivo %s", e.getMessage());
            throw new RuntimeException(e);
        } finally { // sempre executa independe se deu erro ou não no try
            file.close();
        }

        MinhaClasse minhaClasse = new MinhaClasse();
        try {
            minhaClasse.abrirArquivo();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // não é obrigado a tratar o error por ser runtime
        minhaClasse.gravarArquivo();

        try {
            minhaClasse.gravarArquivo();
        } catch (RuntimeException e) { // Somente executa se tiver exceção
            System.out.println("Querido usuario tem um erro ao gravar arquivo");
        }

        // mesmo exemplo do arquivo com try-with-resource (java >=7)
        try (FileInputStream file2 = new FileInputStream("arquivo.txt")) {
            file2.read();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler o arquivo");
        }

        // Exception customizada

        Calculadora calculadora = new Calculadora();
        try {
            calculadora.dividir(10, 0);
        } catch (DivisaoPorZeroException e) {
            System.out.printf("Usuario entre com um divisor diferente de zero, seus parametros são invalidos dividor %s e dividendo %s", e.getValorDivisor(), e.getValorDividendo());
        }
    }
}
