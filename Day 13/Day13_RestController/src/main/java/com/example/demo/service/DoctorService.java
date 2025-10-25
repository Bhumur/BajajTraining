package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DoctorDto;
import com.example.demo.entity.Doctor;
import com.example.demo.repo.DoctorRepo;

@Service
public class DoctorService {
	
	@Autowired
	private DoctorRepo repo;
	
	
	public DoctorDto mapDocToDto(Doctor doc) {
		return new DoctorDto(doc.getDoctorId(), doc.getDoctorName(), doc.getDepartment());
	}
	
	public Doctor mapDtoToDoc(DoctorDto dto) {
		return new Doctor(dto.doctorId(), dto.doctorName(), dto.department());
	}
	
	public DoctorDto saveDoctor(DoctorDto dto) {
		return mapDocToDto(this.repo.save(mapDtoToDoc(dto)));
	}
	
	public DoctorDto findById(int id) {
		return mapDocToDto(this.repo.findById(id).orElseThrow(()-> new RuntimeException(id + " : Id is not Present")));
	}
	
	public List<DoctorDto> findByDoctorName(String name){
		return this.repo.findAllByDoctorName(name)
				.stream()
				.map(e->new DoctorDto(e.getDoctorId(),e.getDoctorName(),e.getDepartment()))
				.collect(Collectors.toList());
	}
	
	public List<DoctorDto> findAllDoctor(){
		return this.repo.findAll()
				.stream()
				.map(e->new DoctorDto(e.getDoctorId(),e.getDoctorName(),e.getDepartment()))
				.collect(Collectors.toList());
	}
	
	public List<DoctorDto> findByDepartment(String name){
		return this.repo.findAllByDepartment(name)
				.stream()
				.map(e->new DoctorDto(e.getDoctorId(),e.getDoctorName(),e.getDepartment()))
				.collect(Collectors.toList());
	}
	
	public List<DoctorDto> findAllSortedByDepartment() {
	    return this.repo.findAll()
	            .stream()
	            .map(e -> new DoctorDto(e.getDoctorId(), e.getDoctorName(), e.getDepartment()))
	            .sorted((a, b) -> a.department().compareTo(b.department()))
	            .collect(Collectors.toList());
	}
	
	public List<DoctorDto> findAllSortedByName() {
	    return this.repo.findAll()
	            .stream()
	            .map(e -> new DoctorDto(e.getDoctorId(), e.getDoctorName(), e.getDepartment()))
	            .sorted((a, b) -> a.doctorName().compareTo(b.doctorName()))
	            .collect(Collectors.toList());
	}

	public List<DoctorDto> findAllSortedById() {
	    return this.repo.findAll()
	            .stream()
	            .map(e -> new DoctorDto(e.getDoctorId(), e.getDoctorName(), e.getDepartment()))
	            .sorted((a, b) -> a.doctorId() - b.doctorId())
	            .collect(Collectors.toList());
	}
	
}
