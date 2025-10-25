package com.example.demo.ifaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	Customer findByCustomerName(String name);
	
//	List<Customer> findAllByCustomerName()
}