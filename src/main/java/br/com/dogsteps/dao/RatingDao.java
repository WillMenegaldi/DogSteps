package br.com.dogsteps.dao;

import br.com.dogsteps.interfaces.DAO;
import br.com.dogsteps.models.Rating;

import java.util.List;
import java.util.Optional;

public class RatingDao implements DAO<Rating, Integer> {

    @Override
    public Optional<Rating> get(Integer integer) {
        return null;
    }

    @Override
    public void add(Rating rating) {
    }

    @Override
    public Rating remove(Integer integer) {
        return null;
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
