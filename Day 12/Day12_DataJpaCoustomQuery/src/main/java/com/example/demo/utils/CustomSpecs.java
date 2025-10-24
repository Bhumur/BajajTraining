package com.example.demo.utils;

import org.springframework.data.jpa.domain.Specification;

import com.example.demo.entity.Customer;

public class CustomSpecs {
	public static Specification<Customer> findByCustomerName(String name){
		return (root,critera,builder) -> {
			return builder.like(root.get("customerName"),  "%" + name + "%");
//			return builder.equal(root.get("customerName"), name);
		};
	}
}
