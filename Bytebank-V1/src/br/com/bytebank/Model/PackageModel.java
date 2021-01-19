package br.com.bytebank.Model;

public class PackageModel {
	
	private int PackageCode;
	private String PackageStatus;
	private String PackageLevel;
	private String PackageName;
	private String PackageDescription;
	private double PackageLimit;
	private double PackageFee;
	
	public PackageModel(
			int	packageCode,
			String packageStatus, 
			String packageLevel, 
			String packageName, 
			String packageDescription, 
			double packageLimit, 
			double packageFee) {
			
	      	  this.PackageCode = packageCode; 
			  this.PackageStatus = packageStatus; 
		      this.PackageLevel = packageLevel; 
		      this.PackageName = packageName; 
		      this.PackageDescription = packageDescription; 
		      this.PackageLimit = packageLimit; 
		      this.PackageFee = packageFee; 
		      
	}

	public int getPackageCode() {
		return PackageCode;
	}

	public void setPackageCode(int packageCode) {
		PackageCode = packageCode;
	}

	public String getPackageStatus() {
		return PackageStatus;
	}

	public void setPackageStatus(String packageStatus) {
		PackageStatus = packageStatus;
	}

	public String getPackageLevel() {
		return PackageLevel;
	}

	public void setPackageLevel(String packageLevel) {
		PackageLevel = packageLevel;
	}

	public String getPackageName() {
		return PackageName;
	}

	public void setPackageName(String packageName) {
		PackageName = packageName;
	}

	public String getPackageDescription() {
		return PackageDescription;
	}

	public void setPackageDescription(String packageDescription) {
		PackageDescription = packageDescription;
	}

	public double getPackageLimit() {
		return PackageLimit;
	}

	public void setPackageLimit(double packageLimit) {
		PackageLimit = packageLimit;
	}

	public double getPackageFee() {
		return PackageFee;
	}

	public void setPackageFee(double packageFee) {
		PackageFee = packageFee;
	}


}