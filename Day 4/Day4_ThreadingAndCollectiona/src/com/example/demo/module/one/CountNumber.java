package com.example.demo.module.one;

public class CountNumber {
	
	private int count;
	
	public CountNumber(int count) {
		this.count = count;
	}
	
	public void sumNumbers() {
		int total = 0;
		for(int i=0; i<=this.count ; i++) {
			total+=i;
		}
		
		System.out.println(Thread.currentThread().getName() + " Total => " + total);
	}
	
	
}
