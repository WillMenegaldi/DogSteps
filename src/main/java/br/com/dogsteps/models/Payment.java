package br.com.dogsteps.models;

import br.com.dogsteps.enums.EPayment;

public class Payment {

	private EPayment status;
	private double value;

	public EPayment getStatus() {
		return status;
	}

	public void setStatus(EPayment status) {
		this.status = status;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
}
