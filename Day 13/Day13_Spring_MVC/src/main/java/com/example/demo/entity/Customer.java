package com.example.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "customer", schema = "test", uniqueConstraints = @UniqueConstraint(columnNames = {"mobileNumber","email"}))
public class Customer {

	@Id
	@Column(name = "customerid")
	private int customerId;
	
	@Column(name = "customername", length = 30)
	private String customerName;
	
	@Column(name = "customernumber")
	private long mobileNumber;
	
	@Column(name = "customeremail")
	private String email;
	
	@Column(name = "customertype", length = 20)
	@Enumerated(EnumType.STRING)
	private CustomerType customerType;

	public Customer() {
		super();
	}

	public Customer(int customerId, String customerName, long mobileNumber, String email, CustomerType customerType) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.customerType = customerType;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", mobileNumber="
				+ mobileNumber + ", email=" + email + ", customerType=" + customerType + ", billingAddress="+ "]";
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CustomerType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}
	
}
