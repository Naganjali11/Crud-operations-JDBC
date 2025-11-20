package com.codegnan.service;

import java.util.List;

import com.codegnan.dao.EmployeeDao;
import com.codegnan.dao.EmployeedaoImpl;
import com.codegnan.entity.Employee;
import com.codegnan.exception.EmployeeNotFoundException;

public class EmployeeServiceImpl implements EmployeeService{
EmployeeDao dao=new EmployeedaoImpl();
	@Override
	public void addEmployee(Employee employee) {
		dao.save(employee);
	}

	@Override
	public Employee getEmployeeById(int eno) throws EmployeeNotFoundException {
		return dao.findById(eno);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return dao.findAll();
	}

	@Override
	public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
		dao.update(employee);
	}

	@Override
	public void deleteEmployee(int eno) throws EmployeeNotFoundException {
		dao.deleteById(eno);
	}

}
