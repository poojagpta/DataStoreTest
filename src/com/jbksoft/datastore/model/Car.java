package com.jbksoft.datastore.model;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name="NEWTABLENAME")
public class Car {
	@Id
	Long id;
	String vin;
	int color;
	@Transient
	String doNotPersist;

	private Car() {
	}

	public Car(String vin, int color) {
		this.vin = vin;
		this.color = color;
	}
}
