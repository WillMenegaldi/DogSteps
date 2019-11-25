package br.com.dogsteps.models;

import java.util.ArrayList;

public class Tutor extends User
{
	private ArrayList<Pet> pets;
	private ArrayList<Passeio> passeios;

	public Tutor(){}

	public Tutor( String name, String photoUrl, int age, String cpf, String email, String password, Endereco address
				  , ArrayList<Pet> pets, ArrayList<Passeio> passeios) {
		super(name, photoUrl, age, cpf, email, password, address);
		this.pets = pets;
		this.passeios = passeios;
	}

	public ArrayList<Pet> getPets() {
		return pets;
	}

	public void setPets(ArrayList<Pet> pets) {
		this.pets = pets;
	}

	public ArrayList<Passeio> getPasseios() {
		return passeios;
	}

	public void setPasseios(ArrayList<Passeio> passeios) {
		this.passeios = passeios;
	}

	public void addPasseios(Passeio passeio){
		passeios.add(passeio);
	}

	public void addPets(Pet pet){
		pets.add(pet);
	}


}
