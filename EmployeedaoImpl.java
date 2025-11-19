package com.codegnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.codegnan.entity.Employee;
import com.codegnan.exception.EmployeeNotFoundException;
import com.codegnan.util.DBConnectionUtil;

public class EmployeedaoImpl implements EmployeeDao{

	@Override
	public void save(Employee employee) {
		String sql="insert into employee(eno,ename,esal,eaddr) values(?,?,?,?)";
		try(Connection connection=DBConnectionUtil.getConnection();
				PreparedStatement pst=connection.prepareStatement(sql)){
			pst.setInt(1, employee.getEno());
			pst.setString(2, employee.getEname());
			pst.setDouble(3, employee.getEsal());
			pst.setString(4, employee.getEaddr());
			pst.executeUpdate();
			System.out.println("Employee Saved:"+employee);
		}catch(SQLException e) {
			System.out.println("Save failed:"+e.getMessage());
		}
	}

	@Override
	public Employee findById(int eno) throws EmployeeNotFoundException {
		String sql="select*from employee where eno=?";
		try(Connection connection=DBConnectionUtil.getConnection();
				PreparedStatement pst=connection.prepareStatement(sql)){
			pst.setInt(1, eno);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				return new Employee(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4));
			}else {
				throw new EmployeeNotFoundException("Id not found"+eno);
			}
		}catch(SQLException e) {
			throw new EmployeeNotFoundException("Database Error:"+e.getMessage());
		}
	}

	@Override
	public List<Employee> findAll() {
		List<Employee>list=new ArrayList<>();
		String sql="select*from employee";
		try(Connection connection=DBConnectionUtil.getConnection();
				PreparedStatement pst=connection.prepareStatement(sql);
				ResultSet rs=pst.executeQuery()){
			while(rs.next()) {
				list.add(new Employee(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4)));
			}
		}catch(Exception e) {
			System.out.println("Fetch all records failed"+e.getMessage());
		}
		return list;
	}

	@Override
	public void update(Employee employee) throws EmployeeNotFoundException {
		String sql="update employee set ename=?,esal=?,eaddr=? where eno=?";
		try(Connection connection=DBConnectionUtil.getConnection();
				PreparedStatement pst=connection.prepareStatement(sql)){
				pst.setString(1, employee.getEname());
				pst.setDouble(2, employee.getEsal());
				pst.setString(3, employee.getEaddr());
				pst.setInt(4, employee.getEno());
				int rows=pst.executeUpdate();
				if(rows==1) {
					System.out.println("Updated:"+employee);
				}else {
					throw new EmployeeNotFoundException
					("Id not found for Update:"+employee.getEno());
				}
		}catch(SQLException e) {
			System.out.println("Updation failed:"+e.getMessage());
		}
	}

	@Override
	public void deleteById(int eno) throws EmployeeNotFoundException {
		String sql="delete from employee where eno=?";
		try(Connection connection=DBConnectionUtil.getConnection();
				PreparedStatement pst=connection.prepareStatement(sql)){
			pst.setInt(1,eno);
			int rowsAffected=pst.executeUpdate();
			if(rowsAffected==0) {
				throw new EmployeeNotFoundException("Id Not found for delete:"+eno);
			}System.out.println("Deleted Id:"+eno);
		}catch(SQLException e) {
			System.out.println("Deletion Failed"+e.getMessage());
		}
	}

}
