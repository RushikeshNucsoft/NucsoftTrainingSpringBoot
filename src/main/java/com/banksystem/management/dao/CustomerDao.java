package com.banksystem.management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.banksystem.management.entity.Customer;
import com.banksystem.management.entity.Loan;
@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{
	
	Optional<Customer> findByCustomerId(int customerId);

	 @Query("SELECT l FROM Loan l WHERE l.customer.customerId = :customerId")
	    List<Loan> findLoansByCustomerId(@Param("customerId") int customerId);

}
