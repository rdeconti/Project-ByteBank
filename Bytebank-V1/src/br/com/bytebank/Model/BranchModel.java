/*************************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
**************************************************************************************/
package br.com.bytebank.Model;

public class BranchModel {
	
	private int BranchCode; 
	private char BranchStatus; 
	private String BranchName; 
	private int BranchAddress; 
	private int BranchContact; 
	private int BranchEmployee; 
	private int BranchBank;
	
	public BranchModel() {
	}
	
	private int getBranchCode() {
		return BranchCode;
	}
	
	private void setBranchCode(int branchCode) {
		BranchCode = branchCode;
	}
	
	private char getBranchStatus() {
		return BranchStatus;
	}
	
	private void setBranchStatus(char branchStatus) {
		BranchStatus = branchStatus;
	}
	
	private String getBranchName() {
		return BranchName;
	}
	
	private void setBranchName(String branchName) {
		BranchName = branchName;
	}
	
	private int getBranchAddress() {
		return BranchAddress;
	}
	
	private void setBranchAddress(int branchAddress) {
		BranchAddress = branchAddress;
	}
	private int getBranchContact() {
		return BranchContact;
	}
	private void setBranchContact(int branchContact) {
		BranchContact = branchContact;
	}
	
	private int getBranchEmployee() {
		return BranchEmployee;
	}
	
	private void setBranchEmployee(int branchEmployee) {
		BranchEmployee = branchEmployee;
	}
	
	private int getBranchBank() {
		return BranchBank;
	}
	
	private void setBranchBank(int branchBank) {
		BranchBank = branchBank;
	}
	
	

}
