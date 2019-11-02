package br.com.dogsteps.models;

import java.io.Serializable;
import java.util.ArrayList;

public class DogWalker extends User implements Serializable {
	private static final long serialVersionUID = 1L;

	private double mediaAvaliacao;
	private String descricao;
	private ArrayList<Avaliacao> avaliacoes;
	private Preferencias preferencias;

	public DogWalker(String nome, String photoUrl, int idade, String cpf, String email, String senha, Endereco endereco,
			Agenda agenda, ArrayList<Avaliacao> avaliacoes, double mediaAvaliacao, String descricao) {
		super(nome, photoUrl, idade, cpf, email, senha, endereco, agenda);
		this.avaliacoes = avaliacoes;
		this.mediaAvaliacao = mediaAvaliacao;
		this.descricao = descricao;
	}

	public ArrayList<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}
	public void setAvaliacoes(ArrayList<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public double getMediaAvaliacao() {
		return mediaAvaliacao;
	}
	public void setMediaAvaliacao(double mediaAvaliacao) {
		this.mediaAvaliacao = mediaAvaliacao;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Preferencias getPreferencias() {
		return preferencias;
	}
	public void setPreferencias(Preferencias preferencias) {
		this.preferencias = preferencias;
	}

	public DogWalker(){}

	@Override
	public String toString() {
		return this.getNome();
	}
}
