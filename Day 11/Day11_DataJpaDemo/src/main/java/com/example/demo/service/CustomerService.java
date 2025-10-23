package com.example.demo.service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
//import org.slf4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AddressDto;
import com.example.demo.dto.CustomerDto;
import com.example.demo.entity.Customer;
import com.example.demo.model.Address;

@Service
public class CustomerService {
	
//	Logger log = Lo
	
	Logger log = Logger.getLogger(CustomerService.class.toString());
	
	
	@Autowired // we will move ctor injection , using just to revision field injection
	Customer customer;
	
	private JpaRepository<Customer, Integer> repo;
	
	
	public CustomerService(JpaRepository<Customer, Integer> repo) {
		super();
		this.repo = repo;
		log.info("Repo Refrence Name :=> " + repo.getClass().getName());
	}
	
	
	public CustomerDto save(CustomerDto dto) {
		Customer toAdd = this.repo.save(mapDtoToEntity(dto));
		return mapEntityToDto(toAdd);
	}
	
	public List<CustomerDto> findAll(){
		return this.repo.findAll().stream().map(this::mapEntityToDto).collect(Collectors.toList());
	}
	
	
	private Customer mapDtoToEntity(CustomerDto dto) {
		return new Customer(dto.customerId(),
				dto.customerName(),
				dto.mobileNumber(),
				dto.email(),
				dto.customerType(),
				mapAddressDtoToAddress(dto.billingAddress()),
				mapAddressDtoToAddress(dto.shippingAddress()));
	}
	
	private CustomerDto mapEntityToDto(Customer customer) {
		return new CustomerDto(customer.getCustomerId(),
				customer.getCustomerName(),
				customer.getMobileNumber(),
				customer.getEmail(),
				customer.getCustomerType(),
				mapAddressToAddressDto(customer.getBillingAddress()),
				mapAddressToAddressDto(customer.getShippingAddress()));
	}
	
	private Address mapAddressDtoToAddress(AddressDto addDto) {
		if(addDto==null)
			return new Address();
		return new Address(addDto.lineOne(),
				addDto.lineTwo(),
				addDto.city(),
				addDto.pincode());
	}
	
	private AddressDto mapAddressToAddressDto(Address add) {
		if(add==null)
			return new AddressDto();
		return new AddressDto(add.getLineOne(),
				add.getLineTwo(),
				add.getCity(),
				add.getPincode());
	}
}
