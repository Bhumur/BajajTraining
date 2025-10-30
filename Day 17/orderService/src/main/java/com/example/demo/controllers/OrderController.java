package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.dto.BookDto;
import com.example.demo.dto.CatalogDto;
import com.example.demo.dto.ReviewDto;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private WebClient client;
	

	@GetMapping("/{bookName}")
	public Mono<CatalogDto> getbookAndReview(@PathVariable String bookName) {
		System.out.println("check");
		return client.get()
				.uri("lb://CATALOGSERVICE/api/v1/catalogs/name/{bookName}",bookName)
				.retrieve()
				.bodyToMono(CatalogDto.class);
	}
	
	@PatchMapping("/{id}")
	public Mono<BookDto> updateBookStock(@PathVariable int id, @RequestParam int qty) {
		System.out.println("check");
		return client.patch()
				.uri("lb://BOOKSERVICE/api/v1/books/{id}?qty={qty}",id,qty)
				.retrieve()
				.bodyToMono(BookDto.class);
	}
}
