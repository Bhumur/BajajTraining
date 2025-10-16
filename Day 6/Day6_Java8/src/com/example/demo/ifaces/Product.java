package com.example.demo.ifaces;

public interface Product {

	String showInfo();
	
	default String discount() {
		return "10%";
	}
}
