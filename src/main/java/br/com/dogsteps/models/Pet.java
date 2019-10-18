package br.com.dogsteps.models;

import java.io.Serializable;

public class Pet implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int codigo;
	private String nome;
	private int idade;
	public Pet(int codigo, String nome, int idade) {
		super();
		this.setCodigo(codigo);
		this.nome = nome;
		this.idade = idade;
	}
	public Pet() {
		
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
