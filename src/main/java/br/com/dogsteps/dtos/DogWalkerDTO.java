package br.com.dogsteps.dtos;

import br.com.dogsteps.enums.EPort;

public class DogWalkerDTO {
    String endereco;
    EPort porte;

    public DogWalkerDTO(String endereco, EPort porte) {
        this.endereco = endereco;
        this.porte = porte;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public EPort getPorte() {
        return porte;
    }
    public void setPorte(EPort porte) {
        this.porte = porte;
    }

    DogWalkerDTO(){}
}
