package com.example.demo.abstraction;

import java.time.LocalDate;

public class LifeInsurance extends Insurance {

	private LocalDate dateOfBirth;
	
	
	
	public LifeInsurance(int policyNumber, String policyHolderName, double policyAmount, LocalDate dob) {
		super(policyNumber, policyHolderName, policyAmount);
		this.dateOfBirth = dob;
	}

	private int calculateAge() {
		return LocalDate.now().getYear() - this.dateOfBirth.getYear();
	}

	@Override
	public double calculatePremium() {
		// TODO Auto-generated method stub
		return calculateAge()*101;
	}
	
	public String sayHello() {
		return "helo";
	}

}
