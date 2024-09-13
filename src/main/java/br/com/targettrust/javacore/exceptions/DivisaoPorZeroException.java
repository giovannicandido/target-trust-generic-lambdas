package br.com.targettrust.javacore.exceptions;

public class DivisaoPorZeroException extends RuntimeException {
    private final String mensagem = "Não é possivel dividir por zero";
    private final Double valorDivisor;
    private final Double valorDividendo;

    public DivisaoPorZeroException(Double valorDivisor, Double valorDividendo) {
        this.valorDivisor = valorDivisor;
        this.valorDividendo = valorDividendo;
    }

    @Override
    public String getMessage() {
        return mensagem;
    }

    public Double getValorDivisor() {
        return valorDivisor;
    }

    public Double getValorDividendo() {
        return valorDividendo;
    }
}
