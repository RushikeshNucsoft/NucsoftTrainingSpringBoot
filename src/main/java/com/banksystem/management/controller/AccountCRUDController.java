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

import com.banksystem.management.dao.AccountDao;
import com.banksystem.management.entity.Account;

@RestController
@RequestMapping("/AccountCRUDApp")
public class AccountCRUDController {
	
	@Autowired
	private AccountDao accountRepository;
	
	@PostMapping("/CreateAccount")
	public Account createAccount(@RequestBody Account account) {
	    // Save the account object in the database
	    Account savedAccount = accountRepository.save(account);
	    return savedAccount;
	}

	
	@GetMapping("/accounts/{accountNo}")
	public ResponseEntity<Account> getAccountByAccountNo(@PathVariable(value = "accountNo") int accountNo) {
	    // Find the account by account number in the database
	    Optional<Account> optionalAccount = accountRepository.findById(accountNo);
	    
	    if (optionalAccount.isPresent()) {
	        // Account record found, return it as a response
	        Account account = optionalAccount.get();
	        return ResponseEntity.ok().body(account);
	    } else {
	        // Account record not found, return a not found response
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@PutMapping("/accounts/{accountNo}")
	public ResponseEntity<Account> updateAccount(@PathVariable(value = "accountNo") int accountNo, @RequestBody Account accountDetails) {
	    // Find the account by account number in the database
	    Optional<Account> optionalAccount = accountRepository.findById(accountNo);
	    
	    if (optionalAccount.isPresent()) {
	        // Account record found, update its details
	        Account account = optionalAccount.get();
	        account.setAccountType(accountDetails.getAccountType());
	        account.setBalance(accountDetails.getBalance());
	        account.setCustomerId(accountDetails.getCustomerId());
	        account.setBranchId(accountDetails.getBranchId());
	        account.setBankId(accountDetails.getBankId());
	        
	        // Save the updated account object in the database
	        Account updatedAccount = accountRepository.save(account);
	        return ResponseEntity.ok().body(updatedAccount);
	    } else {
	        // Account record not found, return a not found response
	        return ResponseEntity.notFound().build();
	    }
	}

	
	@DeleteMapping("/accounts/{accountNo}")
	public ResponseEntity<Void> deleteAccount(@PathVariable(value = "accountNo") int accountNo) {
	    // Find the account by account number in the database
	    Optional<Account> optionalAccount = accountRepository.findById(accountNo);
	    
	    if (optionalAccount.isPresent()) {
	        // Account record found, delete it from the database
	        accountRepository.delete(optionalAccount.get());
	        return ResponseEntity.noContent().build();
	    } else {
	        // Account record not found, return a not found response
	        return ResponseEntity.notFound().build();
	    }
	}


}
