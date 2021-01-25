/*************************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
**************************************************************************************/
package br.com.bytebank.Model;

import java.io.Serializable;

public class UserModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int UserCode;
	private String UserStatus;
	private String UserLevel;
	private int UserFailed;
	private String UserName;
	private String UserPassword;
	
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserModel
		(int userCode, String userStatus, String userLevel, int userFailed, String userName, String userPassword) {
		super();
		UserCode = userCode;
		UserStatus = userStatus;
		UserLevel = userLevel;
		UserFailed = userFailed;
		UserName = userName;
		UserPassword = userPassword;
	}

	public int getUserCode() {
		return UserCode;
	}

	private void setUserCode(int userCode) {
		UserCode = userCode;
	}

	public String getUserStatus() {
		return UserStatus;
	}

	private void setUserStatus(String userStatus) {
		UserStatus = userStatus;
	}

	public String getUserLevel() {
		return UserLevel;
	}

	private void setUserLevel(String userLevel) {
		UserLevel = userLevel;
	}

	public int getUserFailed() {
		return UserFailed;
	}

	private void setUserFailed(int userFailed) {
		UserFailed = userFailed;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getUserPassword() {
		return UserPassword;
	}

	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}

	private static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
