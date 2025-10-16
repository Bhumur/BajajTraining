package com.example.demo;

import java.util.Objects;

public class Grocery extends Product {
	private String category;

	public Grocery() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Grocery(int productId, String productName, double productPrice, String category) {
		super(productId, productName, productPrice);
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Grocery [category=" + category + "]" + super.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(category);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grocery other = (Grocery) obj;
		return Objects.equals(category, other.category);
	}
	
	
	
	
}
