package com.example.demo.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

import com.example.demo.Employee;

@Service
@ConditionalOnBean(Employee.class)

public class InMemoryEmployeeService implements EmployeeService{
	
	
	public InMemoryEmployeeService() {
		System.out.println("InMemoryService Intersizated");
	}
	
	@Override
	public String getEmployees() {
		return "Ram, Shayam, Ganesh, Karn";
	}

}
