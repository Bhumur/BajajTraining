package com.example.demo.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.ICustomer;
import com.example.demo.entity.Customer;
import com.example.demo.ifaces.CustomerRepositry;
import com.example.demo.ifaces.CustomerWithSpecification;
import com.example.demo.utils.CustomSpecs;

import jakarta.transaction.Transactional;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepositry repo;
	
	@Autowired
	CustomerWithSpecification sprecifictionRepo;
	
	public List<Customer> findByCustomerName(String name){
		return this.repo.findByCustomerName(name);
	}
	
	public List<Customer> findAll(){
		return this.repo.findAll();
	}
	
	public Customer queryByEmail(String email){
		return this.repo.queryByEmail(email);
	}
	
	public Customer saveCustomer(Customer customer) {
		return this.repo.save(customer);
	}
	
	
	public List<Customer> customeQueryForName(String name){
		return this.repo.fetchCustomerNames(name);
	}
	
	public List<Customer> customeQueryForPrimeKey(int id){
		return this.repo.fetchCustomerByPrimeKey(id);
	}
	
	public List<CustomerDto> readByCustomerName(String name){
		return this.repo.readByCustomerName(name);
	}
	
	public ICustomer findByEmail(String email){
		return this.repo.findByEmail(email);
	}
	
	public int updateMobileNumber(long old, long latest) {
		return this.repo.updateMobileNumber(old,latest);
	}
	
	@Transactional
	public Map<String, Long> getStream(int id){
		return this.repo.findByCustomerIdGreaterThan(id).collect(Collectors.toMap(Customer::getCustomerName, Customer::getMobileNumber));
	}
	
	public List<Customer> findByCustomerNameWithSpecification(String name){
		return this.sprecifictionRepo.findAll(CustomSpecs.findByCustomerName(name));
	}
	
	
	public List<Customer> getCustomerSortedByProp(String propName){
		return this.sprecifictionRepo.findAll(Sort.by(propName));
	}
	
	public Page<Customer> usePagination(int pageNo, int size) {
		Pageable page = PageRequest.of(pageNo, size);
		return this.repo.findAll(page);
		
	}
}

