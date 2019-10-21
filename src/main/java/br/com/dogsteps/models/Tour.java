package br.com.dogsteps.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import br.com.dogsteps.enums.ETourStatus;

public class Tour implements Serializable {
	private static final long serialVersionUID = 1L;
	private UUID id;

	private LocalDate data;
	private ETourStatus status;
	private double duration;
	private Pet pet;
	private DogWalker dogwalker;

	public Tour(LocalDate data, ETourStatus status, double duration, Pet pet, DogWalker dogwalker) {
		id = UUID.randomUUID();
		this.data = data;
		this.status = status;
		this.duration = duration;
		this.pet = pet;
		this.dogwalker = dogwalker;
	}

	public String getId() {
		return id.toString();
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public DogWalker getDogwalker() {
		return dogwalker;
	}
	public void setDogwalker(DogWalker dogwalker) {
		this.dogwalker = dogwalker;
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

	@Override
	public String toString() {
		return "Data: " + data + "\n" +
			   "Status: " + status.getDescription() + "\n" +
			   "Duration: " + duration;
	}
	public Tour() {}
}
