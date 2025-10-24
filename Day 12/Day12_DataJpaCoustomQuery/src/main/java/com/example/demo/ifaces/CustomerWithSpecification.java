package com.example.demo.ifaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entity.Customer;

public interface CustomerWithSpecification extends JpaRepository<Customer, Integer>, JpaSpecificationExecutor<Customer> {
	
	
}
