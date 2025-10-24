package com.example.demo.entity;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
@Entity
@Table(name = "customer_withimage")
public class CustomerWithImage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private int customerId;
	
	@Column(name = "customer_name", length = 30)
	private String customerName;
	
	@Column(name = "customer_image", columnDefinition = "LONGBLOB")
	@Lob
	private byte[] imageRef;

	public CustomerWithImage(int customerId, String customerName, byte[] imageRef) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.imageRef = imageRef;
	}

	public CustomerWithImage( String customerName, byte[] imageRef) {
		super();
		this.customerName = customerName;
		this.imageRef = imageRef;
	}
	
	public CustomerWithImage() {
		super();
		// TODO Auto-generated constructor stub
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

	public byte[] getImageRef() {
		return imageRef;
	}

	public void setImageRef(byte[] imageRef) {
		this.imageRef = imageRef;
	}

	@Override
	public String toString() {
		return "CustomerWithImage [customerId=" + customerId + ", customerName=" + customerName + ", imageRef="
				+ Arrays.toString(imageRef) + "]";
	}
	
	
	
	
	
}
