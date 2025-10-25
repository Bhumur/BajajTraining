package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCaseStudyApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringCaseStudyApplication.class, args);
		
		
		ctx.close();
	}
	
	@Bean
	CommandLineRunner runner() {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				
				
			}
		};
	}

}
