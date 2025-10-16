package com.example.demo;

import com.example.demo.annotation.Invoker;
import com.example.demo.annotation.Table;

@Table(name = "book")
public class Book {
	
	
	@Invoker(value = "Diwali")
	public String find(String val) {
		return val + " Added";
	}
}
