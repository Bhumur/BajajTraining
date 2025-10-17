package com.example.demo;

import java.io.Serial;
import java.security.Provider.Service;

import org.demo.Dummy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Primary;

import com.example.demo.model.Student;
import com.example.demo.services.FirstService;
import com.example.demo.services.SecondService;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo","org.demo"})// b/c we are using class from  outside the Application class level
public class Day9SpringDemoApplication {

    private final Student student;

    private final FirstService firstService;

    Day9SpringDemoApplication(FirstService firstService, Student student) {
        this.firstService = firstService;
        this.student = student;
    }

	public static void main(String[] args) {
//		SpringApplication.run(Day9SpringDemoApplication.class, args);

		ConfigurableApplicationContext ctx = SpringApplication.run(Day9SpringDemoApplication.class, args);

//		workingOfIoc(ctx);
		
		SecondService service = ctx.getBean(SecondService.class);
//		service.getName().forEach(System.out::println);
//		System.out.println(service.getString());
		
		System.out.println(service.getBestStudent());
		
		System.out.println(ctx.getBean(Dummy.class).message());
		
		ctx.close();
	}
	
	@Bean
	String alpha() {
		return "Abhishek";
	}
//	@Bean
//	int number() {
//		return 1;
//	}
//	
//	@Bean
//	double hello() {
//		return 2.0;
//	}
	
	@Bean
	String beta() {
		return "Bhumur";
	}
	
	@Bean
	@Primary
	Student dravid() {
		return new Student(1010, "Dravid", 89);
	}
	
	@Bean
	String gamma() {
		return "Sarvesh";
	}

	private static void workingOfIoc(ConfigurableApplicationContext ctx) {
		FirstService service = ctx.getBean(FirstService.class);
		System.out.println(service);
		FirstService service1 = (FirstService) ctx.getBean("firstService");
		System.out.println(service1.getInfo());
		System.out.println(service.hashCode());
		System.out.println(service1.hashCode());
		System.out.println(ctx.isSingleton("firstService"));
	}

}
