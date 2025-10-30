package com.example.demo.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.dto.BookDto;
import com.example.demo.dto.CatalogDto;
import com.example.demo.dto.ReviewDto;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/catalogs")
public class CatalogController {
	
	@Autowired
	private WebClient client;
	
	@Autowired
	private CatalogDto dto;
	
	@GetMapping("/{id}")
	public Mono<CatalogDto> getDetails(@PathVariable int id){
		System.out.println("-+-+++++--++-+-+--+-+-+-+--+");
		return client.get()
				.uri("lb://BOOKSERVICE/api/v1/books/{id}",id)
				.retrieve()
				.bodyToMono (BookDto.class)
				.zipWhen(book -> client
						.get()
						.uri("lb://REVIEWSERVICE/api/v2/reviews/{bookName}",book.bookName())
						.retrieve()
						.bodyToMono(ReviewDto.class), (book, review) -> new CatalogDto(book, review));
	}
		
		
		
		
//		return client
//				.get()
//				.uri("lb://BOOKSERVICE", uriBuilder ->
//				uriBuilder.path("/api/v1/books/{id}")
//				.build(id)).retrieve().bodyToMono(BookDto.class)
//				.zipWhen(custResp -> client
//						.get()
//						.uri("lb://REVIEWSERVICE", 
//								uriBuilder ->uriBuilder.path("/api/v2/reviews/{bookName}")
//								.build(custResp.bookName())).retrieve().bodyToMono(ReviewDto.class),
//				(custResp, payResp) -> {
//				dto.setBook(custResp);
//				dto.setReview(payResp);
//				return dto;
//
//				});
	@GetMapping("/name/{bookName}")
	public Mono<CatalogDto> getDetailsByName(@PathVariable String bookName){
		return client.get()
				.uri("lb://BOOKSERVICE/api/v1/books/byname/{bookName}",bookName)
				.retrieve()
				.bodyToMono (BookDto.class)
				.zipWhen(book -> client
						.get()
						.uri("lb://REVIEWSERVICE/api/v2/reviews/{bookName}",book.bookName())
						.retrieve()
						.bodyToMono(ReviewDto.class), (book, review) -> new CatalogDto(book, review));
	}

	
}
