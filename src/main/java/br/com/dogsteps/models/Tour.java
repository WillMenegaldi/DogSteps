package br.com.dogsteps.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import br.com.dogsteps.enums.ETourStatus;

public class Tour implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private LocalDate date;
	private ETourStatus status;
	private double duration;
	private Pet pet;
	private DogWalker dogWalker;

	public Tour(UUID id, LocalDate date, ETourStatus status, double duration, Pet pet, DogWalker dogWalker) {
		this.id = UUID.randomUUID().toString();
		this.date = date;
		this.status = status;
		this.duration = duration;
		this.pet = pet;
		this.dogWalker = dogWalker;
	}

	@Override
	public String toString() {
		return "Data: " + date + "\n" +
			   "Status: " + status.getDescription() + "\n" +
			   "Duration: " + duration;
	}
	public Tour() {
		this.id = UUID.randomUUID().toString();
	}
}
