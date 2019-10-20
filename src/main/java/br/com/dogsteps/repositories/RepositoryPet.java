package br.com.dogsteps.repositories;

import br.com.dogsteps.dao.TesDAO;
import br.com.dogsteps.models.TesPet;
import java.util.List;

public class RepositoryPet {

    public static TesDAO tes = new TesDAO();
    public List<TesPet> getList(){
        return tes.getList();
    }
    public TesPet getTes(int id){
        return tes.getList().get(id);
    }
}
