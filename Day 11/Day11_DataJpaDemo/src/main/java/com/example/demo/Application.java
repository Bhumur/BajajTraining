package com.example.demo;
import com.example.demo.ifaces.CustomerRepository;
import com.example.demo.model.Address;
import com.example.demo.service.CustomerService;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.AddressDto;
import com.example.demo.dto.CustomerDto;
import com.example.demo.entity.Customer;
import com.example.demo.entity.CustomerType;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		Logger log = Logger.getLogger("main");
		
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		CustomerService service = ctx.getBean("oneMore",CustomerService.class);
		
//		CustomerDto toAdd = ctx.getBean("sample",CustomerDto.class);
		
//		CustomerDto toAdd2 = ctx.getBean("anotherSample",CustomerDto.class);
		
//		CustomerDto dto = service.save(toAdd);
		
//		CustomerDto dto1 = ctx.getBean("anotherService", CustomerDto.class);
		
//		log.info("One Entity With id " + dto.customerId() + " Added");
		service.findAll().forEach(System.out::println);
	}
	
	
	@Bean
	Customer customer() {
		return new Customer();
	}
	
	@Bean
	CustomerDto sample() {
		return new CustomerDto(1019, "Ki", 84416984, "kran@gmail.com", CustomerType.RETAIL, new AddressDto("first","second","jaipur",7851522), new AddressDto("eed","sad","jaipur",7851522));
	}
	@Bean
	CustomerDto anotherSample() {
		return new CustomerDto(2080, "Dedwpbgih", 8655984, "d@gbwdwgvuddmail.com", CustomerType.CORPORATE, new AddressDto("first","second","jaipur",7851522), new AddressDto("eed","sad","jaipur",7851522));
	}
	
	@Bean 
	CustomerService oneMore(JpaRepository<Customer, Integer> repo) {
		return new CustomerService(repo);
	}
	
	@Bean
	CustomerDto anotherService(CustomerDto anotherSample, CustomerService oneMore) {
		return oneMore.save(anotherSample);
	}

}
