package com.example.demo;

import java.sql.Connection;

import com.example.demo.utils.ConnectionUtils;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    	Connection connection = ConnectionUtils.getMySqlConnection();
		System.out.println(connection);
		
    }
}
