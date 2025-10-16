package com.example.demo.service;

import com.example.demo.Student;

public class StudentService {
	
	
//	public static void showDetails() {
//		System.out.println(this.getClass().getName()); as this refer to instance which cant be in static method
//	}
	
	
	public void showDetail() {
		System.out.println(this.getClass().getName()); // Give fullClassified Class Name
		System.out.println(this.getClass().getClassLoader().getName()); // Give name of loader which is loading class
		System.out.println(this.getClass().getClassLoader().getClass().getName()); //jdk.internal.loader.ClassLoaders$AppClassLoader here $ is bc AppClassLoader is inner class of ClassLoader
	}

	//Passing an Object to the method 
	//
	
	public Student assignGrade(Student student) {
		
		// Refactoring for use overloading method
		student.setGrade(assignGrade(student.getMarkScored()));
		
		
//		if(student.getMarkScored()>80)
//			student.setGrade("A");
//		else
//			student.setGrade("B");
		return student;
	}
	
	//Overloaded Method which takes the marks as arguments
	
	public String assignGrade(int mark) {
//		String grade = "B";
//		if(mark>80)
//			grade = "A";
//		return grade;
		
		return mark>80?"A":"B";
	}
}
