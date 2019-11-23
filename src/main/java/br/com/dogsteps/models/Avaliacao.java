package br.com.dogsteps.models;

import java.io.Serializable;

public class  Avaliacao extends Configuracoes implements Serializable {
	private int avaliacao;
	private String idDogWalker;
	private String idTutor;

	public Avaliacao(int avaliacao, String idDogWalker, String idTutor) {
		this.avaliacao = avaliacao;
		this.idDogWalker = idDogWalker;
		this.idTutor = idTutor;
	}

	public int getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}

	public String getIdDogWalker() {
		return idDogWalker;
	}
	public void setIdDogWalker(String idDogWalker) {
		this.idDogWalker = idDogWalker;
	}

	public String getIdTutor() {
		return idTutor;
	}
	public void setIdTutor(String idTutor) {
		this.idTutor = idTutor;
	}

	public Avaliacao(){}
}
