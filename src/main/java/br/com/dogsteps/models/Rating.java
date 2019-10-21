package br.com.dogsteps.models;

import java.io.Serializable;

public class  Rating  implements Serializable {

	private int score;
	private String comment;
	private int id;

	public Rating(int score, String comment, int id) {
		this.score = score;
		this.comment = comment;
		this.id = id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Rating(){}
}
