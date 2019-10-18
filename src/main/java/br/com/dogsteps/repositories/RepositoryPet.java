package br.com.dogsteps.repositories;

import br.com.dogsteps.dao.TesDAO;
import br.com.dogsteps.models.Pet;

import java.util.List;

public class RepositoryPet {

    public static TesDAO tes = new TesDAO();
    public List<Pet> getList(){
        return tes.getList();
    }
    public Pet getTes(int id){
        return tes.getList().get(id);
    }
}
