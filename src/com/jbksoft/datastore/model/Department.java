package com.jbksoft.datastore.model;

import java.io.Serializable;

import javax.persistence.Id;

public class Department implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String departname;
	private String operationalCost;
	
	public Department() {
		}

	public Department(String departname, String operationalCost) {
			this.departname = departname;
		this.operationalCost = operationalCost;
	}
	
	

}
