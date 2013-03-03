package com.jbksoft.datastore.model;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;




public class EmployeeDAO {
	
	public EmployeeDAO()
	{
		Objectify ofy = ObjectifyService.begin();
		ObjectifyService.register(Car.class);
		ObjectifyService.register(Employee.class);
		ObjectifyService.register(Address.class);
		ObjectifyService.register(Department.class);
		ObjectifyService.register(Company.class);
		
		Car car = new Car("bx23xd",2);
		
		//Store Address
		Address add=new Address("City1", "0000");
		
		//Department
		Department dept1 = new Department("Department1","20");
		Department dept2 = new Department("Department2","40");
		
		
		//One to one relationship --Employee/Address
		Key<Address> aalist=new Key<Address>(Address.class, "Citykey");
		
		//One to many relationship --Employee/Department
		Key<Department> deptKey1=new Key<Department>(Department.class, "Department1");
		Key<Department> deptKey2=new Key<Department>(Department.class, "Department2");
		List<Key<Department>> dept=new ArrayList<Key<Department>>(); 
		dept.add(deptKey1);
		dept.add(deptKey2);
		
		Key[] deptArray = new Key[2];
		deptArray[0] = deptKey1;
		deptArray[1] = deptKey2;
		
		Employee emp=new Employee("Test1", 10, aalist,dept,deptArray);
		Employee emp1=new Employee("Test1Pooja", 8, aalist,dept,deptArray);
			
		//Can we add duplicate keys--No new entry will be there it will only be update
		Key<Address> aalist3=new Key<Address>(Address.class, "City1");
		Employee emp3=new Employee("Test1", 11, aalist3,dept,deptArray);
		
		//Use embedded for Company/employee
		Company comp=new Company("NewCompany",add);
		
		//Batch insert/update
		ofy.put(car,add,dept1,dept2,emp,emp1,emp3,comp);
		
		System.out.println(car.id);
		
		// To retrieve the card record first create key for it using the id
		Key carKey = new Key<Car>(Car.class, car.id);
		
		Car getCar =  ofy.get(carKey);
					
		//Filter criteria
		Iterable<Employee> employeewithaddress = ofy.query(Employee.class).filter("age >", 10).filter("empName", "Test1");
		for(Employee e: employeewithaddress)
		{
			System.out.println(e.getEmpName());
		}
		
		//without Filter criteria
		Iterable<Employee> employeewithaddress1 = ofy.query(Employee.class);
		for(Employee e: employeewithaddress1)
		{
			System.out.println(e.getEmpName());
		}
		
		//Fetch all the keys
		Iterable<Key<Employee>> allKeys = ofy.query(Employee.class).fetchKeys();
		for(Key e: allKeys)
		{
			System.out.println("Id : "+e.getId()+" Kind: "+e.getKindClassName() +" Name :"+e.getName()+" Parent "+e.getParent());
		}
		
		//One to One relationship fetch --Find all employee having address city as 'City1'
		
		
		// one to many relationship with multi-value relationship result in exploding index
		
		
		
//		Address addId = ofy.get(Address.class, "City1");
//		Key<Address> aalist=new Key<Address>(Address.class, addId);
		
//		Employee emp1=new Employee("Test2",10,aalist);
//		ObjectifyService.begin().put(emp1);
	}

}
