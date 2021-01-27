/*************************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
**************************************************************************************/
package br.com.bytebank.Model;

import java.io.Serializable;
import java.util.Date;

public class StatamentModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int StatamentCode;
	private String StatamentStatus;
	private String StatamentType;
	private int StatamentBank;
	private int StatamentBranch;
	private int StatamentAccount;
	private int StatamentCustomer;
	private double StatamentAmount;
	private String StatamentCurrency;
	private String StatamentDate;
	
	public StatamentModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StatamentModel(int statamentCode, String statamentStatus, String statamentType, int statamentBank,
			int statamentBranch, int statamentAccount, int statamentCustomer, double statamentAmount,
			String statamentCurrency, String statamentDate) {
		super();
		StatamentCode = statamentCode;
		StatamentStatus = statamentStatus;
		StatamentType = statamentType;
		StatamentBank = statamentBank;
		StatamentBranch = statamentBranch;
		StatamentAccount = statamentAccount;
		StatamentCustomer = statamentCustomer;
		StatamentAmount = statamentAmount;
		StatamentCurrency = statamentCurrency;
		StatamentDate = statamentDate;
	}

	public int getStatamentCode() {
		return StatamentCode;
	}

	public void setStatamentCode(int statamentCode) {
		StatamentCode = statamentCode;
	}

	public String getStatamentStatus() {
		return StatamentStatus;
	}

	public void setStatamentStatus(String statamentStatus) {
		StatamentStatus = statamentStatus;
	}

	public String getStatamentType() {
		return StatamentType;
	}

	public void setStatamentType(String statamentType) {
		StatamentType = statamentType;
	}

	public int getStatamentBank() {
		return StatamentBank;
	}

	public void setStatamentBank(int statamentBank) {
		StatamentBank = statamentBank;
	}

	public int getStatamentBranch() {
		return StatamentBranch;
	}

	public void setStatamentBranch(int statamentBranch) {
		StatamentBranch = statamentBranch;
	}

	public int getStatamentAccount() {
		return StatamentAccount;
	}

	public void setStatamentAccount(int statamentAccount) {
		StatamentAccount = statamentAccount;
	}

	public int getStatamentCustomer() {
		return StatamentCustomer;
	}

	public void setStatamentCustomer(int statamentCustomer) {
		StatamentCustomer = statamentCustomer;
	}

	public double getStatamentAmount() {
		return StatamentAmount;
	}

	public void setStatamentAmount(double statamentAmount) {
		StatamentAmount = statamentAmount;
	}

	public String getStatamentCurrency() {
		return StatamentCurrency;
	}

	public void setStatamentCurrency(String statamentCurrency) {
		StatamentCurrency = statamentCurrency;
	}

	public String getStatamentDate() {
		return StatamentDate;
	}

	public void setStatamentDate(String statamentDate) {
		StatamentDate = statamentDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
