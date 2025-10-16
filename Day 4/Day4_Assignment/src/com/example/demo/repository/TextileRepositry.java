package com.example.demo.repository;

import java.util.Collection;

import com.example.demo.Product;
import com.example.demo.Textile;

public interface TextileRepositry extends ProductRepositry{
	Collection<Textile> findByFabric(String fabric, Collection<Product> list);
}
