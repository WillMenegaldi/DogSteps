package br.com.dogsteps.models.dto;

import br.com.dogsteps.enums.EPort;
import br.com.dogsteps.models.Agenda;
import java.util.List;

public class DogWalkerDto {
    private String endereco;
    private List<Integer[]> coordenadas;
    private EPort porte;
    private Agenda agenda;

    public DogWalkerDto(String endereco, List<Integer[]> coordenadas, EPort porte, Agenda agenda) {
        this.endereco = endereco;
        this.coordenadas = coordenadas;
        this.porte = porte;
        this.agenda = agenda;
    }

    public List<Integer[]> getCoordenadas() {
        return coordenadas;
    }
    public void setCoordenadas(List<Integer[]> coordenadas) {
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

    DogWalkerDto(){}
}
