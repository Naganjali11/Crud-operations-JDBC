package com.codegnan.dao;

import java.util.List;

import com.codegnan.entity.Employee;
import com.codegnan.exception.EmployeeNotFoundException;

public interface EmployeeDao {
public void save(Employee employee);
public Employee findById(int eno)throws EmployeeNotFoundException;
public List<Employee>findAll();
public void update(Employee employee)throws EmployeeNotFoundException;
public void deleteById(int eno)throws EmployeeNotFoundException;

}
