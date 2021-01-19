/*************************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
**************************************************************************************/
package br.com.bytebank.Model;

public class EmployeeModel {
	
	private int EmployeeCode;
	private char EmployeeStatus;
	private String EmployeeName;
	private char EmployeeType;
	private int EmployeeDocs;
	private int EmployeeAddress;
	private int EmployeeContact;
	private int EmployeeUser;
	
	public EmployeeModel() {
	}

	private int getEmployeeCode() {
		return EmployeeCode;
	}

	private void setEmployeeCode(int employeeCode) {
		EmployeeCode = employeeCode;
	}

	private char getEmployeeStatus() {
		return EmployeeStatus;
	}

	private void setEmployeeStatus(char employeeStatus) {
		EmployeeStatus = employeeStatus;
	}

	private String getEmployeeName() {
		return EmployeeName;
	}

	private void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}

	private char getEmployeeType() {
		return EmployeeType;
	}

	private void setEmployeeType(char employeeType) {
		EmployeeType = employeeType;
	}

	private int getEmployeeDocs() {
		return EmployeeDocs;
	}

	private void setEmployeeDocs(int employeeDocs) {
		EmployeeDocs = employeeDocs;
	}

	private int getEmployeeAddress() {
		return EmployeeAddress;
	}

	private void setEmployeeAddress(int employeeAddress) {
		EmployeeAddress = employeeAddress;
	}

	private int getEmployeeContact() {
		return EmployeeContact;
	}

	private void setEmployeeContact(int employeeContact) {
		EmployeeContact = employeeContact;
	}

	private int getEmployeeUser() {
		return EmployeeUser;
	}

	private void setEmployeeUser(int employeeUser) {
		EmployeeUser = employeeUser;
	}
	
}
