/*************************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
**************************************************************************************/
package br.com.bytebank.Model;

public class ContactModel {

	private int ContactCode;
	private char ContactStatus; 
	private String ContactEmail; 
	private int ContactPhone;
	
	public ContactModel() {
	}
	
	private int getContactCode() {
		return ContactCode;
	}
	
	private void setContactCode(int contactCode) {
		ContactCode = contactCode;
	}
	private char getContactStatus() {
		return ContactStatus;
	}
	
	private void setContactStatus(char contactStatus) {
		ContactStatus = contactStatus;
	}
	
	private String getContactEmail() {
		return ContactEmail;
	}
	
	private void setContactEmail(String contactEmail) {
		ContactEmail = contactEmail;
	}
	
	private int getContactPhone() {
		return ContactPhone;
	}
	
	private void setContactPhone(int contactPhone) {
		ContactPhone = contactPhone;
	}
	
	
	
}
