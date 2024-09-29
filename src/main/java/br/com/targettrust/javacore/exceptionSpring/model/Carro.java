package br.com.targettrust.javacore.exceptionSpring.model;

import br.com.targettrust.javacore.exceptionSpring.model.exceptions.ValidateException;

public class Carro {

    private String marca;
    private boolean emBaixa;
    private String motivoBaixa;

    public void validate() {
        if(marca == null) {
            throw new ValidateException("marca", "Não pode ser nula");
        }
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isEmBaixa() {
        return emBaixa;
    }

    public void setEmBaixa(boolean emBaixa) {
        this.emBaixa = emBaixa;
    }

    public String getMotivoBaixa() {
        return motivoBaixa;
    }

    public void setMotivoBaixa(String motivoBaixa) {
        this.motivoBaixa = motivoBaixa;
    }
}
