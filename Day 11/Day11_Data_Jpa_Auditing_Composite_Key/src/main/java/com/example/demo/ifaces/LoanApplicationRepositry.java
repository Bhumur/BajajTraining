package com.example.demo.ifaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.LoanApplication;

@Repository
public interface LoanApplicationRepositry extends JpaRepository<LoanApplication, Integer> {

}
