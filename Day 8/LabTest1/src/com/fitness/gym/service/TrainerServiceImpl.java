package com.fitness.gym.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.fitness.gym.entity.Member;
import com.fitness.gym.entity.Trainer;
import com.fitness.gym.repository.TrainerRepoImpl;

public class TrainerServiceImpl {
	
	TrainerRepoImpl repo;
	
	public TrainerServiceImpl(Connection con) {
		this.repo = new TrainerRepoImpl(con);
	}

	public Trainer getTrainerByTrainerId(int trainerid) {
		return repo.getById(trainerid);
	}
	
	public List<Trainer> getAllTrainers(){
		return repo.getAllTrainers();
	}
	public boolean addTrainer(int id, String name, String email, String password, int experience) {
		List<Member> memberList = new ArrayList<>();
		Trainer trainer = new Trainer(id, name, email, password, experience, memberList);
		return repo.add(trainer);
	}
	
}
