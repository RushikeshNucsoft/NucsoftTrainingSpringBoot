package com.banksystem.management.controller;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banksystem.management.dao.BankDao;
import com.banksystem.management.dao.CustomerDao;
import com.banksystem.management.dao.LoanDao;
import com.banksystem.management.entity.Customer;
import com.banksystem.management.entity.Loan;
import com.banksystem.management.exception.BankNotFoundException;
import com.banksystem.management.service.BankService;
import com.banksystem.management.entity.Account;
import com.banksystem.management.entity.Bank;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.Metamodel;



@RestController
@RequestMapping("/BankDBApp")
public class BankController implements Serializable {

	@Autowired
	private BankService bankService;

	@Autowired
	private LoanDao loanDao;

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private BankDao bankDao;

	@GetMapping("/AllLoans")
	public List<Loan> getLoans() {
		return loanDao.findAll();

	}

	@GetMapping("/AllCustomers")
	public List<Customer> getCustomer() {
		return customerDao.findAll();

	}
	
	@PostMapping("/createLoans")
	public ResponseEntity<Loan> createLoan(@RequestBody Loan loan) {
	    try {
	        Loan createdLoan = loanDao.save(loan);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdLoan);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}

	
	@GetMapping("/customer/{customerId}/loans")
    public List<Loan> getLoansByCustomerId(@PathVariable int customerId) {
        return bankService.getLoansByCustomerId(customerId);
    }
	
	@PersistenceContext
    private EntityManager entityManager;

	@GetMapping("/loan/types")
	 public List<String> getLoanTypes() {
	        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
	        CriteriaQuery<String> query = criteriaBuilder.createQuery(String.class);
	        Metamodel metamodel = entityManager.getMetamodel();
	        EntityType<Loan> loanEntityType = metamodel.entity(Loan.class);
	        Root<Loan> root = query.from(loanEntityType);
	        query.select(root.get("loanType")).distinct(true);
	        TypedQuery<String> typedQuery = entityManager.createQuery(query);
	        return typedQuery.getResultList();
	    }
	
	
//	@RestController
//	@RequestMapping("/accounts")
//	public class AccountController {

	   

		@PostMapping(path="/addAccount")
	    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
	        Account createdAccount = bankService.createAccount(account);
	        return ResponseEntity.ok(createdAccount);
	    }
		
		@PostMapping(path="/addCustomer")
	    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
			Customer createdCustomer = bankService.createCustomer(customer);
	        return ResponseEntity.ok(createdCustomer);
	    }
		
		@GetMapping("/{customerId}/loans")
	    public ResponseEntity<List<Loan>> getCustomerLoans(@PathVariable("customerId") int customerId) {
	      
//			Optional<Customer> customer = customerDao.findById(customerId);
//		
//	        if (customer == null) {
//	            return ResponseEntity.notFound().build();
//	        }
	        List<Loan> loans = customerDao.findLoansByCustomerId(customerId);
	       
	        if (loans.isEmpty()) {
	            return ResponseEntity.noContent().build();
	        }
	        return ResponseEntity.ok(loans);
	    }
		
		
		@GetMapping("/{bankId}/loantypes")
		public Set<String> getUniqueLoanTypesByBank(@PathVariable int bankId) {
		    Bank bank = bankDao.findById(bankId).orElse(null);
		    if (bank != null) {
		        List<Loan> loans = bankDao.findLoansByBankId(bankId);
		        Set<String> loanTypes = new HashSet<>();
		        for (Loan loan : loans) {
		            loanTypes.add(loan.getLoanType());
		        }
		        return loanTypes;
		    } else {
		        // Handle case when bank is not found
		        throw new BankNotFoundException("Bank not found");
		    }
		}


	}
	

	
//	 @GetMapping("/customer/{customerId}") public List<Loan>
//	 getLoanByCustomerId(@PathVariable int customer_ID) {
//		 
//		 return bankService.getLoanByCustomerId(customer_ID); }
	 

 //}
