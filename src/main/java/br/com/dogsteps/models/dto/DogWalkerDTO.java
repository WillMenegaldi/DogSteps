package br.com.dogsteps.models.dto;

import br.com.dogsteps.enums.EPort;
import br.com.dogsteps.models.Agenda;
import br.com.dogsteps.models.Coordenada;
import java.util.List;

public class DogWalkerDTO {
    private String endereco;
    private List<Coordenada> coordenadas;
    private EPort porte;
    private Agenda agenda;

    public DogWalkerDTO(String endereco, List<Coordenada> coordenadas, EPort porte, Agenda agenda) {
        this.endereco = endereco;
        this.coordenadas = coordenadas;
        this.porte = porte;
        this.agenda = agenda;
    }

    public List<Coordenada> getCoordenadas() {
        return coordenadas;
    }
    public void setCoordenadas(List<Coordenada> coordenadas) {
        this.coordenadas = coordenadas;
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
