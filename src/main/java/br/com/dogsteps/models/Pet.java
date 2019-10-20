package br.com.dogsteps.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Pet extends LivingBeing implements Serializable {

	private Feature feature;

	private ArrayList<Rating> ratings;

	private double medianScore;

	private Tutor tutor;

	public Pet(Tutor tutor, Feature feature, String name, String photoUrl, String description, int age) {
		super(name,photoUrl,age,description);
		this.feature = feature;
		this.tutor = tutor;
	}

	public Feature getFeatures() {
		return feature;
	}

	public void setFeatures(Feature features) {
		this.feature = features;
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

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	@Override
	public String toString() {
		return "Name: " + getName();
	}

	public Pet(){}

}
