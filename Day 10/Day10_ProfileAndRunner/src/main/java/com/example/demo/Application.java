package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.example.demo.service.OrderDetails;

@SpringBootApplication
public class Application {

	 @Autowired
	 private Environment environment;
	
	public static void main(String[] args) {
		
//		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(Application.class)
													.profiles("dev")
													.run(args);
//		 Environment env = ctx.getEnvironment();
//
//	        // ✅ Print active profiles
//	        String[] activeProfiles = env.getActiveProfiles();
//	        if (activeProfiles.length == 0) {
//	            System.out.println("👉 No active profiles set. Using default profile.");
//	        } else {
//	            System.out.println("👉 Active Profiles:");
//	            for (String profile : activeProfiles) {
//	                System.out.println("   - " + profile);
//	            }
//	        }
		
		ctx.getBean(OrderDetails.class).getOrderDetails().forEach(System.out::println);
		
		ctx.close();
	}
	
	@Bean
	CommandLineRunner runner() {
		return args->{
			
			System.out.println("INside Runner ............");
			
			for(int i=0;i<args.length;i++) {
				System.out.println("args" + args[i]);
			}
		};
	}

}
