package br.com.dogsteps.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.dogsteps.enums.ETourStatus;

public class Passeio extends Configuracoes implements Serializable{
	private static final long serialVersionUID = 1L;
	private LocalDate data;
	private ETourStatus status;
	private double duracao;
	private List<Pet> pets =  new ArrayList<>();
	private DogWalker dogWalker;

	public Passeio(LocalDate data, ETourStatus status, double duracao, List<Pet> pets, DogWalker dogWalker) {
		setId(UUID.randomUUID().toString());
		this.data = data;
		this.status = status;
		this.duracao = duracao;
		this.dogWalker = dogWalker;
		this.pets = pets;
	}

	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}

	public ETourStatus getStatus() {
		return status;
	}
	public void setStatus(ETourStatus status) {
		this.status = status;
	}

	public double getDuracao() {
		return duracao;
	}
	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}

	public List<Pet> getPets() {
		return pets;
	}
	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	public DogWalker getDogWalker() {
		return dogWalker;
	}
	public void setDogWalker(DogWalker dogWalker) {
		this.dogWalker = dogWalker;
	}

	public Passeio(){
	}
}
