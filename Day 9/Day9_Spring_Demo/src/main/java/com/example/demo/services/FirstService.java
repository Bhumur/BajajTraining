package com.example.demo.services;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
//@Lazy //Beans are Eagerly Initilized But if put @Lazy initialised
@Scope(scopeName = "prototype")
public class FirstService {
	
	public FirstService() {
		System.out.println("  First Service Intenseated ");
	}
	
	public String getInfo() {
		return "I am From First Service";
	}

}
