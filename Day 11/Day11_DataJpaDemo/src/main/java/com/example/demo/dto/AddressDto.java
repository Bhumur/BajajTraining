package com.example.demo.dto;

public record AddressDto(String lineOne, String lineTwo, String city, long pincode) {

    public AddressDto() {
        this(null, null, null, 0L);
    }

}
