package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Review;

public interface ReviewRepo extends JpaRepository<Review, Integer> {
	Review findByBookName(String name);
}
