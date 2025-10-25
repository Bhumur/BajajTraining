package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orderbook")
public class OrderBook {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_book_id")
	private int orderBookId;
	
	@OneToMany(targetEntity = MyOrder.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "order_ref", referencedColumnName = "order_book_id")
	private List<MyOrder> orders;

	public OrderBook() {
		super();
	}

	public OrderBook(int orderBookId, List<MyOrder> orders) {
		super();
		this.orderBookId = orderBookId;
		this.orders = orders;
	}
	public OrderBook(List<MyOrder> orders) {
		super();
		this.orders = orders;
	}

	public int getOrderBookId() {
		return orderBookId;
	}

	public void setOrderBookId(int orderBookId) {
		this.orderBookId = orderBookId;
	}

	public List<MyOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<MyOrder> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "OrderBook [orderBookId=" + orderBookId + ", orders=" + orders + "]";
	}
	
}
