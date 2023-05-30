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

import com.banksystem.management.dao.BankDao;
import com.banksystem.management.entity.Bank;

@RestController
@RequestMapping("/BankCRUDApp")
public class BankCRUDController {
	
	@Autowired
	private BankDao bankDao;

	@PostMapping("/addBanks")
	public Bank createBank(@RequestBody Bank bank) {
	    // Save the bank object in the database
	    Bank savedBank = bankDao.save(bank);
	    return savedBank;
	}
	
	@GetMapping("/banks/{id}")
	public ResponseEntity<Bank> getBankById(@PathVariable(value = "id") int bankId) {
	    // Find the bank by ID in the database
	    Optional<Bank> optionalBank = bankDao.findById(bankId);
	    
	    if (optionalBank.isPresent()) {
	        // Bank record found, return it as a response
	        Bank bank = optionalBank.get();
	        return ResponseEntity.ok().body(bank);
	    } else {
	        // Bank record not found, return a not found response
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@PutMapping("/banks/{id}")
	public ResponseEntity<Bank> updateBank(@PathVariable(value = "id") int bankId, @RequestBody Bank bankDetails) {
	    // Find the bank by ID in the database
	    Optional<Bank> optionalBank = bankDao.findById(bankId);
	    
	    if (optionalBank.isPresent()) {
	        // Bank record found, update its details
	        Bank bank = optionalBank.get();
	        bank.setBankName(bankDetails.getBankName());
	        bank.setBankCode(bankDetails.getBankCode());
	        bank.setBankAddress(bankDetails.getBankAddress());
	        
	        // Save the updated bank object in the database
	        Bank updatedBank = bankDao.save(bank);
	        return ResponseEntity.ok().body(updatedBank);
	    } else {
	        // Bank record not found, return a not found response
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@DeleteMapping("/banks/{id}")
	public ResponseEntity<Void> deleteBank(@PathVariable(value = "id") int bankId) {
	    // Find the bank by ID in the database
	    Optional<Bank> optionalBank = bankDao.findById(bankId);
	    
	    if (optionalBank.isPresent()) {
	        // Bank record found, delete it from the database
	    	bankDao.delete(optionalBank.get());
	        return ResponseEntity.noContent().build();
	    } else {
	        // Bank record not found, return a not found response
	        return ResponseEntity.notFound().build();
	    }
	}

	


}
