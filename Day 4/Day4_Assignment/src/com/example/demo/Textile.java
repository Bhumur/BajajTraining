package com.example.demo;

import java.util.Objects;

public class Textile extends Product {
	private String facbric;

	public Textile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Textile(int productId, String productName, double productPrice, String fabric) {
		super(productId, productName, productPrice);
		this.facbric = fabric;
	}

	public String getFacbric() {
		return facbric;
	}

	public void setFacbric(String facbric) {
		this.facbric = facbric;
	}

	@Override
	public String toString() {
		return "Textile [facbric=" + facbric + "]" + super.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(facbric);
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
		Textile other = (Textile) obj;
		return Objects.equals(facbric, other.facbric);
	}
	
	
	
	
}
