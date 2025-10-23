package com.example.demo.entity;


import com.example.demo.model.Auditable;
import com.example.demo.model.Composed;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventory")
public class Inventory extends Auditable{


	@EmbeddedId
	private Composed key;
	
	@Column(name = "quantity")
	private double quantity;

	public Inventory(Composed key, double quantity) {
		super();
		this.key = key;
		this.quantity = quantity;
	}

	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Composed getKey() {
		return key;
	}

	public void setKey(Composed key) {
		this.key = key;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Inventory [key=" + key + ", quantity=" + quantity + "]";
	}
	
	
}
