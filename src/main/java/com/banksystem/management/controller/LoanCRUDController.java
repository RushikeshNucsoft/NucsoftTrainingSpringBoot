package com.banksystem.management.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banksystem.management.dao.LoanDao;
import com.banksystem.management.entity.Loan;

@RestController
@RequestMapping("/LoanCRUDApp")
public class LoanCRUDController {
	
	@Autowired
	private LoanDao loanDao;
	
	@PostMapping("/CreateLoans")
	public Loan createLoan(@RequestBody Loan loan) {
	    // Save the loan object in the database
	    Loan savedLoan = loanDao.save(loan);
	    return savedLoan;
	}
	
	@GetMapping("/loans/{id}")
	public ResponseEntity<Loan> getLoanById(@PathVariable(value = "id") int loanId) {
	    // Find the loan by ID in the database
	    Optional<Loan> optionalLoan = loanDao.findById(loanId);
	    
	    if (optionalLoan.isPresent()) {
	        // Loan record found, return it as a response
	        Loan loan = optionalLoan.get();
	        return ResponseEntity.ok().body(loan);
	    } else {
	        // Loan record not found, return a not found response
	        return ResponseEntity.notFound().build();
	    }
	}

	@PutMapping("/loans/{id}")
	public ResponseEntity<Loan> updateLoan(@PathVariable(value = "id") int loanId, @RequestBody Loan loanDetails) {
	    // Find the loan by ID in the database
	    Optional<Loan> optionalLoan = loanDao.findById(loanId);
	    
	    if (optionalLoan.isPresent()) {
	        // Loan record found, update its details
	        Loan loan = optionalLoan.get();
	        loan.setLoanType(loanDetails.getLoanType());
	        loan.setAmount(loanDetails.getAmount());
	        loan.setCustomerId(loanDetails.getCustomerId());
	        
	        // Save the updated loan object in the database
	        Loan updatedLoan = loanDao.save(loan);
	        return ResponseEntity.ok().body(updatedLoan);
	    } else {
	        // Loan record not found, return a not found response
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@DeleteMapping("/loans/{id}")
	public ResponseEntity<Void> deleteLoan(@PathVariable(value = "id") int loanId) {
	    // Find the loan by ID in the database
	    Optional<Loan> optionalLoan = loanDao.findById(loanId);
	    
	    if (optionalLoan.isPresent()) {
	        // Loan record found, delete it from the database
	    	loanDao.delete(optionalLoan.get());
	        return ResponseEntity.noContent().build();
	    } else {
	        // Loan record not found, return a not found response
	        return ResponseEntity.notFound().build();
	    }
	}




}
