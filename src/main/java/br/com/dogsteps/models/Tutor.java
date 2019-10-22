package br.com.dogsteps.models;

import java.util.ArrayList;
import java.util.UUID;

public class Tutor extends User
{
	private ArrayList<Pet> pets;
	private ArrayList<Tour> tours;
	private String id;

	public Tutor(){}

	public Tutor(String id, String name, String photoUrl, int age, String cpf, String email, String password, Address address, TimeSchedule timeSchedule, ArrayList<Pet> pets, ArrayList<Tour> tours) {
		super(name, photoUrl, age, cpf, email, password, address, timeSchedule);
		this.id = UUID.randomUUID().toString();
		this.pets = pets;
		this.tours = tours;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
