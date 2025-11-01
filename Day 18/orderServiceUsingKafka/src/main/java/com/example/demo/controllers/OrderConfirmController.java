package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.BookDto;

@RestController
@RequestMapping("/confirm")
public class OrderConfirmController {

	@Autowired
	private StreamBridge bridge;
	
	
	@PostMapping
	ResponseEntity<String> confirmOrder(@RequestBody BookDto dto){
		
		ResponseEntity<String> resp = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not Sent");
		
		boolean result = bridge.send("confirm-order-topic", dto);
		
		
		if(result) {
			resp = ResponseEntity.status(HttpStatus.OK).body("Details Sent");
		}
		
		return resp;
	}
	
}
