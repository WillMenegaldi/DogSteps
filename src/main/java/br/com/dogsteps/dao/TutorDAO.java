package br.com.dogsteps.dao;

import br.com.dogsteps.interfaces.DAO;
import br.com.dogsteps.models.Tutor;

import java.util.List;
import java.util.Optional;

public class TutorDAO implements DAO<Tutor, Integer> {

    @Override
    public Optional<Tutor> get(Integer integer) {
        return null;
    }

    @Override
    public void add(Tutor tutor) {
    }

    @Override
    public Tutor remove(Integer integer) {
        return null;
    }

    @Override
    public boolean update(Tutor tutor, Integer integer) {
        return false;
    }

    @Override
    public List<Tutor> getAll() {
        return null;
    }
}
