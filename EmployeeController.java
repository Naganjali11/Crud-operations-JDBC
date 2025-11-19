package com.codegnan.controller;

import java.util.List;

import com.codegnan.entity.Employee;
import com.codegnan.exception.EmployeeNotFoundException;
import com.codegnan.service.EmployeeService;
import com.codegnan.service.EmployeeServiceImpl;

public class EmployeeController {

	public static void main(String[] args) {
	EmployeeService service=new EmployeeServiceImpl();
	/*service.addEmployee(new Employee(222,"Naganjali",80000.0,"Hyderabad"));
	service.addEmployee(new Employee(555,"RudhvikRam",75000.0,"Vijayawada"));
	service.addEmployee(new Employee(110,"MokshithRam",66000.0,"Hyderabad"));*/
	
	/*try {
		Employee emp=service.getEmployeeById(111);
		System.out.println("Found:"+emp);
	} catch (EmployeeNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	
	/*System.out.println("Fetch all Employees");
	List<Employee>employees=service.getAllEmployees();
	for(Employee e:employees) {
		System.out.println(e);
	}*/
	
	/*try {
		service.updateEmployee(new Employee(333,"AnilChowdary",80000,"Amaravati"));
	} catch (EmployeeNotFoundException e) {
		e.printStackTrace();
	}*/
	
	try {
		service.deleteEmployee(110);
	} catch (EmployeeNotFoundException e) {
		e.printStackTrace();
	}
	}

}
