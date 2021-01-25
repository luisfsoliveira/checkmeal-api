package com.checkmeal.controllers;

import java.util.Collection;

import com.checkmeal.domain.Employee;
import com.checkmeal.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *  MealOrderController is the API Endpoint for ...example example
 *  example
 *
 * Endpoint: /employees
 *
 */
@RestController
@RequestMapping("/employees")
class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	/**
	 * This method...example example example
	 *
	 * Endpoint: /employees/all GET
	 * Request: ...
	 * Response: ..
	 * Response codes: ...
	 *
	 */
	@GetMapping("all")
	@ResponseBody
	public Collection<Employee> getEmployees(){
		return employeeService.findAll();
	}

	/**
	 * This method...example example example
	 *
	 * Endpoint: /employees/all-active GET
	 * Request: ...
	 * Response: ..
	 * Response codes: ...
	 *
	 */
	@GetMapping("all-active")
	@ResponseBody
	public Collection<Employee> getActiveEmployees(){
		return employeeService.findAllActive();
	}


}