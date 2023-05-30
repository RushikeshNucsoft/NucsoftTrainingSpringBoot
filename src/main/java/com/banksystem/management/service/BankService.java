package com.banksystem.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banksystem.management.dao.AccountDao;
import com.banksystem.management.dao.CustomerDao;
import com.banksystem.management.dao.LoanDao;
import com.banksystem.management.entity.Account;
import com.banksystem.management.entity.Customer;
import com.banksystem.management.entity.Loan;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;



@Service
public class BankService  {

	 @Autowired
	private LoanDao loanDao;
	 
	 @Autowired
	 private AccountDao accountDao;
	 
	 @Autowired
	 private CustomerDao customerDao;
	 
	 public List<Loan> getLoan()
	 {
		 return loanDao.findAll();
	 }
	 
	 
	  @PersistenceContext
	    private EntityManager entityManager;

	  public List<Loan> getLoansByCustomerId(int customerId) {
		    String jpql = "SELECT l FROM Loan l WHERE l.customerId = :customerId";
		    TypedQuery<Loan> query = entityManager.createQuery(jpql, Loan.class);
		    query.setParameter("customerId", customerId);
		    return query.getResultList();
		}
	  
	 
	  public Account createAccount(Account account) {
	        return accountDao.save(account);
	    }

	  
	  public Customer createCustomer(Customer customer) {
	        return customerDao.save(customer);
	    }
//	public List<Loan> getLoanByCustomerId(int customer_ID) {
//		// TODO Auto-generated method stub
//		return  (customer_ID);
//	}


	 
		
//		 public List<Loan> getLoanByCustomerId(int customer_ID) { return
//		  loanDao.findByCustomer_ID(customer_ID); }
		 		
		//step- 2
		//return courseDao.getOne(id);
	
	
}
