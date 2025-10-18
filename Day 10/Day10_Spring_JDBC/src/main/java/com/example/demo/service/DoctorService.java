package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Doctor;
import com.example.demo.ifaces.MyDao;


@Service
public class DoctorService {

	private MyDao<Doctor> dao;

	public DoctorService(MyDao<Doctor> dao) {
		super();
		this.dao = dao;
	}
	
	public List<Doctor> findAll(){
		return this.dao.findAll();
	}
	
	public boolean save(Doctor d) {
		return this.dao.save(d);
	}
	
	public Doctor findByDoctorId(int id) {
		return this.dao.findById(id);
	}
	
	
}
