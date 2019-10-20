package br.com.dogsteps.dao;

import br.com.dogsteps.interfaces.DAO;
import br.com.dogsteps.models.Tour;

import java.util.List;
import java.util.Optional;

public class TourDAO implements DAO<Tour, Integer> {

    @Override
    public Optional<Tour> get(Integer integer) {
        return null;
    }

    @Override
    public void add(Tour tour) {
    }

    @Override
    public Tour remove(Integer integer) {
        return null;
    }

    @Override
    public boolean update(Tour tour, Integer integer) {
        return false;
    }

    @Override
    public List<Tour> getAll() {
        return null;
    }
}
