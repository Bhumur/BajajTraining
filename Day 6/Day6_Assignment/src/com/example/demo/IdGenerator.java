package com.example.demo;

public class IdGenerator {
	
	private int count = 1;
	private static IdGenerator obj;
	
	private IdGenerator() {}
	
	public static IdGenerator newInstance() {
		if(obj == null)
			obj = new IdGenerator();
		return obj;
	}
	
	public int getNewId() {
		return count++;
	}
	
}
