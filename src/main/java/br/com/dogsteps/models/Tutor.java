package br.com.dogsteps.models;

import java.util.ArrayList;

public class Tutor extends User {

	private ArrayList<Pet> pets;

	private ArrayList<Tour> tours;

	public Tutor(String cpf, String email,Adress adress, String pass, String name, String photoURL, int age, String description) {
		super(cpf,email,pass,adress, name,age,description,photoURL);
	}

	public Tutor(){}

}
