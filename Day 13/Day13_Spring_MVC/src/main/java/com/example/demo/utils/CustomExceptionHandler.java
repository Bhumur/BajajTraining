package com.example.demo.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> showMessage(WebRequest request, Exception ex) {
        // Create custom DTO
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage(ex.getMessage());
        dto.setDetails(request.getDescription(false)); // URL and details
        dto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        
        return new ResponseEntity<>(dto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
