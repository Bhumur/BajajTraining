package com.fitness.gym.appliction;

import java.sql.Connection;

import com.fitness.gym.service.MemberServiceImpl;
import com.fitness.gym.utils.SqlConnection;

public class GymApplication {
	public static void main(String []args) {
		System.out.println("**********************WELCOME TO FITNESS GYM*********************");
		Connection connection = SqlConnection.getSqlConnection();
		
		MemberServiceImpl service = new MemberServiceImpl(connection);
		
		//System.out.println(service.getMemberById(1));
		
		service.getAllMembers().forEach(System.out::println);
		
	}
}
