package com.example.demo.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "MRG")
public class Manager extends Employee {

	private String location;
	private String project;
	public Manager(int empliyeeId, String employeeName, String location, String project) {
		super(empliyeeId, employeeName);
		this.location = location;
		this.project = project;
	}
	public Manager() {
		super();
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	@Override
	public String toString() {
		return super.toString() + " Manager [location=" + location + ", project=" + project + "]";
	}
	
	
}
