/*************************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
**************************************************************************************/
package br.com.bytebank.Model;

import java.io.Serializable;

public class EmployeeModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int EmployeeCode;
	private String EmployeeStatus;
	private String EmployeeName;
	private String EmployeeType;
	private int EmployeeDocs;
	private int EmployeeAddress;
	private int EmployeeContact;
	private int EmployeeUser;
	
	public EmployeeModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeModel(int employeeCode, String employeeStatus, String employeeName, String employeeType,
			int employeeDocs, int employeeAddress, int employeeContact, int employeeUser) {
		super();
		EmployeeCode = employeeCode;
		EmployeeStatus = employeeStatus;
		EmployeeName = employeeName;
		EmployeeType = employeeType;
		EmployeeDocs = employeeDocs;
		EmployeeAddress = employeeAddress;
		EmployeeContact = employeeContact;
		EmployeeUser = employeeUser;
	}

	public int getEmployeeCode() {
		return EmployeeCode;
	}

	public void setEmployeeCode(int employeeCode) {
		EmployeeCode = employeeCode;
	}

	public String getEmployeeStatus() {
		return EmployeeStatus;
	}

	public void setEmployeeStatus(String employeeStatus) {
		EmployeeStatus = employeeStatus;
	}

	public String getEmployeeName() {
		return EmployeeName;
	}

	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}

	public String getEmployeeType() {
		return EmployeeType;
	}

	public void setEmployeeType(String employeeType) {
		EmployeeType = employeeType;
	}

	public int getEmployeeDocs() {
		return EmployeeDocs;
	}

	public void setEmployeeDocs(int employeeDocs) {
		EmployeeDocs = employeeDocs;
	}

	public int getEmployeeAddress() {
		return EmployeeAddress;
	}

	public void setEmployeeAddress(int employeeAddress) {
		EmployeeAddress = employeeAddress;
	}

	public int getEmployeeContact() {
		return EmployeeContact;
	}

	public void setEmployeeContact(int employeeContact) {
		EmployeeContact = employeeContact;
	}

	public int getEmployeeUser() {
		return EmployeeUser;
	}

	public void setEmployeeUser(int employeeUser) {
		EmployeeUser = employeeUser;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
