package com.fitness.gym.repository;

import java.util.List;

import com.fitness.gym.entity.User;

public interface UserRepositry<T> extends CRUDRepositiry<T> {
	List<? extends User> getByName(String name);
	User getByEmail(String email);
}
