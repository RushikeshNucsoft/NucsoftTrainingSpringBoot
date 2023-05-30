package com.banksystem.management.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;



@Entity
@Table(name="Bank")
public class Bank {
	
	@Id
	@Column(name = "Bank_ID")
	private int bankId;
	
	@Column(name = "Bank_Name")
	private String bankName;
	
	@Column(name = "Bank_Code")
	private String bankCode;
	
	@Column(name = "Bank_Address")
	private String bankAddress;

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankAddress() {
		return bankAddress;
	}

	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}

	public Bank(int bankId, String bankName, String bankCode, String bankAddress) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
		this.bankCode = bankCode;
		this.bankAddress = bankAddress;
	}

	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	
}

