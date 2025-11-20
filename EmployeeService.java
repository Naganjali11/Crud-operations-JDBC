package com.codegnan.service;

import java.util.List;

import com.codegnan.entity.Employee;
import com.codegnan.exception.EmployeeNotFoundException;

public interface EmployeeService {
public void addEmployee(Employee employee);
public Employee getEmployeeById(int eno)throws EmployeeNotFoundException;
public List<Employee>getAllEmployees();
public void updateEmployee(Employee employee)throws EmployeeNotFoundException;
public void deleteEmployee(int eno)throws EmployeeNotFoundException;

}
