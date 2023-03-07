package com.springbootapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootapi.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
  // we have to autowire this repository inside our service class
	
	
	List<Employee> findByName(String name);
	
	
	List<Employee> findByNameAndLocation(String name, String location);
	List<Employee> findByNameContaining(String keyword);
}
