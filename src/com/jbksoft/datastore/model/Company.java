package com.jbksoft.datastore.model;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Id;

public class Company implements Serializable {
	
	@Id
	private String companyName;
	
	@Embedded Address add;

	public Company(String companyName, Address add) {
		
		this.companyName = companyName;
		this.add = add;
	}

	public Company() {
		
	}

	
}
