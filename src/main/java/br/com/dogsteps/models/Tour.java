package br.com.dogsteps.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import br.com.dogsteps.enums.ETourStatus;

public class Tour extends Configuracoes implements Serializable{
	private static final long serialVersionUID = 1L;
	private LocalDate date;
	private ETourStatus status;
	private double duration;
	private Pet pet;
	private DogWalker dogWalker;

	public Tour(LocalDate date, ETourStatus status, double duration, Pet pet, DogWalker dogWalker) {
		super(UUID.randomUUID());
		this.date = date;
		this.status = status;
		this.duration = duration;
		this.pet = pet;
		this.dogWalker = dogWalker;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public ETourStatus getStatus() {
		return status;
	}

	public void setStatus(ETourStatus status) {
		this.status = status;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
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

	@Override
	public String toString() {
		return "Data: " + date + "\n" +
			   "Status: " + status.getDescription() + "\n" +
			   "Duration: " + duration;
	}
}
