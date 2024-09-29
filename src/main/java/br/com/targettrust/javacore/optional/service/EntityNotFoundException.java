package br.com.targettrust.javacore.optional.service;

public class EntityNotFoundException extends RuntimeException {
    private final String entity;
    private final String id;

    public EntityNotFoundException(String entity, String id) {
        this.entity = entity;
        this.id = id;
    }

    public String getEntity() {
        return entity;
    }

    public String getId() {
        return id;
    }
}
