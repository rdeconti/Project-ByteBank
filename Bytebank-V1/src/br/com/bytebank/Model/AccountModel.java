/*************************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
**************************************************************************************/
package br.com.bytebank.Model;

import java.util.Date;

public class AccountModel {
	
	private int AccountCode;
	private char AccountStatus; 
	private char AccountType; 
	private double AccountAmount; 
	private int AccountCurrency; 
	private Date AccountOpenDate; 
	private Date AccountCloseDate; 
	private int AccountBank; 
	private int AccountBranch; 
	private int AccountPackage; 
	private int AccountEmployee;
	
	public AccountModel() {
	}

	private int getAccountCode() {
		return AccountCode;
	}

	private void setAccountCode(int accountCode) {
		AccountCode = accountCode;
	}

	private char getAccountStatus() {
		return AccountStatus;
	}

	private void setAccountStatus(char accountStatus) {
		AccountStatus = accountStatus;
	}

	private char getAccountType() {
		return AccountType;
	}

	private void setAccountType(char accountType) {
		AccountType = accountType;
	}

	private double getAccountAmount() {
		return AccountAmount;
	}

	private void setAccountAmount(double accountAmount) {
		AccountAmount = accountAmount;
	}

	private int getAccountCurrency() {
		return AccountCurrency;
	}

	private void setAccountCurrency(int accountCurrency) {
		AccountCurrency = accountCurrency;
	}

	private Date getAccountOpenDate() {
		return AccountOpenDate;
	}

	private void setAccountOpenDate(Date accountOpenDate) {
		AccountOpenDate = accountOpenDate;
	}

	private Date getAccountCloseDate() {
		return AccountCloseDate;
	}

	private void setAccountCloseDate(Date accountCloseDate) {
		AccountCloseDate = accountCloseDate;
	}

	private int getAccountBank() {
		return AccountBank;
	}

	private void setAccountBank(int accountBank) {
		AccountBank = accountBank;
	}

	private int getAccountBranch() {
		return AccountBranch;
	}

	private void setAccountBranch(int accountBranch) {
		AccountBranch = accountBranch;
	}

	private int getAccountPackage() {
		return AccountPackage;
	}

	private void setAccountPackage(int accountPackage) {
		AccountPackage = accountPackage;
	}

	private int getAccountEmployee() {
		return AccountEmployee;
	}

	private void setAccountEmployee(int accountEmployee) {
		AccountEmployee = accountEmployee;
	}
	
	

}
