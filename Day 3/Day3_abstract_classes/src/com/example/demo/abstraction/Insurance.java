package com.example.demo.abstraction;

public abstract class Insurance {
	private int policyNumber;
	private String policyHolderName;
	private double policyAmount;
	
	
	
	public Insurance(int policyNumber, String policyHolderName, double policyAmount) {
		super();
		this.policyNumber = policyNumber;
		this.policyHolderName = policyHolderName;
		this.policyAmount = policyAmount;
	}



	public int getPolicyNumber() {
		return policyNumber;
	}



	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}



	public String getPolicyHolderName() {
		return policyHolderName;
	}



	public void setPolicyHolderName(String policyHolderName) {
		this.policyHolderName = policyHolderName;
	}



	public double getPolicyAmount() {
		return policyAmount;
	}



	public void setPolicyAmount(double policyAmount) {
		this.policyAmount = policyAmount;
	}



	@Override
	public String toString() {
		return "Insurance [policyNumber=" + policyNumber + ", policyHolderName=" + policyHolderName + ", policyAmount="
				+ policyAmount + "]";
	}



	public abstract double calculatePremium();
	
	
	
	
	public String nonAbstract() {
		return "I am Not an Abstract Method";
	}
}
