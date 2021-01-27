/*************************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
**************************************************************************************/
package br.com.bytebank.Model;

import java.io.Serializable;

public class TransferModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int TransferCode;
	private String TransferStatus;
	private int TransferFromBank;
	private int TransferFromBranch;
	private int TransferFromAccount;
	private int TransferFromCustomer;
	private int TransferToBank;
	private int TransferToBranch;
	private int TransferToAccount;
	private int TransferToCustomer;
	private double TransferAmmount;
	private String TransferCurrency;
	private String TransferDate;
	
	public TransferModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransferModel(int transferCode, String transferStatus, int transferFromBank, int transferFromBranch,
			int transferFromAccount, int transferFromCustomer, int transferToBank, int transferToBranch,
			int transferToAccount, int transferToCustomer, double transferAmmount, String transferCurrency,
			String transferDate) {
		super();
		TransferCode = transferCode;
		TransferStatus = transferStatus;
		TransferFromBank = transferFromBank;
		TransferFromBranch = transferFromBranch;
		TransferFromAccount = transferFromAccount;
		TransferFromCustomer = transferFromCustomer;
		TransferToBank = transferToBank;
		TransferToBranch = transferToBranch;
		TransferToAccount = transferToAccount;
		TransferToCustomer = transferToCustomer;
		TransferAmmount = transferAmmount;
		TransferCurrency = transferCurrency;
		TransferDate = transferDate;
	}

	public int getTransferCode() {
		return TransferCode;
	}

	public void setTransferCode(int transferCode) {
		TransferCode = transferCode;
	}

	public String getTransferStatus() {
		return TransferStatus;
	}

	public void setTransferStatus(String transferStatus) {
		TransferStatus = transferStatus;
	}

	public int getTransferFromBank() {
		return TransferFromBank;
	}

	public void setTransferFromBank(int transferFromBank) {
		TransferFromBank = transferFromBank;
	}

	public int getTransferFromBranch() {
		return TransferFromBranch;
	}

	public void setTransferFromBranch(int transferFromBranch) {
		TransferFromBranch = transferFromBranch;
	}

	public int getTransferFromAccount() {
		return TransferFromAccount;
	}

	public void setTransferFromAccount(int transferFromAccount) {
		TransferFromAccount = transferFromAccount;
	}

	public int getTransferFromCustomer() {
		return TransferFromCustomer;
	}

	public void setTransferFromCustomer(int transferFromCustomer) {
		TransferFromCustomer = transferFromCustomer;
	}

	public int getTransferToBank() {
		return TransferToBank;
	}

	public void setTransferToBank(int transferToBank) {
		TransferToBank = transferToBank;
	}

	public int getTransferToBranch() {
		return TransferToBranch;
	}

	public void setTransferToBranch(int transferToBranch) {
		TransferToBranch = transferToBranch;
	}

	public int getTransferToAccount() {
		return TransferToAccount;
	}

	public void setTransferToAccount(int transferToAccount) {
		TransferToAccount = transferToAccount;
	}

	public int getTransferToCustomer() {
		return TransferToCustomer;
	}

	public void setTransferToCustomer(int transferToCustomer) {
		TransferToCustomer = transferToCustomer;
	}

	public double getTransferAmmount() {
		return TransferAmmount;
	}

	public void setTransferAmmount(double transferAmount) {
		TransferAmmount = transferAmount;
	}

	public String getTransferCurrency() {
		return TransferCurrency;
	}

	public void setTransferCurrency(String transferCurrency) {
		TransferCurrency = transferCurrency;
	}

	public String getTransferDate() {
		return TransferDate;
	}

	public void setTransferDate(String transferDate) {
		TransferDate = transferDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
