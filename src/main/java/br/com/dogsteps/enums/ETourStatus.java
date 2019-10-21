package br.com.dogsteps.enums;

import java.io.Serializable;

public enum ETourStatus implements Serializable {
	PENDING(1,"Aguardando passeio ser aceito!"),
	INITIALIZED(2,"Passeio inicializado!"),
	ONGOING(3, "Passeio em andamento!"),
	COMPLETED(4, "Passeio finalizado!"),
	;

	private int id;
	private String description;

	ETourStatus(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}
	public String getDescription() {
		return description;
	}
}
