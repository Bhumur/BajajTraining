package com.example.demo.entity;

import java.util.List;
import java.util.Objects;

public class Bank {
	private int bankId;
	private String bankName;
	private List<Customer> customerList;
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bank(int bankId, String bankName) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
	}
	@Override
	public int hashCode() {
		return Objects.hash(bankId, bankName, customerList);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bank other = (Bank) obj;
		return bankId == other.bankId && Objects.equals(bankName, other.bankName);
	}
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public List<Customer> getCustomerList() {
		return customerList;
	}
	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}
	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", bankName=" + bankName + ", customerList=" + customerList + "]";
	}
	
	
	
	
}
