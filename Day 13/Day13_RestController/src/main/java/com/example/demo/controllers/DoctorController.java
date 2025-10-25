package com.example.demo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.dto.DoctorDto;
import com.example.demo.service.DoctorService;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {
	
	@Autowired
	private DoctorService service;
	
	@GetMapping
	public List<DoctorDto> getAllDoctors(){
		return service.findAllDoctor();
	}
	
	@PostMapping
	public ResponseEntity<DoctorDto> save(@RequestBody DoctorDto dto){
	    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
	                    .path("/{id}")
	                    .buildAndExpand(dto.doctorId())
	                    .toUri();
	    return ResponseEntity.created(location).body(this.service.saveDoctor(dto));
	}

	
	@GetMapping("/{id}")
	public DoctorDto find(@PathVariable("id")int id){
		return service.findById(id);
	}
}
