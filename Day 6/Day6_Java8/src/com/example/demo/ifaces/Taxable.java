package com.example.demo.ifaces;

import java.time.LocalDate;

public interface Taxable {

	LocalDate getLastDate();
	
	default String discount() {
		return "2%";
	}
}
