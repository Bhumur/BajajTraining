package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Doctor {

	@Id
	private int doctorId;
	private String doctorName;
	private String department;
	public Doctor() {
		super();
	}
	public Doctor(int doctorId, String doctorName, String department) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.department = department;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", department=" + department + "]";
	}
	
	
}
