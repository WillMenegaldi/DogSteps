package br.com.dogsteps.models;


import br.com.dogsteps.enums.EFisicStatus;
import br.com.dogsteps.enums.EMood;
import br.com.dogsteps.enums.EPort;

public class Feature {

    private EPort port;

    private EMood mood;

    private EFisicStatus fisicStatus;

    private Dogwalker dogwalker;

    private Pet pet;

    public Feature(EPort p, EMood m, EFisicStatus f) {
        setPort(p);
        setMood(m);
        setFisicStatus(f);
    }

    public EPort getPort() {
        return port;
    }

    public void setPort(EPort port) {
        this.port = port;
    }

    public EMood getMood() {
        return mood;
    }

    public void setMood(EMood mood) {
        this.mood = mood;
    }

    public EFisicStatus getFisicStatus() {
        return fisicStatus;
    }

    public void setFisicStatus(EFisicStatus fisicStatus) {
        this.fisicStatus = fisicStatus;
    }

    public Dogwalker getDogwalker() {
        return dogwalker;
    }

    public void setDogwalker(Dogwalker dogwalker) {
        this.dogwalker = dogwalker;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
