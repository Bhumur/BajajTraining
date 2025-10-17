package com.fitness.gym.repository;

import java.util.List;
import java.util.Map;

import com.fitness.gym.entity.Member;
import com.fitness.gym.entity.Trainer;
import com.fitness.gym.entity.WorkoutRecords;
import com.fitness.gym.model.Workout;

public interface MemberRepositry<T> extends UserRepositry<T> {
	Trainer getTrainerOfMember(int id);
	Map<Workout, List<WorkoutRecords>> getWorkoutTracking(int id);
	List<Member> getAllMembersOfTrainerId(int trainerId);
}
