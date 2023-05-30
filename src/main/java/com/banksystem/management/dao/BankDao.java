package com.banksystem.management.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.banksystem.management.entity.Bank;
import com.banksystem.management.entity.Loan;
@Repository
public interface BankDao extends JpaRepository<Bank, Integer>{
	
	 @Query("SELECT l FROM Loan l WHERE l.bank.bankId = :bankId")
	    List<Loan> findLoansByBankId(@Param("bankId") Integer bankId);
	
	

}
