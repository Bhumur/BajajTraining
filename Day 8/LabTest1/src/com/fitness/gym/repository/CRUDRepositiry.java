package com.fitness.gym.repository;

import java.util.List;

import com.fitness.gym.exceptions.DuplicateIdException;
import com.fitness.gym.exceptions.MemberNotFoundException;

public interface CRUDRepositiry<T> {
	boolean add(T a) throws DuplicateIdException;
	boolean remove(T a) throws MemberNotFoundException;
	boolean update(T a);
	T getById(int id);
	boolean addAll(List<T> list);
}
