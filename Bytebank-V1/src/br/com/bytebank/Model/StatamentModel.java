/*************************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
**************************************************************************************/
package br.com.bytebank.Model;

import java.util.Date;

public class StatamentModel {
	
	private int StatamentCode;
	private char StatamentStatus;
	private char StatamentType;
	private int StatamentBank;
	private int StatamentBranch;
	private int StatamentAccount;
	private int StatamentCustomer;
	private double StatamentAmount;
	private int StatamentCurrency;
	private Date StatamentDate;
	
	public StatamentModel() {
	}
	
	private int getStatamentCode() {
		return StatamentCode;
	}
	
	private void setStatamentCode(int statamentCode) {
		StatamentCode = statamentCode;
	}
	
	private char getStatamentStatus() {
		return StatamentStatus;
	}
	
	private void setStatamentStatus(char statamentStatus) {
		StatamentStatus = statamentStatus;
	}
	
	private char getStatamentType() {
		return StatamentType;
	}
	
	private void setStatamentType(char statamentType) {
		StatamentType = statamentType;
	}
	
	private int getStatamentBank() {
		return StatamentBank;
	}
	
	private void setStatamentBank(int statamentBank) {
		StatamentBank = statamentBank;
	}
	
	private int getStatamentBranch() {
		return StatamentBranch;
	}
	
	private void setStatamentBranch(int statamentBranch) {
		StatamentBranch = statamentBranch;
	}
	
	private int getStatamentAccount() {
		return StatamentAccount;
	}
	
	private void setStatamentAccount(int statamentAccount) {
		StatamentAccount = statamentAccount;
	}
	
	private int getStatamentCustomer() {
		return StatamentCustomer;
	}
	
	private void setStatamentCustomer(int statamentCustomer) {
		StatamentCustomer = statamentCustomer;
	}
	
	private double getStatamentAmount() {
		return StatamentAmount;
	}
	
	private void setStatamentAmount(double statamentAmount) {
		StatamentAmount = statamentAmount;
	}
	
	private int getStatamentCurrency() {
		return StatamentCurrency;
	}
	
	private void setStatamentCurrency(int statamentCurrency) {
		StatamentCurrency = statamentCurrency;
	}
	
	private Date getStatamentDate() {
		return StatamentDate;
	}
	
	private void setStatamentDate(Date statamentDate) {
		StatamentDate = statamentDate;
	}
	
	

}
