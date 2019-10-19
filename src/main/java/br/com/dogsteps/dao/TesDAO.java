package br.com.dogsteps.dao;

import br.com.dogsteps.models.TesPet;
import java.util.ArrayList;
import java.util.List;

public class TesDAO {
    List<TesPet> lis = new ArrayList<>();

    public TesDAO(){
        lis.add(new TesPet(1, "Jao", 18));
        lis.add(new TesPet(2, "Jao", 18));
        lis.add(new TesPet(3, "Jao", 18));
        lis.add(new TesPet(4, "Jao", 18));
    }
    public List<TesPet> getList(){
        return this.lis;
    }

    public TesPet getTes(int id){
        return this.lis.get(id);
    }
}
