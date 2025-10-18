package com.fitness.gym.entity;

import com.fitness.gym.model.Unit;
import com.fitness.gym.model.Workout;


public class WorkoutRecords {
	private int id;
	private Workout workout;
	private double highest;
	private double average;
	private Unit unit;
	private int caloriesBurn;
	private int memberid;
	public WorkoutRecords(int id, Workout workout, double highest, double average, Unit unit, int caloriesBurn,
			int memberid) {
		super();
		this.id = id;
		this.workout = workout;
		this.highest = highest;
		this.average = average;
		this.unit = unit;
		this.caloriesBurn = caloriesBurn;
		this.memberid = memberid;
	}
	public WorkoutRecords() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Workout getWorkout() {
		return workout;
	}
	public void setWorkout(Workout workout) {
		this.workout = workout;
	}
	public double getHighest() {
		return highest;
	}
	public void setHighest(double highest) {
		this.highest = highest;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	public Unit getUnit() {
		return unit;
	}
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	public int getCaloriesBurn() {
		return caloriesBurn;
	}
	public void setCaloriesBurn(int caloriesBurn) {
		this.caloriesBurn = caloriesBurn;
	}
	public int getMemberid() {
		return memberid;
	}
	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}
	@Override
	public String toString() {
		return "WorkoutRecords [id=" + id + ", workout=" + workout + ", highest=" + highest + ", average=" + average
				+ ", unit=" + unit + ", caloriesBurn=" + caloriesBurn + ", memberid=" + memberid + "]";
	}
	
	
}
