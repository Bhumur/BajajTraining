package com.example.demo;

class Order{
	int orderId;
	int orderValue;
	String customerName;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int orderId, int orderValue, String customerName) {
		super();
		this.orderId = orderId;
		this.orderValue = orderValue;
		this.customerName = customerName;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderValue=" + orderValue + ", customerName=" + customerName + "]";
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getOrderValue() {
		return orderValue;
	}
	public void setOrderValue(int orderValue) {
		this.orderValue = orderValue;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	
}