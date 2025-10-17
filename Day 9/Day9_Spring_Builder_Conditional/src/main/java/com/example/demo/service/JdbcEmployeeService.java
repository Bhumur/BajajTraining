package com.example.demo.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnBean(name = "master")
@DependsOn("master")
public class JdbcEmployeeService implements EmployeeService{

	public JdbcEmployeeService() {
		System.out.println("JdbcEmployeeService Intersizated");
	}
	
	@Override
	public String getEmployees() {
		return "Geeta, Sita, Rita, Kita";
	}
}
