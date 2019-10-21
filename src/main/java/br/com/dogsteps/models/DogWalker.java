package br.com.dogsteps.models;

import java.io.Serializable;
import java.util.ArrayList;

public class DogWalker  extends User implements Serializable{

	private Feature prefs;

	private TimeSchedule timeSchedule;

	private ArrayList<Rating> ratings;

	private double medianScore;

	public DogWalker(Feature pref, String cpf, String email, String pass, String name, String photo, int age, String description, Adress adress, String photoURL) {
		super(cpf,email,pass,adress,name,age,description, photoURL);
		setPrefs(pref);
	}

	public Feature getPrefs() {
		return prefs;
	}

	public void setPrefs(Feature prefs) {
		this.prefs = prefs;
	}

	public TimeSchedule getTimeSchedule() {
		return timeSchedule;
	}

	public void setTimeSchedule(TimeSchedule timeSchedule) {
		this.timeSchedule = timeSchedule;
	}

	public ArrayList<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(ArrayList<Rating> ratings) {
		this.ratings = ratings;
	}

	public double getMedianScore() {
		return medianScore;
	}

	public void setMedianScore(double medianScore) {
		this.medianScore = medianScore;
	}

	public DogWalker(){}
}
