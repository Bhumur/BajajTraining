package com.example.demo.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class NameRepository {
	
	
	List<String> names;
	String bestName;
	
	@Autowired    //Ctor injection, we need not add @autowired, since there is only ctor
	public NameRepository(List<String> names, @Qualifier("alpha") String name) {
		this.names = names;
		this.bestName = name;
	}

	public List<String> getName(){
//		return Arrays.asList("Ram","Shyam","Vaishali");
		return this.names;
	}
	
	public String getBestName() {
		return bestName.toUpperCase();
	}
	
	
	
}
