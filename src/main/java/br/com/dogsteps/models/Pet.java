package br.com.dogsteps.models;

import br.com.dogsteps.enums.EPort;
import br.com.dogsteps.enums.ESex;
import java.io.Serializable;
import java.util.ArrayList;

public class Pet extends LivingBeing implements Serializable {

	private Feature feature;

	private ESex sex;

	private EPort port;

	private ArrayList<Rating> ratings;

	private double medianScore;

	private Tutor tutor;

	public Pet(Tutor tutor, Feature feature, String name, String photoUrl, String description, int age, ESex sex, EPort port) {
		super(name,photoUrl,age,description);
		setPort(port);
		setTutor(tutor);
		setFeatures(feature);
		setSex(sex);
	}

	private void setPort(EPort port) {
		this.port = port;
	}

	private void setSex(ESex sex) {
		this.sex = sex;
	}

	public ESex getSex(){
		return sex;
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

	public void addRating(Rating rating) {
		ratings.add(rating);
		setMedianScore(rating.getAvaliation());
	}

	public double getMedianScore() {
		return medianScore;
	}

	public void setMedianScore(double score) {
		if(score >= 0)
			medianScore = score;
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
	public void setFeature(Feature feature) {
		this.feature = feature;
	}

	public EPort getPort() {
		return port;
	}

	public Pet(){}
}
