package com.example.demo.dto;

import com.example.demo.entity.CustomerType;

public record CustomerDto(int customerId,
		String customerName,
		long mobileNumber,
		String email,
		CustomerType customerType,
		AddressDto billingAddress,
		AddressDto shippingAddress) {}
