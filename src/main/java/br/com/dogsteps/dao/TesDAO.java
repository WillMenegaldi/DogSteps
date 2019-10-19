package br.com.dogsteps.dao;

import br.com.dogsteps.interfaces.DAO;
import br.com.dogsteps.models.Pet;

import java.util.ArrayList;
import java.util.List;

public class TesDAO implements DAO<Pet, Integer> {
    List<Pet> lis = new ArrayList<Pet>();

    /*public TesDAO(){
        lis.add(new Pet(1, "Jao", 18));
        lis.add(new Pet(2, "Jao", 18));
        lis.add(new Pet(3, "Jao", 18));
        lis.add(new Pet(4, "Jao", 18));
    }*/
    public List<Pet>  getList(){
        return this.lis;
    }

    public Pet getTes(int id){
        return this.lis.get(id);
    }

    @Override
    public List<Pet> getAll() {
        return null;
    }

    @Override
    public Pet get(Integer integer) {
        return null;
    }

    @Override
    public boolean add(Pet pet) {
        return false;
    }

    @Override
    public boolean remove(Integer integer) {
        return false;
    }

    @Override
    public boolean update(Pet pet, Integer integer) {
        return false;
    }
}
