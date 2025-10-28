package com.example.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;

@SpringBootApplication
@Tag(name = "Book Service-API", description = "Book Service Api with endpoints to CRUD Operations")
@OpenAPIDefinition(info = @Info(title = "Book Service",version = "1.0" ))
public class Day14BookServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day14BookServiceApplication.class, args);
	}

	@Bean
	ModelMapper mapper() {
		return new ModelMapper();
	}
}
