package br.com.targettrust.javacore.generic;

public class Par<K, V> {
    private K chave;
    private V valor;
    public Par(K chave, V valor) {
        this.chave = chave;
        this.valor = valor;
    }
    @Override
    public String toString() {
        return chave + " - " + valor;
    }
// Getters e setters
}
