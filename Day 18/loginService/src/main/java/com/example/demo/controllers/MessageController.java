package com.example.demo.controllers;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class MessageController {


	@GetMapping("secured")
	public String sercured(Principal principle) {
		
		System.out.println(principle.getName());
		
		SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().forEach(e -> System.out.println(e.getAuthority().toString()));
		
		return "From Secured Method +++++++++++++++++++++++";
		
		
		
	}
	
	@GetMapping("unsecured")
	public String unSecured() {
		return "From UnSecured Method -----------------------";
	}
	
	
	@GetMapping("secured/method")
	@PreAuthorize(value = "hasRole('ROLE_GUEST')")
//	@PreAuthorize(value = "hasRole('ROLE_GUEST') or hasRole('ROLE_ADMIN')")
//	@PreAuthorize(value = "hasAnyRole('ROLE_GUEST','ROLE_ADMIN')")
	public String methodSecured() {
		return "THIS METHOD IS SECURED";
	}
}
