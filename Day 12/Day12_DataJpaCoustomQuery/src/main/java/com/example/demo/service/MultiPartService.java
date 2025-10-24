package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CustomerWithImage;
import com.example.demo.ifaces.CustomerWithImageRepo;

@Service
public class MultiPartService {

	@Autowired
	CustomerWithImageRepo repo;
	
	public CustomerWithImage save(CustomerWithImage cust) {
		return repo.save(cust);
	}
}
