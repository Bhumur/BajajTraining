package com.example.demo.controllers;

import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/client")
public class CbEnableController {

    private final WebClient client;
    private final ReactiveCircuitBreaker cBreaker;

    public CbEnableController(WebClient client, ReactiveResilience4JCircuitBreakerFactory factory) {
        this.client = client;
        this.cBreaker = factory.create("sample");
    }

    @GetMapping
    public Mono<String> getOrders() {
    	System.out.println("inside");
        return cBreaker.run(
            client.get()
                  .uri("http://localhost:8010/orders")
                  .retrieve()
                  .bodyToMono(String.class),
            throwable -> Mono.just("Fallback response: Service unavailable")
        );
    }
}
