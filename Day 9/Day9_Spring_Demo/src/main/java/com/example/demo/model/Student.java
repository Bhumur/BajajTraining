package com.example.demo.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Student {

	
	private int id;
	private String name;
	private double mark;
	
	public Student() {}
	
	public Student(int id,String name, double mark) {
		this.id = id;
		this.name = name;
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", mark=" + mark + "]";
	}
	
	
}
