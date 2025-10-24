package com.example.demo.entity;

import org.springframework.context.annotation.Primary;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "professor")
@PrimaryKeyJoinColumn(name = "teacher_id")
public class Professor extends Teacher {

	private int profId;

	public Professor() {
		super();
	}

	public Professor(int teacherId, int profId) {
		super(teacherId);
		this.profId = profId;
	}

	public int getProfId() {
		return profId;
	}

	public void setProfId(int profId) {
		this.profId = profId;
	}

	@Override
	public String toString() {
		return super.toString() + " Professor [profId=" + profId + "]";
	}
	
	
	
	
}
