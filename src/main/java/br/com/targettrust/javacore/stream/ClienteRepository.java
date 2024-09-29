package br.com.targettrust.javacore.stream;

public interface ClienteRepository {
    Cliente getByNome(String nome);
    boolean existsByNome(String nome);
}
