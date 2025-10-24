package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.service.OrderService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	@Bean
	CommandLineRunner runner() {
		return new CommandLineRunner() {
			
			@Autowired
			OrderService service;
			
			@Override
			public void run(String... args) throws Exception {
//				service.addToOrderBook();
				
				service.get().forEach(System.out::println);
			}
		};
	}
}
