package com.example.demo.utils;

import java.util.logging.Logger;

import com.example.demo.entity.Customer;

import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;

public class JpaLifeCycleAware {

	
	Logger log = Logger.getAnonymousLogger();
	
	@PrePersist
	@PreUpdate
	@PreRemove
	public void persist(Customer cust) {
		if(cust.getCustomerId()==0) {
			log.info("================> One Customer About to Add");
		}else {
			log.info("================> One Customer About to Remove/Update");
		}
	}
	
	@PostUpdate
	@PostRemove
	@PostPersist
	public void afterUpdate(Customer cust) {
		if(cust.getCustomerId()!=0) {
			log.info("================> One Customer Added");
		}else {
			log.info("================> One Customer Updated/Removed");
		}
	}
	
	@PostLoad
	public void afterLoad(Customer cust) {
		cust.setCustomerName("Mr.".concat(cust.getCustomerName()));
	}
}
