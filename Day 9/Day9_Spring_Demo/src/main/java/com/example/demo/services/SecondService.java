package com.example.demo.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repo.NameRepository;

@Service
public class SecondService {

	Logger log = Logger.getAnonymousLogger();
	
	// Field Injection
	@Autowired
	NameRepository nameRepository;

	private Student student;
	
	
	public SecondService(Student student) {
		System.out.println("2222222222222222");
		this.student = student;
	}
	
	
	public List<String> getName(){
		
		log.info(nameRepository.getClass().getName());
		
		return nameRepository.getName();
	}





	public String getString() {
		
		log.info(nameRepository.getClass().getName());
		return nameRepository.getBestName();
	}
	
	public String getBestStudent() {
		return this.student.toString();
	}
	
	
}
