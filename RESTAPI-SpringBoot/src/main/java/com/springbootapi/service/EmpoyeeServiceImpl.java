package com.springbootapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootapi.model.Employee;
import com.springbootapi.repository.EmployeeRepository;

@Service
public class EmpoyeeServiceImpl implements EmployeeService {
	
	
	
    private static List<Employee> list=new ArrayList<>();
	
    
    
    // autowiring the repository class/interface JpaRepo provides us basic CRUD operations 
    @Autowired
    private EmployeeRepository eRepository;
	 
	
	
	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return eRepository.findAll();
	}



	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return eRepository.save(employee);
	}



	@Override
	public Employee getSingleEmployee(Long id) {
		// TODO Auto-generated method stub
		Optional<Employee> employee= eRepository.findById(id);
		if(employee.isPresent())
			return employee.get();
	    throw new RuntimeException("Employee isnot found");	
	}



	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		eRepository.deleteById(id);
		
	}
    


	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return eRepository.save(employee);
	}


	 

	@Override
	public List<Employee> getEmployeesByName(String name) {
		// TODO Auto-generated method stub
		return eRepository.findByName(name);
	}



	@Override
	public List<Employee> getEmployeesByNameAndLocation(String name, String location) {
		// TODO Auto-generated method stub
		return eRepository.findByNameAndLocation(name, location);
		
	}



	@Override
	public List<Employee> getEmployeesByKeyword(String name) {
		// TODO Auto-generated method stub
		return eRepository.findByNameContaining(name);
		
	}
	
	

}
