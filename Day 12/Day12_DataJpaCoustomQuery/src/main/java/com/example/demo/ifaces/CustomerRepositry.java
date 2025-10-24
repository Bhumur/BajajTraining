package com.example.demo.ifaces;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.ICustomer;
import com.example.demo.entity.Customer;

import jakarta.transaction.Transactional;



public interface CustomerRepositry extends JpaRepository<Customer, Integer> {
	
	
	List<Customer> findByCustomerName(String name);
	
	Customer queryByEmail(String email);
	
	//JPQL
	
	@Query(value = "from Customer where customerName=:name", nativeQuery = false)
	List<Customer> fetchCustomerNames(@Param("name")String name); //Not a DSL Query (Domain Specific Query) meaning not following naming convention
	
	
	//SQL
	@Query(value = "select * from customer_datajpacoustomquery where customer_id=:id", nativeQuery = true)
	List<Customer> fetchCustomerByPrimeKey(@Param("id")int id);
	
	//Using Projection
	
	List<CustomerDto> readByCustomerName(String customerName);
	
	ICustomer findByEmail(String email);
	
//	List<Customer> findByCustomerIde(int srch); 	//just to understanding adding method with wrong syntax
	
	@Modifying
	@Transactional
	@Query(value = "update Customer set mobileNumber=:latestNumber where mobileNumber=:oldNumber")
	int updateMobileNumber(@Param("oldNumber")long oldNumber, @Param("latestNumber")long latestNumber);
	
	Stream<Customer> findByCustomerIdGreaterThan(int id);
}
