/*************************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
**************************************************************************************/
package br.com.bytebank.Model;

import java.io.Serializable;

public class ContactModel implements Serializable {

	private static final long serialVersionUID = 1L;
	private int ContactCode;
	private String ContactStatus; 
	private String ContactEmail; 
	private int ContactPhone;
	
	public ContactModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContactModel(int contactCode, String contactStatus, String contactEmail, int contactPhone) {
		super();
		ContactCode = contactCode;
		ContactStatus = contactStatus;
		ContactEmail = contactEmail;
		ContactPhone = contactPhone;
	}

	public int getContactCode() {
		return ContactCode;
	}

	public void setContactCode(int contactCode) {
		ContactCode = contactCode;
	}

	public String getContactStatus() {
		return ContactStatus;
	}

	public void setContactStatus(String contactStatus) {
		ContactStatus = contactStatus;
	}

	public String getContactEmail() {
		return ContactEmail;
	}

	public void setContactEmail(String contactEmail) {
		ContactEmail = contactEmail;
	}

	public int getContactPhone() {
		return ContactPhone;
	}

	public void setContactPhone(int contactPhone) {
		ContactPhone = contactPhone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
