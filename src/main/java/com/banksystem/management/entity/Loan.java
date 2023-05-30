package com.banksystem.management.entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "Loan")
public class Loan {
	
	@Id
    @Column(name = "Loan_ID")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "loan_generator")
    private int loanId;

    @Column(name = "Loan_Type")
    private String loanType;

    @Column(name = "Amount")
    private double amount;

    @Column(name = "Customer_ID")
    private int customerId;
    
    @Column(name = "Bank_ID")
    private int bankId;
    
    
    
    @ManyToOne( optional = false)
	  @OnDelete(action = OnDeleteAction.CASCADE)
	  @JoinColumn(name = "Customer_ID", nullable = false , insertable = false, updatable = false)
    	private Customer customer;
    
    
    @ManyToOne(optional = false)
	  @OnDelete(action = OnDeleteAction.CASCADE)
	  @JoinColumn(name = "Bank_ID", nullable = false , insertable = false, updatable = false)
    private Bank bank;

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	
	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	
	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Loan(int loanId, String loanType, double amount, int customerId, int bankId, Customer customer, Bank bank) {
		super();
		this.loanId = loanId;
		this.loanType = loanType;
		this.amount = amount;
		this.customerId = customerId;
		this.bankId = bankId;
		this.customer = customer;
		this.bank = bank;
	}
	
	
	

}
