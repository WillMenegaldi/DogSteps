package br.com.dogsteps.dao;

import br.com.dogsteps.interfaces.DAO;
import br.com.dogsteps.models.Tour;

import java.util.List;

public class TimeScheduleDAO implements DAO<Tour, Integer> {

    @Override
    public Tour get(Integer integer) {
        return null;
    }

    @Override
    public boolean add(Tour tour) {
        return false;
    }

    @Override
    public boolean remove(Integer integer) {
        return false;
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
