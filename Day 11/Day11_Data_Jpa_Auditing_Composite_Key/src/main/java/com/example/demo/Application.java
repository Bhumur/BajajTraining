//package com.example.demo;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.domain.AuditorAware;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//
//import com.example.demo.entity.Inventory;
//import com.example.demo.entity.Stock;
//import com.example.demo.model.Composed;
//import com.example.demo.model.StockDto;
//import com.example.demo.service.StockService;
//
////@SpringBootApplication
////@EnableJpaAuditing(auditorAwareRef = "auditBean")
//public class Application {
//
//	@Autowired
//	StockService service;
//	
//	public static void main(String[] args) {
//		
//		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
//		
//		StockService service = ctx.getBean(StockService.class);
//		
////		StockDto stock1 = new StockDto(5, "egg", "pashan, Pune", 1000);
////		service.add(stock1);
////		service.add(ctx.getBean("tvstock",StockDto.class));
//		
//		ctx.close();
//	}
//	
//	@Bean
//	CommandLineRunner runner() {
//		return new CommandLineRunner() {
//			@Autowired
//			JpaRepository<Inventory, Composed> repo;
//			
//			@Override
//			public void run(String... args) throws Exception {
////				repo.save(new Inventory(new Composed("light", "shaniwarwada"),121.2));
//				
//				System.out.println(repo.findById(new Composed("ligt", "shaniwarwada")).get());
//			}
//		};
//	}
//	
//	@Bean
//	StockDto tvstock() {
//		return new StockDto(3,"brush","klalammsm",1212.2);
//	}
//	
//	@Bean
//	AuditorAware<String> auditBean(){
//		return ()-> Optional.of("Admin");
//	}
//
//}
