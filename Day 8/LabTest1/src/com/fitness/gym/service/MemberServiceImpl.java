package com.fitness.gym.service;

import java.sql.Connection;
import java.util.List;

import com.fitness.gym.entity.Member;
import com.fitness.gym.entity.Trainer;
import com.fitness.gym.exceptions.DuplicateIdException;
import com.fitness.gym.repository.MemberRepoImpl;

public class MemberServiceImpl {
	
	private MemberRepoImpl repo;
	 
	public MemberServiceImpl(Connection con) {
		this.repo = new MemberRepoImpl(con);
	}
	
	public boolean addMember(int id, String name, String email, String password, double weight, double height, Trainer trainer) throws DuplicateIdException {
		Member member = new Member(id, name, email, password, weight, height,trainer , null, null, null);
		return repo.add(member);
	}
	
	public Member getMemberById(int id) {
		return repo.getById(id);
	}
	
	public List<Member> getAllMemberByTrainerId(int trainerId){
		return repo.getAllMembersOfTrainerId(trainerId);
	}
	
	public List<Member> getAllMembers(){
		System.out.println("is srevice");
		return repo.getAll();
	}
}
