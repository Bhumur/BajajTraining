package com.example.demo.entity;

import java.util.List;

public class Doctor {

	private int doctorId;
	private String doctorName;
	private String Department;
	
	private List<Patient> patientList;

	public Doctor(int doctorId, String doctorName, String department, List<Patient> patientList) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		Department = department;
		this.patientList = patientList;
	}

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
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
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public List<Patient> getPatientList() {
		return patientList;
	}

	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", Department=" + Department
				+ ", patientList=" + patientList + "]";
	}
	
	
}
