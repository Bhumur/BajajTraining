package com.example.demo.entity;

import com.example.demo.model.Auditable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "stock")
public class Stock extends Auditable {

	@Id
	@Column(name = "product_id")
	private int productId;
	
	@Column(name = "product_name", length = 20)
	private String productName;
	
	@Column(name = "product_warehouse_location", length = 30)
	private String warehouseLocation;
	
	@Column(name = "product_quantity")
	private double quantity;
	public Stock(int productId, String productName, String warehouseLocation, double quantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.warehouseLocation = warehouseLocation;
		this.quantity = quantity;
	}
	public Stock() {
		super();
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getWarehouseLocation() {
		return warehouseLocation;
	}
	public void setWarehouseLocation(String warehouseLocation) {
		this.warehouseLocation = warehouseLocation;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Stock [productId=" + productId + ", productName=" + productName + ", warehouseLocation="
				+ warehouseLocation + ", quantity=" + quantity + "]";
	}
	
	
	
}
