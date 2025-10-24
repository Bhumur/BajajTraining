package com.example.demo.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SingleTableRepo<T extends Employee> extends JpaRepository<T, Integer> {
	
}
