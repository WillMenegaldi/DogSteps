package br.com.dogsteps.models;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class User extends Configuracoes implements Serializable {
	private String nome;
	private int idade;
	private String cpf;
	private String photoUrl;
	private String email;
	private String senha;
	private Endereco endereço;
	private Agenda agenda;

	public User(String nome, String photoUrl, int idade, String cpf, String email, String senha, Endereco endereco, Agenda agenda) {
		this.nome = nome;
		this.photoUrl = photoUrl;
		this.idade = idade;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.endereço = endereco;
		this.agenda = agenda;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int age) {
		this.idade = age;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Endereco getEndereco() {
		return endereço;
	}

	public void setEndereco(Endereco endereco) {
		this.endereço = endereco;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public User(){
	}
}
