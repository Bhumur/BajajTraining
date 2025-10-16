package com.example.demo.ifaces;

public class FarenToCel implements Function {

	
	
	
	@Override
	public double apply(double val) {
		// TODO Auto-generated method stub
		return (val - 32) * (5.0 / 9.0);
	}

}
