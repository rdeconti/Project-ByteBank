/*************************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
**************************************************************************************/
package br.com.bytebank.Model;

public class AddressModel {

	private int AddressCode;
	private char AddressStatus;
	private int AddressCountry;
	private int AddressState;
	private int AddressCity;
	private int AddressNumber;
	private int AddressCep;
	private String AddressDetail;
	
	public AddressModel() {
	}

	private int getAddressCode() {
		return AddressCode;
	}

	private void setAddressCode(int addressCode) {
		AddressCode = addressCode;
	}

	private char getAddressStatus() {
		return AddressStatus;
	}

	private void setAddressStatus(char addressStatus) {
		AddressStatus = addressStatus;
	}

	private int getAddressCountry() {
		return AddressCountry;
	}

	private void setAddressCountry(int addressCountry) {
		AddressCountry = addressCountry;
	}

	private int getAddressState() {
		return AddressState;
	}

	private void setAddressState(int addressState) {
		AddressState = addressState;
	}

	private int getAddressCity() {
		return AddressCity;
	}

	private void setAddressCity(int addressCity) {
		AddressCity = addressCity;
	}

	private int getAddressNumber() {
		return AddressNumber;
	}

	private void setAddressNumber(int addressNumber) {
		AddressNumber = addressNumber;
	}

	private int getAddressCep() {
		return AddressCep;
	}

	private void setAddressCep(int addressCep) {
		AddressCep = addressCep;
	}

	private String getAddressDetail() {
		return AddressDetail;
	}

	private void setAddressDetail(String addressDetail) {
		AddressDetail = addressDetail;
	}
	
	
}
