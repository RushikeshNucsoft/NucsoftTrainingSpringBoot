package com.banksystem.management.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Account")
public class Account {
	
	@Id
	@Column(name = "Account_No")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "account_generator")
	private int accountNo;
	
	@Column(name = "Account_Type")
	private String accountType;
	
	@Column(name = "Balance")
	private double balance;
	
	@Column(name = "Customer_ID")
	private int customerId;
	
	@Column(name = "Branch_ID")
	private int branchId;
	
	@Column(name = "Bank_ID")
	private int bankId;

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public Account(int accountNo, String accountType, double balance, int customerId, int branchId, int bankId) {
		super();
		this.accountNo = accountNo;
		this.accountType = accountType;
		this.balance = balance;
		this.customerId = customerId;
		this.branchId = branchId;
		this.bankId = bankId;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
