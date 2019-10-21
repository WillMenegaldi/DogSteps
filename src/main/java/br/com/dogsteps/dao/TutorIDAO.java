package br.com.dogsteps.dao;

import br.com.dogsteps.interfaces.IDAO;
import br.com.dogsteps.models.Tutor;

import java.util.List;

public class TutorIDAO implements IDAO<Tutor, Integer> {

    @Override
    public Tutor get(Integer integer) {
        return null;
    }

    @Override
    public boolean add(Tutor tutor) {
        return false;
    }

    @Override
    public boolean remove(Integer integer) {
        return false;
    }

    @Override
    public boolean update(Tutor tutor) {
        return false;
    }

    @Override
    public List<Tutor> getAll() {
        return null;
    }
}
