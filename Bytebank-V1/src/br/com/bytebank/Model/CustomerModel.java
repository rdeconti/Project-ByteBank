
/*************************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
**************************************************************************************/
package br.com.bytebank.Model;

import java.io.Serializable;

public class CustomerModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int CustomerCode;
	private String CustomerStatus;
	private String CustomerName;
	private int CustomerType;
	private int CustomerDocs;
	private int CustomerAddress;
	private int CustomerContact;
	private int CustomerUser;
	
	public CustomerModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerModel(int customerCode, String customerStatus, String customerName, int customerType,
			int customerDocs, int customerAddress, int customerContact, int customerUser) {
		super();
		CustomerCode = customerCode;
		CustomerStatus = customerStatus;
		CustomerName = customerName;
		CustomerType = customerType;
		CustomerDocs = customerDocs;
		CustomerAddress = customerAddress;
		CustomerContact = customerContact;
		CustomerUser = customerUser;
	}

	public int getCustomerCode() {
		return CustomerCode;
	}

	public void setCustomerCode(int customerCode) {
		CustomerCode = customerCode;
	}

	public String getCustomerStatus() {
		return CustomerStatus;
	}

	public void setCustomerStatus(String customerStatus) {
		CustomerStatus = customerStatus;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public int getCustomerType() {
		return CustomerType;
	}

	public void setCustomerType(int customerType) {
		CustomerType = customerType;
	}

	public int getCustomerDocs() {
		return CustomerDocs;
	}

	public void setCustomerDocs(int customerDocs) {
		CustomerDocs = customerDocs;
	}

	public int getCustomerAddress() {
		return CustomerAddress;
	}

	public void setCustomerAddress(int customerAddress) {
		CustomerAddress = customerAddress;
	}

	public int getCustomerContact() {
		return CustomerContact;
	}

	public void setCustomerContact(int customerContact) {
		CustomerContact = customerContact;
	}

	public int getCustomerUser() {
		return CustomerUser;
	}

	public void setCustomerUser(int customerUser) {
		CustomerUser = customerUser;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
