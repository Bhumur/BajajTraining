package com.example.demo.service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
//import org.slf4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CustomerDto;
import com.example.demo.entity.Customer;
import com.example.demo.ifaces.CustomerRepository;

@Service
public class CustomerService {
	
	
	Logger log = Logger.getLogger(CustomerService.class.toString());

	@Autowired
	private CustomerRepository repo;
	
	public CustomerDto save(CustomerDto dto) {
		Customer toAdd = this.repo.save(mapDtoToEntity(dto));
		return mapEntityToDto(toAdd);
	}
	
	public List<CustomerDto> findAll(){
		return this.repo.findAll().stream().map(this::mapEntityToDto).collect(Collectors.toList());
	}
	
	public CustomerDto findById(int id) {
		return mapEntityToDto(this.repo.findById(id).orElseThrow());
	}
	
	
	private Customer mapDtoToEntity(CustomerDto dto) {
		return new Customer(dto.customerId(),
				dto.customerName(),
				dto.mobileNumber(),
				dto.email(),
				dto.customerType());
	}
	
	private CustomerDto mapEntityToDto(Customer customer) {
		return new CustomerDto(customer.getCustomerId(),
				customer.getCustomerName(),
				customer.getMobileNumber(),
				customer.getEmail(),
				customer.getCustomerType());
	}

	public CustomerDto findByName(String name) {
		Customer c = this.repo.findByCustomerName(name);
//		System.out.println(c);
		if(c==null)
			return null;
		return mapEntityToDto(c);
	}
	
}
