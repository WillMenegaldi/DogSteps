package br.com.dogsteps.models;

import java.util.UUID;

public class Configuracoes {
    private String id;

    public Configuracoes(UUID id) {
        this.id = id.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Configuracoes() {
        this.id = UUID.randomUUID().toString();
    }
}
