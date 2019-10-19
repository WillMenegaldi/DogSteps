package br.com.dogsteps.dao;

import br.com.dogsteps.interfaces.DAO;
import br.com.dogsteps.models.Rating;

import java.util.List;

public class RatingDao implements DAO<Rating, Integer> {

    @Override
    public Rating get(Integer integer) {
        return null;
    }

    @Override
    public boolean add(Rating rating) {
        return false;
    }

    @Override
    public boolean remove(Integer integer) {
        return false;
    }

    @Override
    public boolean update(Rating rating, Integer integer) {
        return false;
    }

    @Override
    public List<Rating> getAll() {
        return null;
    }
}
