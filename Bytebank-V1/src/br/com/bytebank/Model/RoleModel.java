/*************************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
**************************************************************************************/
package br.com.bytebank.Model;

public class RoleModel {
	
	private int RoleCode;
	private char RoleStatus;
	private String RoleName;
	private String RoleDescription;
	private double RoleSalary;
	private double RoleBonus;
	private int RoleCurrency;
	
	public RoleModel() {
	}
	
	private int getRoleCode() {
		return RoleCode;
	}
	
	private void setRoleCode(int roleCode) {
		RoleCode = roleCode;
	}
	
	private char getRoleStatus() {
		return RoleStatus;
	}
	
	private void setRoleStatus(char roleStatus) {
		RoleStatus = roleStatus;
	}
	
	private String getRoleName() {
		return RoleName;
	}
	
	private void setRoleName(String roleName) {
		RoleName = roleName;
	}
	
	private String getRoleDescription() {
		return RoleDescription;
	}
	
	private void setRoleDescription(String roleDescription) {
		RoleDescription = roleDescription;
	}
	
	private double getRoleSalary() {
		return RoleSalary;
	}
	
	private void setRoleSalary(double roleSalary) {
		RoleSalary = roleSalary;
	}
	
	private double getRoleBonus() {
		return RoleBonus;
	}
	
	private void setRoleBonus(double roleBonus) {
		RoleBonus = roleBonus;
	}
	
	private int getRoleCurrency() {
		return RoleCurrency;
	}
	
	private void setRoleCurrency(int roleCurrency) {
		RoleCurrency = roleCurrency;
	}
	
	

}
