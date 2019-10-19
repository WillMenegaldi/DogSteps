package br.com.dogsteps.models;

import java.util.ArrayList;

public class Pet extends LivingBeing {

	private Feature features;

	private ArrayList<Rating> ratings;

	private double medianScore;

	private Tutor tutor;

	public Pet(Tutor tutor, Feature feature, String name, String photoUrl, String description, int age) {
		super(name,photoUrl,age,description);
		setTutor(tutor);
		setFeatures(feature);
	}

	public Feature getFeatures() {
		return features;
	}

	public void setFeatures(Feature features) {
		this.features = features;
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

	public Feature getFeature() {
		return features;
	}

	public void setFeature(Feature feature) {
		this.features = feature;
	}
}
