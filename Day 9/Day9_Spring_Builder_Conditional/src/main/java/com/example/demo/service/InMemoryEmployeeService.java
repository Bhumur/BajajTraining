package com.example.demo.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnBean(name = "slave")
public class InMemoryEmployeeService implements EmployeeService{
	
	
	public InMemoryEmployeeService() {
		System.out.println("InMemoryService Intersizated");
	}
	
	@Override
	public String getEmployees() {
		return "Ram, Shayam, Ganesh, Karn";
	}

}
