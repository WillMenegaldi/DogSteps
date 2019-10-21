package br.com.dogsteps.models;


import br.com.dogsteps.enums.EFisicStatus;
import br.com.dogsteps.enums.EMood;
import br.com.dogsteps.enums.EPort;

import java.io.Serializable;

public class Feature implements Serializable {

    private EPort port;

    private EMood mood;

    private EFisicStatus fisicStatus;

    public Feature(EPort p, EMood m, EFisicStatus f){
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

    public Feature(){}
}
