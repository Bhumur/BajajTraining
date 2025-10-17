package com.fitness.gym.entity;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.fitness.gym.model.Exercies;
import com.fitness.gym.model.Food;
import com.fitness.gym.model.Workout;

public class Member extends User {
	private double weight;
	private double height;
	private Trainer trainer;
	private Map<Workout, List<WorkoutRecords>> workoutTracking;
	private Set<Exercies> exercises;
	private Set<Food> food;
	public Member() {
		super();
	}
	public Member(int id, String name, String email, String password,double weight, double height, Trainer trainer, Map<Workout, List<WorkoutRecords>> workoutTracking,
			Set<Exercies> exercises, Set<Food> food) {
		super(id, name, email, password);
		this.weight = weight;
		this.height = height;
		this.trainer = trainer;
		this.workoutTracking = workoutTracking;
		this.exercises = exercises;
		this.food = food;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	public Map<Workout, List<WorkoutRecords>> getWorkoutTracking() {
		return workoutTracking;
	}
	public void setWorkoutTracking(Map<Workout, List<WorkoutRecords>> workoutTracking) {
		this.workoutTracking = workoutTracking;
	}
	public Set<Exercies> getExercises() {
		return exercises;
	}
	public void setExercises(Set<Exercies> exercises) {
		this.exercises = exercises;
	}
	public Set<Food> getFood() {
		return food;
	}
	public void setFood(Set<Food> food) {
		this.food = food;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(exercises, food, height, trainer, weight, workoutTracking);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return Objects.equals(exercises, other.exercises) && Objects.equals(food, other.food)
				&& Double.doubleToLongBits(height) == Double.doubleToLongBits(other.height)
				&& Objects.equals(trainer, other.trainer)
				&& Double.doubleToLongBits(weight) == Double.doubleToLongBits(other.weight)
				&& Objects.equals(workoutTracking, other.workoutTracking);
	}
	@Override
	public String toString() {
		return super.toString() + "Member [weight=" + weight + ", height=" + height + ", trainer=" + trainer.getName() + ", workoutTracking="
				+ workoutTracking + ", exercises=" + exercises + ", food=" + food + "]";
	}
	
	
	
}
