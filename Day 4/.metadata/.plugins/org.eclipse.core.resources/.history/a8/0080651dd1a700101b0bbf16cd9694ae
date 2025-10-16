package com.example.demo.ifaces;

import java.util.Collection;

import com.example.demo.exception.ElementsAlreadyExistException;
import com.example.demo.exception.NotFoundException;

public interface CrudRepositry<T> {
	
	boolean add(T t) throws ElementsAlreadyExistException, NotFoundException;
	boolean update(T a,T t) throws NotFoundException;
	T findById(int id) throws NotFoundException;
	boolean remove(int id) throws NotFoundException;
	Collection<T> findAll();
}
