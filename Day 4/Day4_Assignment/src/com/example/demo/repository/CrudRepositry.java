package com.example.demo.repository;

import java.util.Collection;

import com.example.demo.exception.ElementsAlreadyExistException;
import com.example.demo.exception.NotFoundException;

public interface CrudRepositry<T> {
	
	boolean add(T t, Collection<T> list) throws ElementsAlreadyExistException, NotFoundException;
	boolean update(int a,T t, Collection<T> list) throws NotFoundException;
	boolean remove(int id, Collection<T> list) throws NotFoundException;
	T findById(int id, Collection<T> list) throws NotFoundException;
	Collection<T> findByName(String name, Collection<T> list);
	Collection<T> findAll(Collection<T> list);
}
