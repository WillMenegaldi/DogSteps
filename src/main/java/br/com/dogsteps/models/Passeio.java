package br.com.dogsteps.models;

import java.io.Serializable;
import java.time.LocalDate;
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
	private DogWalker dogWalker;

	public Passeio(Agenda agenda, ETourStatus status, EDuracao duracao, List<Pet> pets, DogWalker dogWalker) {
		setId(UUID.randomUUID().toString());
		this.agenda = agenda;
		this.status = status;
		this.duracao = duracao;
		this.dogWalker = dogWalker;
		this.pets = pets;
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

	public DogWalker getDogWalker() {
		return dogWalker;
	}
	public void setDogWalker(DogWalker dogWalker) {
		this.dogWalker = dogWalker;
	}

	public Passeio(){
	}
}
