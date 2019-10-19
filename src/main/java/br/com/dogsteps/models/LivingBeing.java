package br.com.dogsteps.models;

public class LivingBeing {

	private int id;

	private String name;

	private String photoUrl;

	private int age;

	private String description;

	public LivingBeing(String name, String photoUrl, int age, String description) {
		setName(name);
		setPhotoUrl(photoUrl);
		setAge(age);
		setDescription(description);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
