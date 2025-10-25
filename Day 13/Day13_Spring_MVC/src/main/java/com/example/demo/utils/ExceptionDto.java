package com.example.demo.utils;

public class ExceptionDto {
    private String message;
    private String details;
    private int status;

    // Getters and setters
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }

    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }
}
