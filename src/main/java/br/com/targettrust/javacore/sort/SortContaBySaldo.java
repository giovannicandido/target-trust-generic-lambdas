package br.com.targettrust.javacore.sort;

import java.util.Comparator;
import java.util.Objects;

public class SortContaBySaldo implements Comparator<Conta> {
    @Override
    public int compare(Conta o1, Conta o2) {
        if(Objects.isNull(o1) || Objects.isNull(o2)) {
            return 0;
        }
        return - (o1.getSaldo().compareTo(o2.getSaldo()));

    }
}
