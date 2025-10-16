package com.example.demo.repository;

import java.util.Collection;

import com.example.demo.Grocery;
import com.example.demo.Product;

public interface GroceryRepositry extends ProductRepositry {
	Collection<Grocery> findByFabric(String fabric, Collection<Product> list);
}
