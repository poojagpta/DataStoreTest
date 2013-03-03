package com.jbksoft.datastore.model;

import java.io.Serializable;

import javax.persistence.Id;

public class Address implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3123413429462549866L;
	
	@Id
	public String city;
	public String zipcode;
	public Address(String city, String zipcode) {
		super();
		this.city = city;
		this.zipcode = zipcode;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	

}
