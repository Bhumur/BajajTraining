package com.example.demo;

import com.example.demo.service.EmployeeService;
import com.example.demo.service.JdbcEmployeeService;

import java.util.Scanner;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Day9SpringBuilderConditionalApplication {

	public static void main(String[] args) {
//		SpringApplication.run(Day9SpringBuilderConditionalApplication.class, args);
		
		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(Day9SpringBuilderConditionalApplication.class)
				.bannerMode(Banner.Mode.OFF)
				.properties("server.port:5050") // Programatically config 
				.run(args);
		
		System.out.println(ctx.getBean("master"));
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		System.out.println(ctx.getBean(JdbcEmployeeService.class).getEmployees());
		
		ctx.close();
		
	}
	
	@Bean(name = "master")
	String master() {
		return "Hello";
	}

}
