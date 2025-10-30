package com.example.demo.utils;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomException {

	@ExceptionHandler(exception = MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>>  handleFieldError(MethodArgumentNotValidException ex){
		Map<String, Object> errors = ex.getBindingResult().getAllErrors().stream()
		.map(error -> (FieldError)error)
		.collect(Collectors.toMap(FieldError::getField, DefaultMessageSourceResolvable::getDefaultMessage));
		
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
	
}
