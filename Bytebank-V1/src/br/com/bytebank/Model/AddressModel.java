/*************************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
**************************************************************************************/
package br.com.bytebank.Model;

import java.io.Serializable;

public class AddressModel implements Serializable {

	private static final long serialVersionUID = 1L;
	private int AddressCode;
	private String AddressStatus;
	private String AddressCountry;
	private String AddressState;
	private String AddressCity;
	private String AddressNumber;
	private String AddressCep;
	private String AddressDetail;
	
	public AddressModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddressModel(int addressCode, String addressStatus, String addressCountry, String addressState,
			String addressCity, String addressNumber, String addressCep, String addressDetail) {
		super();
		AddressCode = addressCode;
		AddressStatus = addressStatus;
		AddressCountry = addressCountry;
		AddressState = addressState;
		AddressCity = addressCity;
		AddressNumber = addressNumber;
		AddressCep = addressCep;
		AddressDetail = addressDetail;
	}

	public int getAddressCode() {
		return AddressCode;
	}

	public void setAddressCode(int addressCode) {
		AddressCode = addressCode;
	}

	public String getAddressStatus() {
		return AddressStatus;
	}

	public void setAddressStatus(String addressStatus) {
		AddressStatus = addressStatus;
	}

	public String getAddressCountry() {
		return AddressCountry;
	}

	public void setAddressCountry(String addressCountry) {
		AddressCountry = addressCountry;
	}

	public String getAddressState() {
		return AddressState;
	}

	public void setAddressState(String addressState) {
		AddressState = addressState;
	}

	public String getAddressCity() {
		return AddressCity;
	}

	public void setAddressCity(String addressCity) {
		AddressCity = addressCity;
	}

	public String getAddressNumber() {
		return AddressNumber;
	}

	public void setAddressNumber(String addressNumber) {
		AddressNumber = addressNumber;
	}

	public String getAddressCep() {
		return AddressCep;
	}

	public void setAddressCep(String addressCep) {
		AddressCep = addressCep;
	}

	public String getAddressDetail() {
		return AddressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		AddressDetail = addressDetail;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
