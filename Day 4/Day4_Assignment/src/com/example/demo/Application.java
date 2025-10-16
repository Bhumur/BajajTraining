package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

	
	public static Product getProduct() {
		System.out.print("");
		Product textile = new Textile();
	}
	
	public static void main(String[] args) {
		List<Product> list = new ArrayList<>();
		int option = 1;
		try(Scanner scan = new Scanner(System.in)){
			do {
				System.out.println("*****OPTIONS******");
				option = scan.nextInt();
				switch(option) {
					case 1:{
						System.out.println("***ADD TEXTILE PRODUCT*****");
						
					}
				}
			}while(option!=0);
		}
		
	}

}
