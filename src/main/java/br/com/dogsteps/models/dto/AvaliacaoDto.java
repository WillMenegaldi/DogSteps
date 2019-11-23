package br.com.dogsteps.models.dto;

public class AvaliacaoDto {
    private String idDogWalker;

    public AvaliacaoDto(String idDogWalker) {
        this.idDogWalker = idDogWalker;
    }

    public String getIdDogWalker() {
        return idDogWalker;
    }
    public void setIdDogWalker(String idDogWalker) {
        this.idDogWalker = idDogWalker;
    }

    public AvaliacaoDto() {}
}
