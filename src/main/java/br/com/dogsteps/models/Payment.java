package br.com.dogsteps.models;

import enums.EPayType;
import enums.EPayment;

public class Payment {

	private EPayment status;

	private EPayType type;

	private double value;

	public Payment(EPayType type) {
		setType(type);
	}

	public EPayment getStatus() {
		return status;
	}

	public void setStatus(EPayment status) {
		this.status = status;
	}

	public EPayType getType() {
		return type;
	}

	public void setType(EPayType type) {
		this.type = type;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
}
