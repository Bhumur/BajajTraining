package com.example.demo.entity;

import com.example.demo.model.Address;
import com.example.demo.utils.JpaLifeCycleAware;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "customer", schema = "test", uniqueConstraints = @UniqueConstraint(columnNames = {"mobileNumber","email"}))
@EntityListeners(value =  JpaLifeCycleAware.class)
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
	
	@Embedded
	@AttributeOverrides({
	    @AttributeOverride(name = "lineOne", column = @Column(name = "bill_line_one")),
	    @AttributeOverride(name = "lineTwo", column = @Column(name = "bill_line_two")),
	    @AttributeOverride(name = "city", column = @Column(name = "bill_city")),
	    @AttributeOverride(name = "pincode", column = @Column(name = "bill_pincode"))
	})
	private Address billingAddress;

	@Embedded
	@AttributeOverrides({
	    @AttributeOverride(name = "lineOne", column = @Column(name = "ship_line_one")),
	    @AttributeOverride(name = "lineTwo", column = @Column(name = "ship_line_two")),
	    @AttributeOverride(name = "city", column = @Column(name = "ship_city")),
	    @AttributeOverride(name = "pincode", column = @Column(name = "ship_pincode"))
	})
	private Address shippingAddress;

	public Customer() {
		super();
	}

	public Customer(int customerId, String customerName, long mobileNumber, String email, CustomerType customerType,
			Address billingAddress, Address shippingAddress) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.customerType = customerType;
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", mobileNumber="
				+ mobileNumber + ", email=" + email + ", customerType=" + customerType + ", billingAddress="
				+ billingAddress + ", shippingAddress=" + shippingAddress + "]";
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

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
}
