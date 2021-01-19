/*************************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
**************************************************************************************/
package br.com.bytebank.Model;

public class UserModel {
	
	private int UserCode;
	private char UserStatus;
	private char UserLevel;
	private int UserFailed;
	private String UserPassword;
	
	public UserModel() {
	}
	
	private int getUserCode() {
		return UserCode;
	}
	
	private void setUserCode(int userCode) {
		UserCode = userCode;
	}
	
	private char getUserStatus() {
		return UserStatus;
	}
	
	private void setUserStatus(char userStatus) {
		UserStatus = userStatus;
	}
	
	private char getUserLevel() {
		return UserLevel;
	}
	
	private void setUserLevel(char userLevel) {
		UserLevel = userLevel;
	}
	
	private int getUserFailed() {
		return UserFailed;
	}
	
	private void setUserFailed(int userFailed) {
		UserFailed = userFailed;
	}
	
	private String getUserPassword() {
		return UserPassword;
	}
	
	private void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}
	
	

}
