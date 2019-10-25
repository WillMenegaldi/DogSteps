package br.com.dogsteps.models;

import java.util.ArrayList;

public class DogWalker extends User {

	
	private ArrayList<Avaliacao> avaliacoes;
	private double mediaAvaliacao;
	private String descriçao;


	public DogWalker(String nome, String photoUrl, int idade, String cpf, String email, String senha, Endereco endereco,
			Agenda agenda, ArrayList<Avaliacao> avaliacoes, double mediaAvaliacao, String descriçao) {
		super(nome, photoUrl, idade, cpf, email, senha, endereco, agenda);
		this.avaliacoes = avaliacoes;
		this.mediaAvaliacao = mediaAvaliacao;
		this.descriçao = descriçao;
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


	public String getDescriçao() {
		return descriçao;
	}


	public void setDescriçao(String descriçao) {
		this.descriçao = descriçao;
	}


	public DogWalker(){}
}
