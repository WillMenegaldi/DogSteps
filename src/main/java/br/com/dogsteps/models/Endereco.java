package br.com.dogsteps.models;

public class Endereco {

	private String rua;

	private String numero;

	private String bairro;

	private String CEP;

	private String cidade;
	
	private String estado;

	public Endereco(String street, String numero, String bairro, String CEP, String cidade,String estado) {
		setRua(rua);
		setNumero(numero);
		setBairro(bairro);
		setCidade(cidade);
		setCEP(CEP);
		setEstado(estado);
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cep) {
		this.CEP = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Endereco(){}
}
