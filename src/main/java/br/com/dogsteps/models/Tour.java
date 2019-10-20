package br.com.dogsteps.models;

import java.io.Serializable;
import java.time.LocalDate;
import br.com.dogsteps.enums.ETourStatus;

public class Tour implements Serializable {
	private static final long serialVersionUID = 1L;

	private LocalDate data;
	private ETourStatus status;
	private double duration;
	private Pet pet;

	public Tour(LocalDate data, ETourStatus status, double duration) {
		this.data = data;
		this.status = status;
		this.duration = duration;
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
