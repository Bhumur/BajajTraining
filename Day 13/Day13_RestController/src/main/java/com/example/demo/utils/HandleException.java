package com.example.demo.utils;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class HandleException {

	
	@ExceptionHandler(RuntimeException.class)
	public ExceptionWrapper handleRuntime(Exception ex, WebRequest req) {
		return new ExceptionWrapper(ex.getMessage(), LocalDateTime.now(), req.getDescription(false));
	}
}
