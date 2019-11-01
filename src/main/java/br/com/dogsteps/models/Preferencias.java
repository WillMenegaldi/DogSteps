package br.com.dogsteps.models;

import br.com.dogsteps.enums.EMood;
import br.com.dogsteps.enums.EPort;
import java.io.Serializable;

public class Preferencias implements Serializable {

    EPort porte;
    EMood temperamento;

    public Preferencias(EPort porte, EMood temperamento) {
        this.porte = porte;
        this.temperamento = temperamento;
    }

    public EPort getPorte() {
        return porte;
    }
    public void setPorte(EPort porte) {
        this.porte = porte;
    }

    public EMood getTemperamento() {
        return temperamento;
    }
    public void setTemperamento(EMood temperamento) {
        this.temperamento = temperamento;
    }

    public Preferencias() {
    }
}

