/*************************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
**************************************************************************************/
package br.com.bytebank.Model;

import java.io.Serializable;

public class RoleModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int RoleCode;
	private String RoleStatus;
	private String RoleName;
	private String RoleDescription;
	private double RoleSalary;
	private double RoleBonus;
	private String RoleCurrency;
	
	public RoleModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoleModel(int roleCode, String roleStatus, String roleName, String roleDescription, double roleSalary,
			double roleBonus, String roleCurrency) {
		super();
		RoleCode = roleCode;
		RoleStatus = roleStatus;
		RoleName = roleName;
		RoleDescription = roleDescription;
		RoleSalary = roleSalary;
		RoleBonus = roleBonus;
		RoleCurrency = roleCurrency;
	}

	public int getRoleCode() {
		return RoleCode;
	}

	public void setRoleCode(int roleCode) {
		RoleCode = roleCode;
	}

	public String getRoleStatus() {
		return RoleStatus;
	}

	public void setRoleStatus(String roleStatus) {
		RoleStatus = roleStatus;
	}

	public String getRoleName() {
		return RoleName;
	}

	public void setRoleName(String roleName) {
		RoleName = roleName;
	}

	public String getRoleDescription() {
		return RoleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		RoleDescription = roleDescription;
	}

	public double getRoleSalary() {
		return RoleSalary;
	}

	public void setRoleSalary(double roleSalary) {
		RoleSalary = roleSalary;
	}

	public double getRoleBonus() {
		return RoleBonus;
	}

	public void setRoleBonus(double roleBonus) {
		RoleBonus = roleBonus;
	}

	public String getRoleCurrency() {
		return RoleCurrency;
	}

	public void setRoleCurrency(String roleCurrency) {
		RoleCurrency = roleCurrency;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
