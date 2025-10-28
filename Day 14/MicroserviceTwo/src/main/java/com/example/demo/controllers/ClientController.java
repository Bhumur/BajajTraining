package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/api/v1")
public class ClientController {
	private RestClient client;
	
	public ClientController(RestClient builder) {
		this.client = builder;
	}

	@GetMapping
	public String getMessage() {
		return "From 2nd " + this.client.get().uri("/first").retrieve().body(String.class);
	}

}