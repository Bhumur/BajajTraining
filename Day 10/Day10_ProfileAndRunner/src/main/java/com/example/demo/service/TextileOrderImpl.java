package com.example.demo.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
//@Primary //it work but use profile 
public class TextileOrderImpl implements OrderDetails {

	@Override
	public List<String> getOrderDetails() {
		return List.of("Pant", "Jeans", "Polor", "Shirt", "Sherwani");
	}

}
