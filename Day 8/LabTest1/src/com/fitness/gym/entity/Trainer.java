package com.fitness.gym.entity;

import java.util.List;
import java.util.Objects;

public class Trainer extends User {
	private int experience;
	private List<Member> members;
	
	public Trainer() {
		super();
	}
	public Trainer(int id, String name, String email, String password, int experience, List<Member> members) {
		super(id, name, email, password);
		this.experience = experience;
		this.members = members;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public List<Member> getMembers() {
		return members;
	}
	public void setMembers(List<Member> members) {
		this.members = members;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(experience, members);
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
		Trainer other = (Trainer) obj;
		return experience == other.experience && Objects.equals(members, other.members);
	}
	@Override
	public String toString() {
		return "Trainer [experience=" + experience + ", members=" + members + "]";
	}
	
	
	
}
