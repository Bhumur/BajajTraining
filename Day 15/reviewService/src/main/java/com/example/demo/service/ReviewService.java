package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Review;
import com.example.demo.repo.ReviewRepo;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepo repo;

	public Review save(Review entity) {
		return this.repo.save(entity);
	}

	public List<Review> findAll() {
		return this.repo.findAll();
	}

	public Review findById(int id) {
		return this.repo.findById(id).orElseThrow();
	}
	
	public Review findByBookName(String name) {
		return this.repo.findByBookName(name);
	}

}
