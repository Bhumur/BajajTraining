package com.example.demo.ifaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.OrderBook;

public interface OrderRepo extends JpaRepository<OrderBook, Integer> {

}
