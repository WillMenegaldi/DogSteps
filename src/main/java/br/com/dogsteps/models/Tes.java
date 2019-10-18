package br.com.dogsteps.models;

import java.io.Serializable;

public class Tes implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int codigo;
	private String nome;
	private int idade;
	public Tes(int codigo, String nome, int idade) {
		super();
		this.setCodigo(codigo);
		this.nome = nome;
		this.idade = idade;
	}
	public Tes() {
		
	}
	
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getIdade() {
		return idade;
	}


	public void setIdade(int idade) {
		this.idade = idade;
	}


	@Override
	public String toString() {
		return "nome:" + this.nome +
			   "idade:" + this.idade;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
