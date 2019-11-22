package br.com.dogsteps.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.dogsteps.enums.EDuracao;
import br.com.dogsteps.enums.ETourStatus;

public class Passeio extends Configuracoes implements Serializable{
	private static final long serialVersionUID = 1L;
	private Agenda agenda;
	private ETourStatus status;
	private EDuracao duracao;
	private List<Pet> pets =  new ArrayList<>();
	private String idDogWalker;
	private String idTutor;
	private int avaliacao;

	public Passeio(Agenda agenda, ETourStatus status, EDuracao duracao, List<Pet> pets,
				   String dogWalker, String tutor) {
		setId(UUID.randomUUID().toString());
		setAgenda(agenda);
		setStatus(status);
		setDuracao(duracao);
		setidDogWalker(dogWalker);
		setidTutor(tutor);
		setPets(pets);
		setAvaliacao(avaliacao);
	}

	public Agenda getAgenda() {
		return agenda;
	}
	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public ETourStatus getStatus() {
		return status;
	}
	public void setStatus(ETourStatus status) {
		this.status = status;
	}

	public EDuracao getDuracao() {
		return duracao;
	}
	public void setDuracao(EDuracao duracao) {
		this.duracao = duracao;
	}

	public List<Pet> getPets() {
		return pets;
	}
	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	public String getidDogWalker() {
		return idDogWalker;
	}
	public void setidDogWalker(String idDogWalker) {
		this.idDogWalker = idDogWalker;
	}

	public String getidTutor() {
		return idTutor;
	}
	public void setidTutor(String tutor) {
		this.idTutor = tutor;
	}

	public int getAvaliacao(){
		return avaliacao;
	}
	public void setAvaliacao(int avaliacao){
		this.avaliacao = avaliacao;
	}


	public Passeio(){
	}

}
