package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
//@Table(name = "loan_identity")
//@Table(name = "loan_seq")
//@Table(name = "loan_myseq")
//@Table(name = "loan_uuid")
@Table(name = "loan_auto")

public class LoanApplication {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
//	@SequenceGenerator(name = "myseq")
//	@GeneratedValue(strategy = GenerationType.UUID)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int applicationNumber;
	
	@Column(name = "application_name")
	private String applicationName;

	public LoanApplication() {
		super();
	}

	public LoanApplication(String applicationName) {
		super();
		this.applicationName = applicationName;
	}

	public int getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(int applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	@Override
	public String toString() {
		return "LoanApplication [applicationNumber=" + applicationNumber + ", applicationName=" + applicationName + "]";
	}
	
	
}
