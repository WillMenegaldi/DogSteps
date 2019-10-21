package br.com.dogsteps.repositories;

import br.com.dogsteps.dao.PetIDAO;
import br.com.dogsteps.models.Pet;

import java.util.List;

public class PetRepository {

	private static PetIDAO pet;

	public List<Pet> getList() {
		return pet.getAll();
	}

	public Pet getPet(int id) {
		return pet.get(id);
	}

    public void savePet(Pet p) { pet.add(p);}

	public boolean removePet(Pet p) {
		return pet.remove(p.getId());
	}

	public boolean update(Pet p) {
		return pet.update(p);
	}
}
