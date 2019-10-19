package br.com.dogsteps.models;

import java.io.Serializable;

public class TesPet implements Serializable {

    private int i;
    private String nome;
    private int i1;

    public TesPet(int i, String nome, int i1) {
        this.i = i;
        this.nome = nome;
        this.i1 = i1;
    }
    public TesPet() {
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getI1() {
        return i1;
    }

    public void setI1(int i1) {
        this.i1 = i1;
    }

    @Override
    public String toString() {
        return "Nome:" + this.nome + " idade:" + this.i1;

    }
}
