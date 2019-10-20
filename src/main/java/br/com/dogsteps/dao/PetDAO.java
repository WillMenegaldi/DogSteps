package br.com.dogsteps.dao;

import br.com.dogsteps.interfaces.DAO;
import br.com.dogsteps.models.Pet;

import java.util.List;

public class PetDAO implements DAO<Pet,Integer> {

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

	@Override
	public List<Pet> getAll() {
		return null;
	}
}
