/*************************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
**************************************************************************************/
package br.com.bytebank.Model;

import java.io.Serializable;
import java.util.Date;

public class AccountModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int AccountCode;
	private String AccountStatus; 
	private String AccountType; 
	private double AccountAmount; 
	private String AccountCurrency; 
	private String AccountOpenDate; 
	private String AccountCloseDate; 
	private int AccountBank; 
	private int AccountBranch; 
	private int AccountPackage; 
	private int AccountEmployee;
	
	public AccountModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountModel(int accountCode, String accountStatus, String accountType, double accountAmount,
			String accountCurrency, String accountOpenDate, String accountCloseDate, int accountBank, int accountBranch,
			int accountPackage, int accountEmployee) {
		super();
		AccountCode = accountCode;
		AccountStatus = accountStatus;
		AccountType = accountType;
		AccountAmount = accountAmount;
		AccountCurrency = accountCurrency;
		AccountOpenDate = accountOpenDate;
		AccountCloseDate = accountCloseDate;
		AccountBank = accountBank;
		AccountBranch = accountBranch;
		AccountPackage = accountPackage;
		AccountEmployee = accountEmployee;
	}

	public int getAccountCode() {
		return AccountCode;
	}

	public void setAccountCode(int accountCode) {
		AccountCode = accountCode;
	}

	public String getAccountStatus() {
		return AccountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		AccountStatus = accountStatus;
	}

	public String getAccountType() {
		return AccountType;
	}

	public void setAccountType(String accountType) {
		AccountType = accountType;
	}

	public double getAccountAmount() {
		return AccountAmount;
	}

	public void setAccountAmount(double accountAmount) {
		AccountAmount = accountAmount;
	}

	public String getAccountCurrency() {
		return AccountCurrency;
	}

	public void setAccountCurrency(String accountCurrency) {
		AccountCurrency = accountCurrency;
	}

	public String getAccountOpenDate() {
		return AccountOpenDate;
	}

	public void setAccountOpenDate(String accountOpenDate) {
		AccountOpenDate = accountOpenDate;
	}

	public String getAccountCloseDate() {
		return AccountCloseDate;
	}

	public void setAccountCloseDate(String accountCloseDate) {
		AccountCloseDate = accountCloseDate;
	}

	public int getAccountBank() {
		return AccountBank;
	}

	public void setAccountBank(int accountBank) {
		AccountBank = accountBank;
	}

	public int getAccountBranch() {
		return AccountBranch;
	}

	public void setAccountBranch(int accountBranch) {
		AccountBranch = accountBranch;
	}

	public int getAccountPackage() {
		return AccountPackage;
	}

	public void setAccountPackage(int accountPackage) {
		AccountPackage = accountPackage;
	}

	public int getAccountEmployee() {
		return AccountEmployee;
	}

	public void setAccountEmployee(int accountEmployee) {
		AccountEmployee = accountEmployee;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
