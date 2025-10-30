package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import com.example.demo.dtos.BookDto;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/reviews")
public class FetchBookDetails {

	private WebClient client;
	
	public FetchBookDetails(WebClient client) {
		super();
		this.client = client;
	}
	
	@GetMapping
	public String get() {
		return "Hello";
	}
	
	@GetMapping("/{bookId}")
	public Mono<BookDto> fetchByBookId(@PathVariable int bookId){
		System.out.println("bookId");
		ResponseSpec spec = this.client.get().uri("lb://BOOKSERVICE/api/v1/books/{bookId}",bookId).retrieve();
		Mono<BookDto> result = spec.bodyToMono(BookDto.class);
//		System.out.println(spec.getPort());
		return result;
	}
}
