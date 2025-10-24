package com.example.demo.ifaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.CustomerWithImage;

public interface CustomerWithImageRepo extends JpaRepository<CustomerWithImage, Integer> {

}
