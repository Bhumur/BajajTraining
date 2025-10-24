package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MyOrder;
import com.example.demo.entity.OrderBook;
import com.example.demo.ifaces.OrderRepo;

@Service
public class OrderService {

	@Autowired
	private OrderRepo repo;
	
	
	public boolean addToOrderBook() {
		List<MyOrder> orders = new ArrayList<>();
		
		orders.add(new MyOrder("first", 10.1));
		orders.add(new MyOrder("second", 11.1));
		orders.add(new MyOrder("third", 12.1));
		
		OrderBook obook = new OrderBook(orders);
		
		this.repo.save(obook);
		
		return true;
	}
	
	public List<OrderBook> get() {
		return this.repo.findAll();
	}
}

