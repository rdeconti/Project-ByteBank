/*************************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
**************************************************************************************/
package br.com.bytebank.Model;

public class BankModel {

	private int BankCode;
	private char BankStatus; 
	private String BankName; 
	private int BankAddress; 
	private int BankContact; 
	private int BankEmployee;

	public BankModel() {
	}
	
	private int getBankCode() {
		return BankCode;
	}

	private void setBankCode(int bankCode) {
		BankCode = bankCode;
	}

	private char getBankStatus() {
		return BankStatus;
	}

	private void setBankStatus(char bankStatus) {
		BankStatus = bankStatus;
	}

	private String getBankName() {
		return BankName;
	}

	private void setBankName(String bankName) {
		BankName = bankName;
	}

	private int getBankAddress() {
		return BankAddress;
	}

	private void setBankAddress(int bankAddress) {
		BankAddress = bankAddress;
	}

	private int getBankContact() {
		return BankContact;
	}

	private void setBankContact(int bankContact) {
		BankContact = bankContact;
	}

	private int getBankEmployee() {
		return BankEmployee;
	}

	private void setBankEmployee(int bankEmployee) {
		BankEmployee = bankEmployee;
	}
	
	
	
}
