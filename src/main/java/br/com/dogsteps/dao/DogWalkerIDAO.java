package br.com.dogsteps.dao;

import br.com.dogsteps.interfaces.IDAO;
import br.com.dogsteps.models.DogWalker;

import java.util.List;

public class DogWalkerIDAO implements IDAO<DogWalker, Integer> {

    @Override
    public DogWalker get(Integer integer) {
        return null;
    }

    @Override
    public boolean add(DogWalker dogwalker) {
        return false;
    }

    @Override
    public boolean remove(Integer integer) {
        return false;
    }

    @Override
    public boolean update(DogWalker dogwalker) {
        return false;
    }

    @Override
    public List<DogWalker> getAll() {
        return null;
    }
}
