
/*************************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
**************************************************************************************/
package br.com.bytebank.Model;

public class CustomerModel {
	
	private int CustomerCode;
	private char CustomerStatus;
	private String CustomerName;
	private int CustomerType;
	private int CustomerDocs;
	private int CustomerAddress;
	private int CustomerContact;
	private int CustomerUser;
	
	public CustomerModel() {
	}
	
	private int getCustomerCode() {
		return CustomerCode;
	}
	
	private void setCustomerCode(int customerCode) {
		CustomerCode = customerCode;
	}
	
	private char getCustomerStatus() {
		return CustomerStatus;
	}
	
	private void setCustomerStatus(char customerStatus) {
		CustomerStatus = customerStatus;
	}
	
	private String getCustomerName() {
		return CustomerName;
	}
	
	private void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	
	private int getCustomerType() {
		return CustomerType;
	}
	
	private void setCustomerType(int customerType) {
		CustomerType = customerType;
	}
	
	private int getCustomerDocs() {
		return CustomerDocs;
	}
	
	private void setCustomerDocs(int customerDocs) {
		CustomerDocs = customerDocs;
	}
	
	private int getCustomerAddress() {
		return CustomerAddress;
	}
	
	private void setCustomerAddress(int customerAddress) {
		CustomerAddress = customerAddress;
	}
	
	private int getCustomerContact() {
		return CustomerContact;
	}
	
	private void setCustomerContact(int customerContact) {
		CustomerContact = customerContact;
	}
	
	private int getCustomerUser() {
		return CustomerUser;
	}
	
	private void setCustomerUser(int customerUser) {
		CustomerUser = customerUser;
	}
	
	
}
