package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Review;
import com.example.demo.service.ReviewService;

@RestController
@RequestMapping("/api/v2/reviews")
public class ReviewController {

	@Autowired
	private ReviewService service;
	
	@PostMapping
	public ResponseEntity<Review> save(@RequestBody Review entity){
		Review saved = service.save(entity);
		return ResponseEntity.status(201).body(saved);
	}
	
	@GetMapping
	public List<Review> findAll(){
		return this.service.findAll();
	}
	
//	@GetMapping("/{id}")
//	public Review findById(@PathVariable int id) {
//		return this.service.findById(id);
//	}
	
	@GetMapping("/{name}")
	public Review findByName(@PathVariable String name) {
		return this.service.findByBookName(name);
	}
	
}
