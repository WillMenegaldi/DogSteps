package br.com.dogsteps.models;

import java.io.Serializable;

public class User extends LivingBeing implements Serializable {

	private String cpf;

	private String eMail;

	private String password;

	private Adress adress;

	private Dogwalker dogwalker;

	private TimeSchedule timeSchedule;

	public User(String cpf, String email, String pass, Adress address, String name, int age, String description, String photoURL) {
		super(name, photoURL, age, description);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public Dogwalker getDogwalker() {
		return dogwalker;
	}

	public void setDogwalker(Dogwalker dogwalker) {
		this.dogwalker = dogwalker;
	}

	public TimeSchedule getTimeSchedule() {
		return timeSchedule;
	}

	public void setTimeSchedule(TimeSchedule timeSchedule) {
		this.timeSchedule = timeSchedule;
	}

	public User(){}
}
