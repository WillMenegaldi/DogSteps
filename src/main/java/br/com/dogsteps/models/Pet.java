package br.com.dogsteps.models;

import br.com.dogsteps.enums.EPort;
import br.com.dogsteps.enums.ESex;
import br.com.dogsteps.exceptions.NegativeValueException;

import java.io.Serializable;
import java.util.ArrayList;

public class Pet extends LivingBeing implements Serializable {

	private Feature features;

	private ESex sex;

	private EPort port;

	private ArrayList<Rating> ratings = new ArrayList<Rating>();

	private double medianScore = 0;

	private Tutor tutor;

	public Pet(Tutor tutor, Feature feature, String name, String photoUrl, String description, int age, ESex sex) {
		super(name,photoUrl,age,description);
		setTutor(tutor);
		setFeature(feature);
		setSex(sex);
	}

	private void setSex(ESex sex) {
		this.sex = sex;
	}

	public ESex getSex(){
		return sex;
	}

	public ArrayList<Rating> getRatings() {
		return ratings;
	}

	public void addRating(Rating rating) throws NegativeValueException{
		if(rating.getAvaliation() >= 0){
			ratings.add(rating);
			setMedianScore(rating.getAvaliation());
		}
		else throw new NegativeValueException();
	}

	public void clearRating() {
		ratings.clear();
	}

	public double getMedianScore() {
		return medianScore/ratings.size();
	}

	public void setMedianScore(double score) {
			medianScore += score;
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
