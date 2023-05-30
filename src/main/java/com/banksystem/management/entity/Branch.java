package com.banksystem.management.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Branch {
	
	@Id
	@Column(name = "Branch_ID")
	private int Branch_ID;
	
	@Column(name = "Branch_Name")
	private String Branch_Name;
	
	@Column(name = "Branch_Code")
	private String Branch_Code;
	
	@Column(name = "Branch_Address")
	private String Branch_Address;
	
	@Column(name = "Bank_Name")
	private String Bank_Name;
	
	@Column(name = "Bank_ID")
	private int Bank_ID;
	
	
	public int getBranch_ID() {
		return Branch_ID;
	}
	public void setBranch_ID(int branch_ID) {
		Branch_ID = branch_ID;
	}
	public String getBranch_Name() {
		return Branch_Name;
	}
	public void setBranch_Name(String branch_Name) {
		Branch_Name = branch_Name;
	}
	public String getBranch_Code() {
		return Branch_Code;
	}
	public void setBranch_Code(String branch_Code) {
		Branch_Code = branch_Code;
	}
	public String getBranch_Address() {
		return Branch_Address;
	}
	public void setBranch_Address(String branch_Address) {
		Branch_Address = branch_Address;
	}
	public String getBank_Name() {
		return Bank_Name;
	}
	public void setBank_Name(String bank_Name) {
		Bank_Name = bank_Name;
	}
	public int getBank_ID() {
		return Bank_ID;
	}
	public void setBank_ID(int bank_ID) {
		Bank_ID = bank_ID;
	}
	
	
	public Branch(int branch_ID, String branch_Name, String branch_Code, String branch_Address, String bank_Name,
			int bank_ID) {
		super();
		Branch_ID = branch_ID;
		Branch_Name = branch_Name;
		Branch_Code = branch_Code;
		Branch_Address = branch_Address;
		Bank_Name = bank_Name;
		Bank_ID = bank_ID;
	}
	
	public Branch() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

