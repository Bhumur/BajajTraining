package com.fitness.gym.appliction;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fitness.gym.entity.Member;
import com.fitness.gym.entity.Trainer;
import com.fitness.gym.exceptions.DuplicateIdException;
import com.fitness.gym.service.MemberServiceImpl;
import com.fitness.gym.service.TrainerServiceImpl;
import com.fitness.gym.utils.SqlConnection;

public class GymApplication {
	public static void main(String []args) {
		System.out.println("**********************WELCOME TO FITNESS GYM*********************");
		Connection connection = SqlConnection.getSqlConnection();
		
		MemberServiceImpl memberService = new MemberServiceImpl(connection);
		TrainerServiceImpl trainerService = new TrainerServiceImpl(connection);
		//System.out.println(service.getMemberById(1));
		
		memberService.getAllMembers().forEach(System.out::println);
		trainerService.getAllTrainers().forEach(System.out::println);
		int option;
		try(Scanner sc = new Scanner(System.in)){
			do {
				options();
				option = sc.nextInt(); 
				switch(option) {
					case 1: {
						System.out.println("***************ADDING A USER****************");
						System.out.print("Enter Id of User : ");
						int id = sc.nextInt();
						System.out.print("Enter Name of User : ");
						sc.nextLine();
						String name = sc.nextLine();
						System.out.print("Enter Email of User : ");
						String email = sc.next();
						System.out.print("Enter Password of User : ");
						String password = sc.next();
						System.out.println("Options for type of User :");
						System.out.println("1. MEMBER");
						System.out.println("2. TRAINER");
						System.out.print("Choose option : ");
						int userOption;
						do {
							userOption = sc.nextInt();
							switch(userOption) {
								case 1:{
									System.out.print("Enter Height of Member : ");
									double height = sc.nextDouble();
									System.out.print("Enter Weight of Member : ");
									double weight = sc.nextDouble();
									System.out.print("Enter Trainer id :");
									int trainerid = sc.nextInt();
									Trainer trainer = trainerService.getTrainerByTrainerId(trainerid);
									try {
										memberService.addMember(id, name, email, password, weight, height,trainer);
									} catch (DuplicateIdException e) {
										e.printStackTrace();
									}
								}
								case 2:{
									System.out.print("Enter Experience of Trainer : ");
									int exp = sc.nextInt();
									trainerService.addTrainer(id, name, email, password, exp);
								}
							}
							
						}while(userOption!=1 || userOption!=2);
						break;
						
					}
					case 2: {
						
					}
					case 3: {
						
					}
					case 4: {
						
					}
				}
			}while(option!=0);
		}
		
		
		
		
	}

	private static void options() {
		System.out.println("+++++++++OPTIONS++++++++++++");
		System.out.println("1. Add a Member");
		System.out.println("2. Add a Trainer");
		System.out.println("3. Login as Member");
		System.out.println("4. Login as Trainer");
	}
}
