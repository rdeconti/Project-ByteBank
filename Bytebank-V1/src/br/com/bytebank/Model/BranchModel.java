/*************************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
**************************************************************************************/
package br.com.bytebank.Model;

import java.io.Serializable;

public class BranchModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int BranchCode; 
	private String BranchStatus; 
	private String BranchName; 
	private int BranchAddress; 
	private int BranchContact; 
	private int BranchEmployee; 
	private int BranchBank;
	
	public BranchModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BranchModel(int branchCode, String branchStatus, String branchName, int branchAddress, int branchContact,
			int branchEmployee, int branchBank) {
		super();
		BranchCode = branchCode;
		BranchStatus = branchStatus;
		BranchName = branchName;
		BranchAddress = branchAddress;
		BranchContact = branchContact;
		BranchEmployee = branchEmployee;
		BranchBank = branchBank;
	}

	public int getBranchCode() {
		return BranchCode;
	}

	public void setBranchCode(int branchCode) {
		BranchCode = branchCode;
	}

	public String getBranchStatus() {
		return BranchStatus;
	}

	public void setBranchStatus(String branchStatus) {
		BranchStatus = branchStatus;
	}

	public String getBranchName() {
		return BranchName;
	}

	public void setBranchName(String branchName) {
		BranchName = branchName;
	}

	public int getBranchAddress() {
		return BranchAddress;
	}

	public void setBranchAddress(int branchAddress) {
		BranchAddress = branchAddress;
	}

	public int getBranchContact() {
		return BranchContact;
	}

	public void setBranchContact(int branchContact) {
		BranchContact = branchContact;
	}

	public int getBranchEmployee() {
		return BranchEmployee;
	}

	public void setBranchEmployee(int branchEmployee) {
		BranchEmployee = branchEmployee;
	}

	public int getBranchBank() {
		return BranchBank;
	}

	public void setBranchBank(int branchBank) {
		BranchBank = branchBank;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
