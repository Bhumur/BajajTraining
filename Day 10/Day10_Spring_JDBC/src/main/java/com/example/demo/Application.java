package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.ifaces.MyDao;
import com.example.demo.service.DoctorService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		
		ctx.getBean(DoctorService.class).findAll().forEach(System.out::println);
		
		ctx.close();
	}

//	@Autowired
//	MyDao<Doctor> doa;
	
	
	@Bean
	CommandLineRunner runner() {
		return new CommandLineRunner() {
			
			@Autowired
			MyDao<Doctor> doa;
			
			@Override
			public void run(String... args) throws Exception {
				// TODO Auto-generated method stub
				
			}
		};
	}
	
//	@Bean
//	CommandLineRunner runner() {
//		return arg -> {
////			doa.save(new Doctor(333, "Kushal", "ENT"));
////			System.out.println(doa.findById(2));
//		};
//	}
}
