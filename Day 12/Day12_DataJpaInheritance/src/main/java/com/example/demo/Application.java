package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.DoubleTableRepo;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Manager;
import com.example.demo.entity.Professor;
import com.example.demo.entity.SingleTableRepo;
import com.example.demo.entity.Teacher;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		
		ctx.close();
	}
	
	@Bean
	CommandLineRunner runner() {
		return new CommandLineRunner() {
			
			@Autowired
			SingleTableRepo<Employee> repo;
			
			@Autowired
			DoubleTableRepo<Teacher> doubleRepo;
			
			@Override
			public void run(String... args) throws Exception {
//				repo.save(new Manager(105, "Bhumur", "PNQ", "amx"));
//				repo.save(new Manager(106, "Sarvesh", "JPR", "dbs"));
//				repo.save(new Manager(107, "Abhishek", "LON", "qur"));
//				repo.save(new Employee(104, "Rahul"));
//				repo.findAll().forEach(System.out::println);
				
				doubleRepo.save(new Professor(2, 11));
				doubleRepo.findAll().forEach(System.out::println);
			}
		};
	}

}
