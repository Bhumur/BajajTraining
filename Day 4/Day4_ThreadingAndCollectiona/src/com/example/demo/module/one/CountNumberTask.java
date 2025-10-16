package com.example.demo.module.one;

public class CountNumberTask implements Runnable {

	private CountNumber service;
	private int countUpTo;
	private String name;
	
	public CountNumberTask(int countUpTo, String name) {
		super();
		this.countUpTo = countUpTo;
		this.name = name;
		
		this.service = new CountNumber(countUpTo);
		
		Thread thread = new Thread(this, name);
		thread.start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.service.sumNumbers();
	}

}
