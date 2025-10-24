package com.example.demo.entity;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_one_hierarchy")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "empType")
public class Employee {
	@Id
	private int empliyeeId;
	private String employeeName;
	
	public Employee(int empliyeeId, String employeeName) {
		super();
		this.empliyeeId = empliyeeId;
		this.employeeName = employeeName;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEmpliyeeId() {
		return empliyeeId;
	}
	public void setEmpliyeeId(int empliyeeId) {
		this.empliyeeId = empliyeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	@Override
	public String toString() {
		return "Employee [empliyeeId=" + empliyeeId + ", employeeName=" + employeeName + "]";
	}
	
}