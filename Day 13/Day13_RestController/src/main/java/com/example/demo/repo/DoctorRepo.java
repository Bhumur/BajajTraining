package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor, Integer> {

	List<Doctor> findAllByDoctorName(String name);

	List<Doctor> findAllByDepartment(String name);
}
