package br.com.dogsteps.models;

public class Address {

	private String street;

	private String number;

	private String district;

	private String zipCode;

	private String city;

	public Address(String street, String number, String district, String zipCode, String city) {
		setStreet(street);
		setNumber(number);
		setDistrict(district);
		setCity(city);
		setZipCode(zipCode);
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Address(){}
}
