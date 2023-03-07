package com.springbootapi.service;

import java.util.List;

import com.springbootapi.model.Employee;

public interface EmployeeService {
     
	List<Employee> getEmployees();
	Employee saveEmployee(Employee employee);
	Employee getSingleEmployee(Long id);
	void deleteEmployee(Long id);
	Employee updateEmployee( Employee employee);
	List<Employee> getEmployeesByName(String name);
	List<Employee> getEmployeesByNameAndLocation(String name, String location);
	List<Employee> getEmployeesByKeyword(String name);
	
}
