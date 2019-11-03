package br.com.dogsteps.models.dto;

import br.com.dogsteps.enums.EPort;
import br.com.dogsteps.models.Agenda;

public class DogWalkerDTO {
    String endereco;
    EPort porte;
    Agenda agenda;

    public DogWalkerDTO(String endereco, EPort porte, Agenda agenda) {
        this.endereco = endereco;
        this.porte = porte;
        this.agenda = agenda;
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

    public Agenda getAgenda() {
        return agenda;
    }
    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    DogWalkerDTO(){}
}
