package com.example.demo.ifaces;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface MyDao<T> {
	List<T> findAll();

	boolean save(T t);

	T findById(int id);
}
