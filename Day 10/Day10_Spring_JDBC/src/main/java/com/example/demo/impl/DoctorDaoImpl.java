package com.example.demo.impl;

import java.util.List;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.Doctor;
import com.example.demo.ifaces.MyDao;

@Repository
public class DoctorDaoImpl implements MyDao<Doctor> {

	private JdbcTemplate template;
	
	public DoctorDaoImpl(JdbcTemplate template) {
		super();
		this.template = template;
	}
	
	@Override
	public List<Doctor> findAll(){
		List<Doctor> doctorList = null;
		String selectSql = "select * from doctor";
		doctorList =  template.query(selectSql,rowMapper());
				
//				(rs, rowNum) -> new Doctor(rs.getInt("doctorid"),rs.getString("doctorname"),rs.getString("department")));
		return doctorList;
	}

	@Override
	public boolean save(Doctor t) {
		String insertSql = "insert into doctor values(?,?,?);";
		return template.update(insertSql, t.doctorid(), t.doctorname(), t.department())==0?true:false;
	}
	
	private RowMapper<Doctor> rowMapper() {
	    return (rs, rowNum) ->{ 
//	    	System.out.println(rs.getMetaData().);
	    	System.out.println(rowNum + " hello");
	    	return new Doctor(rs.getInt("doctorid"),rs.getString("doctorname"),rs.getString("department"));
	    };
	}

	@Override
	public Doctor findById(int id) {
		String selectSql = "select * from doctor where doctorid = ?";
		Doctor doctor = template.queryForObject(selectSql, rowMapper(), id);
		return doctor;
	}

	
}
