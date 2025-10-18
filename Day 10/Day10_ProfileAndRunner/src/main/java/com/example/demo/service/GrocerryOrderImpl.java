package com.example.demo.service;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class GrocerryOrderImpl implements OrderDetails {

	@Override
	public List<String> getOrderDetails() {
		return List.of("Mikl", "Sugar", "Almonds", "IceCream", "Tea");
	}

}
