package br.com.dogsteps.dao;

import br.com.dogsteps.interfaces.DAO;
import br.com.dogsteps.models.Pet;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class PetDAO implements DAO<Pet,Integer> {

	private HashMap<Integer, Pet> pets = new HashMap<>();

	@Override
	public Optional<Pet> get(Integer id) {
		return Optional.ofNullable(pets.get(id));
	}

	@Override
	public void add(Pet pet) {
		pets.put(pet.getId(),pet);
	}

	@Override
	public boolean remove(Integer id) {
		return pets.remove(id) != null;
	}

	@Override
	public boolean update(Pet pet, Integer id) {
		if(pets.containsKey(id)){
			pets.put(id, pet);
			return true;
		}
		return false;
	}

	@Override
	public List<Pet> getAll() {
		return (List<Pet>) pets.values();
	}
}
