package br.com.targettrust.javacore.generic;

public class MinhaCaixa2 {
    private Object item;

    public void add(Object item) {
        this.item = item;
    }


    public void remove() {
        this.item = null;
    }



    public Object get() {
        return this.item;
    }
}
