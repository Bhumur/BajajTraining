package com.example.demo.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import com.example.demo.Master;

@Service
//@Order(2)
//@ConditionalOnBean(Master.class)
@Conditional(FirstCondition.class)
public class JdbcEmployeeService implements EmployeeService{

	public JdbcEmployeeService() {
		System.out.println("JdbcEmployeeService Intersizated");
	}
	
	@Override
	public String getEmployees() {
		return "Geeta, Sita, Rita, Kita";
	}
}
