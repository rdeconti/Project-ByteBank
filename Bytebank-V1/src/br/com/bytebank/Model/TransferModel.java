/*************************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
**************************************************************************************/
package br.com.bytebank.Model;

import java.util.Date;

public class TransferModel {
	
	private int TransferCode;
	private char TransferStatus;
	private int TransferFromBank;
	private int TransferFromBranch;
	private int TransferFromAccount;
	private int TransferFromCustomer;
	private int TransferToBank;
	private int TransferToBranch;
	private int TransferToAccount;
	private int TransferToCustomer;
	private double TransferAmount;
	private int TransferCurrency;
	private Date TransferDate;
	
	public TransferModel() {
	}
	
	private int getTransferCode() {
		return TransferCode;
	}
	
	private void setTransferCode(int transferCode) {
		TransferCode = transferCode;
	}
	
	private char getTransferStatus() {
		return TransferStatus;
	}
	
	private void setTransferStatus(char transferStatus) {
		TransferStatus = transferStatus;
	}
	
	private int getTransferFromBank() {
		return TransferFromBank;
	}
	
	private void setTransferFromBank(int transferFromBank) {
		TransferFromBank = transferFromBank;
	}
	
	private int getTransferFromBranch() {
		return TransferFromBranch;
	}
	
	private void setTransferFromBranch(int transferFromBranch) {
		TransferFromBranch = transferFromBranch;
	}
	
	private int getTransferFromAccount() {
		return TransferFromAccount;
	}
	
	private void setTransferFromAccount(int transferFromAccount) {
		TransferFromAccount = transferFromAccount;
	}
	
	private int getTransferFromCustomer() {
		return TransferFromCustomer;
	}
	
	private void setTransferFromCustomer(int transferFromCustomer) {
		TransferFromCustomer = transferFromCustomer;
	}
	private int getTransferToBank() {
		return TransferToBank;
	}
	private void setTransferToBank(int transferToBank) {
		TransferToBank = transferToBank;
	}
	
	private int getTransferToBranch() {
		return TransferToBranch;
	}
	
	private void setTransferToBranch(int transferToBranch) {
		TransferToBranch = transferToBranch;
	}
	
	private int getTransferToAccount() {
		return TransferToAccount;
	}
	
	private void setTransferToAccount(int transferToAccount) {
		TransferToAccount = transferToAccount;
	}
	
	private int getTransferToCustomer() {
		return TransferToCustomer;
	}
	
	private void setTransferToCustomer(int transferToCustomer) {
		TransferToCustomer = transferToCustomer;
	}
	
	private double getTransferAmount() {
		return TransferAmount;
	}
	
	private void setTransferAmount(double transferAmount) {
		TransferAmount = transferAmount;
	}
	
	private int getTransferCurrency() {
		return TransferCurrency;
	}
	
	private void setTransferCurrency(int transferCurrency) {
		TransferCurrency = transferCurrency;
	}
	
	private Date getTransferDate() {
		return TransferDate;
	}
	
	private void setTransferDate(Date transferDate) {
		TransferDate = transferDate;
	}
	
	

}
