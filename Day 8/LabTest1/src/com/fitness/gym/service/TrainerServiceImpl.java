package com.fitness.gym.service;

import java.sql.Connection;

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
	
	
}
