package br.com.dogsteps.models;

import java.util.ArrayList;

public class Tutor extends User
{
	private ArrayList<Pet> pets;
	private ArrayList<Tour> tours;

	public Tutor(){}

	public Tutor( String name, String photoUrl, int age, String cpf, String email, String password, Address address, TimeSchedule timeSchedule, ArrayList<Pet> pets, ArrayList<Tour> tours) {
		super(name, photoUrl, age, cpf, email, password, address, timeSchedule);
		this.pets = pets;
		this.tours = tours;
	}

	public ArrayList<Pet> getPets() {
		return pets;
	}

	public void setPets(ArrayList<Pet> pets) {
		this.pets = pets;
	}

	public ArrayList<Tour> getTours() {
		return tours;
	}

	public void setTours(ArrayList<Tour> tours) {
		this.tours = tours;
	}
}
