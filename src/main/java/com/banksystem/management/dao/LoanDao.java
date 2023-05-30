package com.banksystem.management.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.banksystem.management.entity.Loan;
@Repository
public interface LoanDao extends JpaRepository<Loan, Integer> {
//
//	List<Loan> findByCustomer_ID(int customer_ID);
//    List<Loan> findByCustomer_ID(int customer_ID);
	
	
}

