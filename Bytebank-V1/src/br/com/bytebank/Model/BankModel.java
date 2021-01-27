/*************************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
**************************************************************************************/
package br.com.bytebank.Model;

import java.io.Serializable;

public class BankModel implements Serializable {

	private static final long serialVersionUID = 1L;
	private int BankCode;
	private String BankStatus; 
	private String BankName; 
	private int BankAddress; 
	private int BankContact; 
	private int BankEmployee;
	
	public BankModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankModel(int bankCode, String bankStatus, String bankName, int bankAddress, int bankContact,
			int bankEmployee) {
		super();
		BankCode = bankCode;
		BankStatus = bankStatus;
		BankName = bankName;
		BankAddress = bankAddress;
		BankContact = bankContact;
		BankEmployee = bankEmployee;
	}

	public int getBankCode() {
		return BankCode;
	}

	public void setBankCode(int bankCode) {
		BankCode = bankCode;
	}

	public String getBankStatus() {
		return BankStatus;
	}

	public void setBankStatus(String bankStatus) {
		BankStatus = bankStatus;
	}

	public String getBankName() {
		return BankName;
	}

	public void setBankName(String bankName) {
		BankName = bankName;
	}

	public int getBankAddress() {
		return BankAddress;
	}

	public void setBankAddress(int bankAddress) {
		BankAddress = bankAddress;
	}

	public int getBankContact() {
		return BankContact;
	}

	public void setBankContact(int bankContact) {
		BankContact = bankContact;
	}

	public int getBankEmployee() {
		return BankEmployee;
	}

	public void setBankEmployee(int bankEmployee) {
		BankEmployee = bankEmployee;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
