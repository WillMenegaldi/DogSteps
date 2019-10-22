package br.com.dogsteps.models;

import java.io.Serializable;
import java.util.UUID;

public class User extends Configuracoes implements Serializable {
	private String name;
	private int age;
	private String cpf;
	private String photoUrl;
	private String email;
	private String password;
	private Address address;
	private TimeSchedule timeSchedule;

	public User(String name, String photoUrl, int age, String cpf, String email, String password, Address address, TimeSchedule timeSchedule) {
		super(UUID.randomUUID());
		this.name = name;
		this.photoUrl = photoUrl;
		this.age = age;
		this.cpf = cpf;
		this.email = email;
		this.password = password;
		this.address = address;
		this.timeSchedule = timeSchedule;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public TimeSchedule getTimeSchedule() {
		return timeSchedule;
	}

	public void setTimeSchedule(TimeSchedule timeSchedule) {
		this.timeSchedule = timeSchedule;
	}

	public User(){}
}
