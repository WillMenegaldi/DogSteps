package br.com.dogsteps.models;

import br.com.dogsteps.enums.EPort;
import br.com.dogsteps.enums.ESex;
import java.io.Serializable;
import java.util.ArrayList;

public class Pet implements Serializable {
	private String name;
	private ESex sex;
	private EPort port;
	private ArrayList<Rating> ratings;
	private double averageScore;
	private Tutor tutor;

	public Pet(String name, ESex sex, EPort port, ArrayList<Rating> ratings, double averageScore, Tutor tutor) {
		this.name = name;
		this.sex = sex;
		this.port = port;
		this.ratings = ratings;
		this.averageScore = averageScore;
		this.tutor = tutor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ESex getSex() {
		return sex;
	}

	public void setSex(ESex sex) {
		this.sex = sex;
	}

	public EPort getPort() {
		return port;
	}

	public void setPort(EPort port) {
		this.port = port;
	}

	public ArrayList<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(ArrayList<Rating> ratings) {
		this.ratings = ratings;
	}

	public double getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(double averageScore) {
		this.averageScore = averageScore;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public Pet(){}
}
