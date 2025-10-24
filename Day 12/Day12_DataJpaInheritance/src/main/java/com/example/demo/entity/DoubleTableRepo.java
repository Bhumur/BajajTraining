package com.example.demo.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DoubleTableRepo<T extends Teacher> extends JpaRepository<T, Integer> {

}
