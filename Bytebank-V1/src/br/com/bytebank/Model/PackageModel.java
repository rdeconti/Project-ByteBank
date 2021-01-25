/*************************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
**************************************************************************************/
package br.com.bytebank.Model;

import java.io.Serializable;

public class PackageModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int PackageCode;
	private String PackageStatus;
	private String PackageLevel;
	private String PackageName;
	private String PackageDescription;
	private double PackageLimit;
	private double PackageFee;	
	
	public PackageModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PackageModel(int packageCode, String packageStatus, String packageLevel, String packageName,
			String packageDescription, double packageLimit, double packageFee) {
		super();
		PackageCode = packageCode;
		PackageStatus = packageStatus;
		PackageLevel = packageLevel;
		PackageName = packageName;
		PackageDescription = packageDescription;
		PackageLimit = packageLimit;
		PackageFee = packageFee;
	}
	
//	public PackageModel(
//	int	packageCode,
//	String packageStatus, 
//	String packageLevel, 
//	String packageName, 
//	String packageDescription, 
//	double packageLimit, 
//	double packageFee) {
//	
//  	  this.PackageCode = packageCode; 
//	  this.PackageStatus = packageStatus; 
//      this.PackageLevel = packageLevel; 
//      this.PackageName = packageName; 
//      this.PackageDescription = packageDescription; 
//      this.PackageLimit = packageLimit; 
//      this.PackageFee = packageFee; 
//      
//}



	public int getPackageCode() {
		return PackageCode;
	}

	private void setPackageCode(int packageCode) {
		PackageCode = packageCode;
	}

	public String getPackageStatus() {
		return PackageStatus;
	}

	private void setPackageStatus(String packageStatus) {
		PackageStatus = packageStatus;
	}

	public String getPackageLevel() {
		return PackageLevel;
	}

	private void setPackageLevel(String packageLevel) {
		PackageLevel = packageLevel;
	}

	public String getPackageName() {
		return PackageName;
	}

	private void setPackageName(String packageName) {
		PackageName = packageName;
	}

	public String getPackageDescription() {
		return PackageDescription;
	}

	private void setPackageDescription(String packageDescription) {
		PackageDescription = packageDescription;
	}

	public double getPackageLimit() {
		return PackageLimit;
	}

	private void setPackageLimit(double packageLimit) {
		PackageLimit = packageLimit;
	}

	public double getPackageFee() {
		return PackageFee;
	}

	private void setPackageFee(double packageFee) {
		PackageFee = packageFee;
	}

	private static long getSerialversionuid() {
		return serialVersionUID;
	}

}