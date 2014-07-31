package com.lyr.dao;

import java.util.List;

import com.lyr.bean.Employee;

public interface EmployeeDAO {
	public void addEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public void deleteEmployee(Employee employee);
	public Employee findEmployeeById(int employeeID);
	public List<Employee> findAllEmployee();
}
