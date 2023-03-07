package com.springbootapi.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isNotNull;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springbootapi.model.Employee;

@SpringBootTest
class EmployeeRepositoryTest {
	
	
	@Autowired
	private EmployeeRepository eRepository;
	
	
	
	@Test
	void testFindByName() {
		

		long millis=System.currentTimeMillis();
		java.util.Date date1=new java.util.Date(millis);
		java.util.Date date2=new java.util.Date(millis);
		
		
		Employee employee=new Employee(12l,"Ankush",45l, "Delhi", "ankush@abc.com","IT",date1, date2);
		eRepository.save(employee);
		List<Employee> ans=eRepository.findByName("Ankush");
		 assertNotNull(ans);

		
		
		
	}
	

		
		
		
	
}
