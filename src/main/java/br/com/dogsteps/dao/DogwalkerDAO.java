package br.com.dogsteps.dao;

import br.com.dogsteps.interfaces.DAO;
import br.com.dogsteps.models.Dogwalker;

import java.util.List;

public class DogwalkerDAO implements DAO<Dogwalker, Integer> {

    @Override
    public Dogwalker get(Integer integer) {
        return null;
    }

    @Override
    public boolean add(Dogwalker dogwalker) {
        return false;
    }

    @Override
    public boolean remove(Integer integer) {
        return false;
    }

    @Override
    public boolean update(Dogwalker dogwalker, Integer integer) {
        return false;
    }

    @Override
    public List<Dogwalker> getAll() {
        return null;
    }
}
