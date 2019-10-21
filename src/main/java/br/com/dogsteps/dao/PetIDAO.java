package br.com.dogsteps.dao;

import br.com.dogsteps.interfaces.IDAO;
import br.com.dogsteps.models.Pet;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class PetIDAO implements IDAO<Pet,Integer> {

	private HashMap<Integer, Pet> pets = new HashMap<>();

	@Override
	public Pet get(Integer id) {
		return Optional.ofNullable(pets.get(id)).get();
	}

	@Override
	public boolean add(Pet pet) {
		pets.put(pet.getId(), pet);
		return true;
	}

	@Override
	public boolean remove(Integer id) {
		return pets.remove(id) != null;
	}

	@Override
	public boolean update(Pet pet) {
		return false;
	}

	@Override
	public List<Pet> getAll() {
		return (List<Pet>) pets.values();
	}
}