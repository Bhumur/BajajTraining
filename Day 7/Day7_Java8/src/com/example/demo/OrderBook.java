package com.example.demo;

import java.time.LocalDate;
import java.util.List;

class OrderBook{
	LocalDate date;
	List<Order> orders;
	public OrderBook() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderBook(LocalDate date, List<Order> orders) {
		super();
		this.date = date;
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "OrderBook [date=" + date + ", orders=" + orders + "]";
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}

