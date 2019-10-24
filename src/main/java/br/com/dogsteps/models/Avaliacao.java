package br.com.dogsteps.models;

import java.io.Serializable;

public class  Avaliacao  implements Serializable {

	private int pontos;
	private String comentario;
	private int id;

	public Avaliacao(int pontos, String comentario, int id) {
		this.pontos = pontos;
		this.comentario = comentario;
		this.id = id;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Avaliacao(){}
}
