package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

import com.example.demo.dtos.BookDto;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		
		RestClient client = ctx.getBean("client",RestClient.class);
		
		BookDto [] list = client.get().retrieve().body(BookDto[].class);
		for(BookDto dto : list) {
			System.out.println(dto+ " " + dto.bookId() + " " + dto.bookName());
		}
//		System.out.println(client.patch().uri("/100?qty=2").retrieve().body(BookDto.class));
		BookDto dto = new BookDto(13,"bds0","sdsx","sasdxs",1200,120.0,45);
		System.out.println(client.post().uri("/save").body(dto).retrieve().toEntity(BookDto.class).getHeaders().getLocation());
	}

	@Bean
	RestClient client(RestClient.Builder builder) {
		return builder.baseUrl("http://localhost:8080/api/v1/books").build();
	}
}
