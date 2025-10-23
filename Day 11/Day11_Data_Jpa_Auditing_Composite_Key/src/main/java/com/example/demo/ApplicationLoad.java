package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.LoanApplication;
import com.example.demo.ifaces.LoanApplicationRepositry;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo.entity","com.example.demo.ifaces"})
public class ApplicationLoad {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(ApplicationLoad.class, args);
		
//		LoanApplicationRepositry repo = ctx.getBean(LoanApplicationRepositry.class);
//		repo.findAll().forEach(System.out::println);
		
	}
	
	@Bean
	CommandLineRunner runner() {
		return new CommandLineRunner() {
			@Autowired
			LoanApplicationRepositry repo;
			
			@Override
			public void run(String... args) throws Exception {
				repo.save(new LoanApplication("first"));
				repo.save(new LoanApplication("second"));
				repo.save(new LoanApplication("third"));
				repo.save(new LoanApplication("fourth"));
				repo.save(new LoanApplication("five"));
			}
		};
	}

}
