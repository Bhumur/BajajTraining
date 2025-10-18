package com.fitness.gym.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.fitness.gym.entity.Member;
import com.fitness.gym.entity.Trainer;
import com.fitness.gym.entity.User;
import com.fitness.gym.entity.WorkoutRecords;
import com.fitness.gym.exceptions.DuplicateIdException;
import com.fitness.gym.exceptions.MemberNotFoundException;
import com.fitness.gym.model.Exercies;
import com.fitness.gym.model.Food;
import com.fitness.gym.model.Unit;
import com.fitness.gym.model.Workout;
import com.fitness.gym.service.TrainerServiceImpl;

public class MemberRepoImpl implements MemberRepositry<Member> {

	Connection con;
	TrainerServiceImpl trainerService;
	
	public MemberRepoImpl(Connection connection) {
		this.con = connection;
		this.trainerService = new TrainerServiceImpl(con);
	}
	
	@Override
	public List<? extends User> getByName(String nameOfMember) {
		List<Member> list = new ArrayList<>();
		String selectById = "select * from member where membername = ?";
		try {
			PreparedStatement ps = con.prepareStatement(selectById);
			ps.setString(1, nameOfMember);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int memberid = rs.getInt(1);
				String name = rs.getString(2);
				String email =	rs.getString(3);
				String password = rs.getString(4);
				double weight = rs.getDouble(5);
				double height = rs.getDouble(6);
				int trainerid = rs.getInt(7);
				Trainer trainer = trainerService.getTrainerByTrainerId(trainerid);
				Member member = new Member(memberid, name, email, password, weight, height, trainer, null, null, null);
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Member getByEmail(String emailOfMember) {
		List<Member> list = new ArrayList<>();
		String selectById = "select * from member where memberemail = ?";
		Member member = null;
		try {
			PreparedStatement ps = con.prepareStatement(selectById);
			ps.setString(1, emailOfMember);
			getMemberListByPreparedStatement(list, ps);
			member = list.get(0);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}
	

	@Override
	public boolean add(Member a) throws DuplicateIdException {
		if(isMemberByIdPresent(a.getId()))
			throw new DuplicateIdException("Id Already present");
		String insertSql = "insert into member values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(insertSql);
			ps.setInt(1, a.getId());
			ps.setString(2, a.getName());
			ps.setString(3, a.getEmail());
			ps.setString(4, a.getPassword());
			ps.setDouble(5, a.getWeight());
			ps.setDouble(6, a.getHeight());
			ps.setInt(7, a.getTrainer().getId());
			if(ps.execute()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean remove(Member a) throws MemberNotFoundException {
		if(!isMemberByIdPresent(a.getId()))
			throw new MemberNotFoundException("No Member Present With Id : " + a.getId());
		String removeSql = "delete from member where memberid = ?";
		try {
			PreparedStatement ps = con.prepareStatement(removeSql);
			ps.setInt(1, a.getId());
			if(ps.execute()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Member a) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean isMemberByIdPresent(int id) {
		String selectById = "select * from member where memberid = ?";
		try {
			PreparedStatement ps = con.prepareStatement(selectById);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public Member getById(int id) {
		List<Member> list = new ArrayList<>();
		String selectById = "select * from member where memberid = ?";
		Member member = null;
		try {
			PreparedStatement ps = con.prepareStatement(selectById);
			ps.setInt(1, id);
			getMemberListByPreparedStatement(list, ps);
			member = list.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}

	
	@Override
	public boolean addAll(List<Member> list) {
		for(Member m : list) {
			try {
				add(m);
			} catch (DuplicateIdException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public List<Member> getAll(){
		List<Member> list = new ArrayList<>();
		String selectById = "select * from member";
		try {
			PreparedStatement ps = con.prepareStatement(selectById);
			getMemberListByPreparedStatement(list, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Trainer getTrainerOfMember(int id) {
		return getById(id).getTrainer();
	}

	@Override
	public Map<Workout, List<WorkoutRecords>> getWorkoutTracking(int memberid) {
		List<WorkoutRecords> list = new ArrayList<>();
		Map<Workout, List<WorkoutRecords>> ans = null;
		String selectById = "select * from workoutrecord where memberid = ?";
		try {
			PreparedStatement ps = con.prepareStatement(selectById);
			ps.setInt(1, memberid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int workoutrecordid = rs.getInt(1);
				Workout workout = Workout.valueOf(rs.getString(2));
				double highest = rs.getDouble(3);
				double average = rs.getDouble(4);
				Unit unit = Unit.valueOf(rs.getString(5));
				int calorieburn = rs.getInt(6);
				WorkoutRecords w = new WorkoutRecords(workoutrecordid, workout, highest, average, unit, calorieburn, memberid);
				list.add(w);
			}
			ans = list.stream()
					.collect(Collectors.groupingBy(WorkoutRecords::getWorkout));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ans;
	}

	@Override
	public List<Member> getAllMembersOfTrainerId(int trainerId) {
		List<Member> list = new ArrayList<>();
		String selectById = "select * from member where trainerid = ?";
		try {
			PreparedStatement ps = con.prepareStatement(selectById);
			ps.setInt(1, trainerId);
			getMemberListByPreparedStatement(list, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	private void getMemberListByPreparedStatement(List<Member> list, PreparedStatement ps) throws SQLException {
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int memberid = rs.getInt(1);
			String name = rs.getString(2);
			String email =	rs.getString(3);
			String password = rs.getString(4);
			double weight = rs.getDouble(5);
			double height = rs.getDouble(6);
			int trainerid = rs.getInt(7);
			Trainer trainer = trainerService.getTrainerByTrainerId(trainerid);
			Member member = new Member(memberid, name, email, password, weight, height, trainer, null, null, null);
			Map<Workout, List<WorkoutRecords>> map = getWorkoutTracking(memberid);
			Set<Exercies> exercises = getExercise(memberid);
			Set<Food> food = getFood(memberid);
			member.setWorkoutTracking(map);
			member.setExercises(exercises);
			member.setFood(food);
			list.add(member);
		}
	}

	private Set<Food> getFood(int memberid) {
		String selectSql = "select * from food where memberid = ?";
		Set<Food> foods = new HashSet<>();
		try {
			PreparedStatement ps = con.prepareStatement(selectSql);
			ps.setInt(1, memberid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Food food = Food.valueOf(rs.getString(2));
				foods.add(food);
			}
		}catch(SQLException e) {
				e.printStackTrace();
		}
		return foods;
	}

	private Set<Exercies> getExercise(int memberid) {
		String selectSql = "select * from exercise where memberid = ?";
		Set<Exercies> set = new HashSet<>();
		try {
			PreparedStatement ps = con.prepareStatement(selectSql);
			ps.setInt(1, memberid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Exercies ex = Exercies.valueOf(rs.getString(2));
				set.add(ex);
			}
		}catch(SQLException e) {
				e.printStackTrace();
		}
		return set;
	}
	

	
}
