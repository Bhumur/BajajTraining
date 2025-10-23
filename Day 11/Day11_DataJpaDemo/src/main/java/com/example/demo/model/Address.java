package com.example.demo.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

	private String lineOne;
	private String lineTwo;
	private String city;
	private long pincode;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String lineOne, String lineTwo, String city, long pincode) {
		super();
		this.lineOne = lineOne;
		this.lineTwo = lineTwo;
		this.city = city;
		this.pincode = pincode;
	}
	public String getLineOne() {
		return lineOne;
	}
	public void setLineOne(String lineOne) {
		this.lineOne = lineOne;
	}
	public String getLineTwo() {
		return lineTwo;
	}
	public void setLineTwo(String lineTwo) {
		this.lineTwo = lineTwo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [lineOne=" + lineOne + ", lineTwo=" + lineTwo + ", city=" + city + ", pincode=" + pincode + "]";
	}
	
	
}
