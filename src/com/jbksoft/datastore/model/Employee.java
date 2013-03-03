package com.jbksoft.datastore.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Id;

import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.Text;
import com.googlecode.objectify.Key;

public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	String empName;
	int age;

	Key<Address> addr;

	List<Key<Department>> dept;
	Key<Department>[] deptArray;
	Text testText;
	
	Blob bblob;
	
	public Employee() {

	}

	public Employee(String name, int age, Key<Address> addr,
			List<Key<Department>> dept, Key<Department>[] deptArray) {
		super();
		this.empName = name;
		this.age = age;
		this.addr = addr;
		this.dept = dept;
		this.deptArray = deptArray;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Key<Address> getAddr() {
		return addr;
	}

	public void setAddr(Key<Address> addr) {
		this.addr = addr;
	}

	public List<Key<Department>> getDept() {
		return dept;
	}

	public void setDept(List<Key<Department>> dept) {
		this.dept = dept;
	}

	public Key<Department>[] getDeptArray() {
		return deptArray;
	}

	public void setDeptArray(Key<Department>[] deptArray) {
		this.deptArray = deptArray;
	}
	
	

}
