package br.com.dogsteps.dao;

import br.com.dogsteps.interfaces.DAO;
import br.com.dogsteps.models.Dogwalker;

import java.util.List;
import java.util.Optional;

public class DogwalkerDAO implements DAO<Dogwalker, Integer> {

    @Override
    public Optional<Dogwalker> get(Integer integer) {
        return null;
    }

    @Override
    public void add(Dogwalker dogwalker) {
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
