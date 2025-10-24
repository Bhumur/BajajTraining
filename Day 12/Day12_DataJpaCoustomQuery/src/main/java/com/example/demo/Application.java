package com.example.demo;

import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import com.example.demo.entity.Customer;
import com.example.demo.entity.CustomerWithImage;
import com.example.demo.service.CustomerService;
import com.example.demo.service.MultiPartService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
	 	ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
	 	
//	 	Customer customer = ctx.getBean("customer", Customer.class);
	 	
	 	CustomerService service = ctx.getBean(CustomerService.class);
	 	
//	 	service.findByCustomerName("Ramesh").forEach(System.out::println);
	 	
//	 	service.findAll().forEach(System.out::println);
	 	
//	 	service.customeQueryForPrimeKey(2).forEach(System.out::println);
	 	
//	 	service.customeQueryForName("Bhumur").forEach(System.out::println);
	 	
//	 	service.readByCustomerName("Bhumur").forEach(System.out::println);
	 	
//	 	System.out.println(service.findByEmail("bhumur@gmail.com"));
	 	
//	 	System.out.println(service.updateMobileNumber(12345674, 12340000));
	 	
//	 	service.getStream(0).forEach((k,v)->System.out.println(k + " " + v));
	 	
	 	
//	 	MultiPartService serviceMultipart = ctx.getBean(MultiPartService.class);
//	 	
//	 	ClassPathResource imageRef = new ClassPathResource("logo.jpg");
//	 	
//	 	byte[] image = null;
//	 	
//	 	try(InputStream stream = imageRef.getInputStream()){
//	 		image = stream.readAllBytes();
//		 	serviceMultipart.save(new CustomerWithImage("Logo", image));
//	 	}catch (Exception e) {
//	 		e.printStackTrace();
//	 	}
	 	
//	 	service.findByCustomerNameWithSpecification("Bhumur").forEach(System.out::println);
//	 	service.findByCustomerNameWithSpecification("h").forEach(System.out::println);
	 	
//	 	service.getCustomerSortedByProp("customerName").forEach(System.out::println);
//	 	service.getCustomerSortedByProp("customerId").forEach(System.out::println);
//	 	service.getCustomerSortedByProp("mobileNumber").forEach(System.out::println);
	 	
//	 	service.usePagination(0, 1).forEach(System.out::println);
//	 	service.usePagination(1, 1).forEach(System.out::println);
//	 	service.usePagination(0, 2).forEach(System.out::println);
	 	for(int i=0;i<5;i++) {
	 		service.usePagination(i, 2).forEach(System.out::println);
	 	}
	 	ctx.close();
	}
	
	@Bean
	CommandLineRunner runner() {
		return new CommandLineRunner() {
			
			@Autowired
			CustomerService service;
			
			@Override
			public void run(String... args) throws Exception {
//				service.saveCustomer(new Customer("Bhumur", 12345672, "bhumur@gmail.com"));
//				service.saveCustomer(new Customer("Sarvesh", 12345673, "sarvesh@gmail.com"));
//				service.saveCustomer(new Customer("Abhishek", 12345674, "abhishek@gmail.com"));
			}
		};
	}
	
	
	@Bean
	Customer customer() {
		return new Customer("Ramesh", 12345671, "ramesh@gmail.com");
	}

}
