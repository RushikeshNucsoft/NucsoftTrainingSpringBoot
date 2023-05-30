package com.banksystem.management.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "Bank_Customer")
public class Customer {
	
	@Id
	@Column(name = "Customer_ID")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "customer_generator")
	private int customerId;
	
	@Column(name = "Customer_Name")
	private String customerName;
	
	@Column(name = "Customer_Phone")
	private String customerPhone;
	
	@Column(name = "Customer_Address")
	private String customerAddress;
	
	@Column(name = "Branch_Name")
	private String branchName;
	
	
	@Column(name = "Branch_ID")
	private int branchId;
	
	@Column(name = "Bank_Name")
	private String bankName;
	
	@Column(name = "Bank_ID")
	private int bankId;
	
	@Column(name = "Loan_ID")
	private int loanId;
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}



	public Customer(int customerId, String customerName, String customerPhone, String customerAddress,
			String branchName, int branchId, String bankName, int bankId, int loanId) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.customerAddress = customerAddress;
		this.branchName = branchName;
		this.branchId = branchId;
		this.bankName = bankName;
		this.bankId = bankId;
		this.loanId = loanId;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
