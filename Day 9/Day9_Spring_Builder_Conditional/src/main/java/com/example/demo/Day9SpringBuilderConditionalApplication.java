package com.example.demo;

import com.example.demo.service.EmployeeService;
import com.example.demo.service.JdbcEmployeeService;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class Day9SpringBuilderConditionalApplication {


	public static void main(String[] args) throws InterruptedException {
//		SpringApplication.run(Day9SpringBuilderConditionalApplication.class, args);
		
//		ConfigurableApplicationContext ctx =
//                new SpringApplicationBuilder(Day9SpringBuilderConditionalApplication.class)
//                        .bannerMode(Banner.Mode.OFF)
//                        .properties("server.port:5050") // programmatic config
//                        .initializers(applicationContext -> {
//                            // Registering "master" bean manually
//                            applicationContext.getBeanFactory()
//                                    .registerSingleton("master", "Master Bean Ready");
//                            System.out.println("'master' bean registered programmatically!");
//                        })
//                        .run(args);
		
		
		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(Day9SpringBuilderConditionalApplication.class)
				.bannerMode(Banner.Mode.OFF)
				.properties("server.port:5050") // Programatically config 
				.run(args);
//		System.out.println(ctx.getBean(Master.class));
		System.out.println(ctx.getBean(EmployeeService.class).getEmployees());
		ctx.close();
		
	}
	
	
//	@Bean
//	public String master() {
//		return "master";
//	}
	

}
