package com.fitness.gym.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fitness.gym.entity.Member;
import com.fitness.gym.entity.Trainer;
import com.fitness.gym.entity.User;
import com.fitness.gym.service.MemberServiceImpl;

public class TrainerRepoImpl implements TrainerRepository<Trainer> {
	
	Connection con;

	public TrainerRepoImpl(Connection con) {
		this.con = con;
	}

	@Override
	public List<? extends User> getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Trainer a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Trainer a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Trainer a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(List<Trainer> list) {
		for(Trainer t : list) {
			add(t);
		}
		return true;
	}
	
	public List<Trainer> getAllTrainers(){
		List<Trainer> list = new ArrayList<>();
		String selectById = "select * from trainer";
		try {
			PreparedStatement ps = con.prepareStatement(selectById);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int trainerid = rs.getInt(1);
				String name = rs.getString(2);
				String email =	rs.getString(3);
				String password = rs.getString(4);
				int expirence = rs.getInt(5);
				List<Member> listMember = getAllMembersOfTrainerId(trainerid);
				Trainer trainer = new Trainer(trainerid, name, email, password, expirence , listMember);
				for(Member m : listMember) {
					m.setTrainer(trainer);
				}
				list.add(trainer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Trainer getById(int id) {
		String selectById = "select * from trainer where trainerid = ?";
		Trainer trainer = null;
		try {
			PreparedStatement ps = con.prepareStatement(selectById);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int trainerid = rs.getInt(1);
				String name = rs.getString(2);
				String email =	rs.getString(3);
				String password = rs.getString(4);
				int experince = rs.getInt(5);
				List<Member> list = getAllMembersOfTrainerId(trainerid);
				trainer = new Trainer(trainerid, name, email, password, experince , list);
				for(Member m : list) {
					m.setTrainer(trainer);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trainer;
	}
	
	public List<Member> getAllMembersOfTrainerId(int trainerId) {
		List<Member> list = new ArrayList<>();
		String selectById = "select * from member where trainerid = ?";
		try {
			PreparedStatement ps = con.prepareStatement(selectById);
			ps.setInt(1, trainerId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int memberid = rs.getInt(1);
				String name = rs.getString(2);
				String email =	rs.getString(3);
				String password = rs.getString(4);
				double weight = rs.getDouble(5);
				double height = rs.getDouble(6);
				int trainerid = rs.getInt(7);
				Trainer trainer = null;//trainerService.getTrainerByTrainerId(trainerid);
				Member member = new Member(memberid, name, email, password, weight, height, trainer, null, null, null);
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	

}
