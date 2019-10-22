package br.com.dogsteps.models;

import java.io.Serializable;
import java.time.LocalDate;

import br.com.dogsteps.enums.ETourStatus;

public class Tour extends Configuracoes implements Serializable{
	private static final long serialVersionUID = 1L;
	private LocalDate data;
	private ETourStatus status;
	private double duracao;
	private Pet pet;
	private DogWalker dogWalker;

	public Tour(LocalDate data, ETourStatus status, double duracao, Pet pet, DogWalker dogWalker) {
		this.data = data;
		this.status = status;
		this.duracao = duracao;
		this.pet = pet;
		this.dogWalker = dogWalker;
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

	public Pet getPet() {
		return pet;
	}
	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public DogWalker getDogWalker() {
		return dogWalker;
	}
	public void setDogWalker(DogWalker dogWalker) {
		this.dogWalker = dogWalker;
	}

	public Tour(){
	}
}
