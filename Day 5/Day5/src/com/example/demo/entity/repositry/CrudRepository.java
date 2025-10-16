package com.example.demo.entity.repositry;

import java.util.Collection;

public interface CrudRepository<T> {
	boolean add(T t) ;
	T findById(int id) ;
	boolean remove(int id);
	Collection<T> findAll();
}
