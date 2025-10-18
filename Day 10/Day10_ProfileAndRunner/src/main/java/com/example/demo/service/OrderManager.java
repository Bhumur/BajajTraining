package com.example.demo.service;

import java.util.List;

//import org.springframework.boot.context.properties.ConstructorBinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@ConfigurationProperties(prefix = "com.example.demo")
//@ConstructorBinding
public class OrderManager {


	private OrderDetails details;
	
//	@Value("${com.example.demo.custom}")
	private String custom;
	
	@Autowired
	private Environment env;
	
	public void setCustom(String custom) {
		this.custom = custom;
	}
	
	public OrderManager(OrderDetails details) {
		this.details = details;
		System.out.println("Inside Ctro" + this.env);
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Before   "  +env);
		
		System.out.println("Custome : " + custom);
	}
	
	public List<String> getDetails(){
		return this.details.getOrderDetails();
	}
	
	
	@PreDestroy
	public void closeDown() {
		System.out.println("ShuttingDown..........");
	}
}
