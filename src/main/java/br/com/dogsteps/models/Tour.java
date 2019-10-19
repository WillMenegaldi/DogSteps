package br.com.dogsteps.models;

import java.time.LocalDate;
import br.com.dogsteps.enums.ETourStatus;

public class Tour {

	private LocalDate data;

	private ETourStatus status;

	private double duration;

	private Pet pet;

	public Tour() {

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

}
