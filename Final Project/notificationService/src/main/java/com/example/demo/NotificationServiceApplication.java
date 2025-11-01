package com.example.demo;

import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dtos.BookDto;

@SpringBootApplication
public class NotificationServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}

	
	
	@Bean
	Consumer<BookDto> consumer(){
		return dto -> {
			System.out.println("++++_+_+_+_+__+_+_+_+_+_+_+_+_+__+_+__+_+_+_+");
			System.out.println("Order Accepted with " + dto.bookName());
			System.out.println("Mail Send");
			System.out.println("++++_+_+_+_+__+_+_+_+_+_+_+_+_+__+_+__+_+_+_+");
		};
		
	}
}
