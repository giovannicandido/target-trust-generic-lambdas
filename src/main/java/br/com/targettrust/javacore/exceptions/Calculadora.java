package br.com.targettrust.javacore.exceptions;

public class Calculadora {

    public double dividir(double dividendo, double divisor) {
        if(divisor == 0) {
            throw new DivisaoPorZeroException(divisor, dividendo);
        }
        return dividendo / divisor;
    }
}
