package com.example.demo;

import java.time.LocalDate;

public class LifeInsurance extends Insurance {
	
	private LocalDate dateOfBirth;
	
	public LifeInsurance() {
		super();
	}

	public LifeInsurance(int policyNumber, String policyHolderName, double policyAmount, LocalDate dob) {
		super(policyNumber, policyHolderName, policyAmount);
		this.dateOfBirth = dob;
	}
	
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getAge() {
		LocalDate today = LocalDate.now();
		int age = today.getDayOfYear()-this.dateOfBirth.getDayOfYear();
		return age;
	}

	@Override
	public double calculatePremium() {
		return getAge()*1500;
	}

	@Override
	public String toString() {
		return super.toString() + "LifeInsurance [dateOfBirth=" + dateOfBirth + "]";
	}
	
	
}
