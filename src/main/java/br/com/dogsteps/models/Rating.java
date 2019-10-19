package br.com.dogsteps.models;

public class  Rating {

	private int avaliation;

	private String commentary;

	private int id;

	public Rating(int aval, String commentary){
		setAvaliation(aval);
		setCommentary(commentary);
	}

	public void setAvaliation(int avaliation) {
		this.avaliation = avaliation;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}

	private void setId(int id) {
		this.id = id;
	}

	public int getAvaliation() {
		return avaliation;
	}

	public String getCommentary() {
		return commentary;
	}

	public int getId() {
		return id;
	}
}
