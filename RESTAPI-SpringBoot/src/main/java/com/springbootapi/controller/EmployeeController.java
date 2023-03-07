package com.springbootapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootapi.model.Employee;
import com.springbootapi.service.EmployeeService;

import jakarta.validation.Valid;

//@Controller
@RestController  // @Controler +@ResponseBody
public class EmployeeController {
      // In order to convert this class to controller we will add a single annotation using @Controller
	// Controller class have all the handler methods
	// http requests are send to controller class 
	// where the method mapped to matching URI would be caught
	
	@Autowired
	private EmployeeService eService;
	@Value("${app.name}")
	private String appName;
	
	@GetMapping("/version")
	public String getAppDetails()
	{
		return appName;
	}
	
	
	
	
	//localhost:8080/employees
	
	//@RequestMapping(value="/employees", method=RequestMethod.GET)
	//@ResponseBody
	@GetMapping("/employees")// for every HTTP method there is an annotation 
	public ResponseEntity<List<Employee>> getEmployees() {
		return new ResponseEntity<List<Employee>>(eService.getEmployees(), HttpStatus.OK);
	}
	
	// We are using three annotaion to create a single REST end point. We can instaed use @RestController
	
	//localhost:8080/employees/12
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable("id") Long id)
	{
 
	   return eService.getSingleEmployee(id);
	}
	
	
	@DeleteMapping("/employees")
	public void  deleteEmployee(@RequestParam("id") Long id) {
		eService.deleteEmployee(id);
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee)
	{
		 return new ResponseEntity <Employee>(eService.saveEmployee(employee),HttpStatus.CREATED);
		
		
	}
	
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee)
	{
		//System.out.println("Updating the employee with id ="+id);
		employee.setId(id); // updating the existing record 
		// attach the id to the employee object
		return eService.updateEmployee(employee);
		
	}
	 
	@GetMapping("/employees/filterByName")
	public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name)
	{
		 return new ResponseEntity<List<Employee>>(eService.getEmployeesByName(name), HttpStatus.OK);
	}
	@GetMapping("/employees/filterByNameAndLocation")
	public ResponseEntity<List<Employee>> getEmployeesByNameAndLocation(@RequestParam String name, @RequestParam String location)
	{
		 return new ResponseEntity<List<Employee>>(eService.getEmployeesByNameAndLocation(name,location), HttpStatus.OK);
	}
	
	@GetMapping("/employees/filterByKeyword")
	public ResponseEntity<List<Employee>> getEmployeesByKeyWord(@RequestParam String name)
	{
		 return new ResponseEntity<List<Employee>>(eService.getEmployeesByKeyword(name), HttpStatus.OK);
	}
	
	
}
