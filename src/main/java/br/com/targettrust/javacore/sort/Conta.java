package br.com.targettrust.javacore.sort;

public class Conta implements Comparable<Conta> {
    private Double saldo;

    public Conta(Double saldo) {
        this.saldo = saldo;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public int compareTo(Conta o) {
//        if(this.saldo < o.saldo) {
//            return -1;
//        }
//        if(saldo > o.saldo) {
//            return 1;
//        }
//        return 0;

        return this.saldo.compareTo(o.saldo);
    }

    @Override
    public String toString() {
        return "Conta{" +
                "saldo=" + saldo +
                '}';
    }
}
