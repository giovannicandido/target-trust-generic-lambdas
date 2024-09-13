package br.com.targettrust.javacore.generic;

public class MinhaCaixa<T> {
    private T item;

    public void add(T item) {
       this.item = item;
    }


    public void remove() {
        this.item = null;
    }



    public T get() {
        return this.item;
    }

}
