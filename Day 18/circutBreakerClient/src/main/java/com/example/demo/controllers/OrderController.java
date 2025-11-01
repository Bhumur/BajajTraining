package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@GetMapping
	public ResponseEntity<String> getDetails(){
		String order = """
				{
					order:101,
					customerName:'ramesh',
					value:4050
				}
				""";
		
		return ResponseEntity.ok(order);
	}

}
