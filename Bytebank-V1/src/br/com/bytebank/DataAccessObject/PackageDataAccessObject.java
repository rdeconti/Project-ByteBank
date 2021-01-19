/*************************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
**************************************************************************************/
package br.com.bytebank.DataAccessObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bytebank.Model.PackageModel;

/*************************************************************************************
Treatment of Package
**************************************************************************************/
public class PackageDataAccessObject {
	
	private static String jdbcURL = "jdbc:mysql://localhost/Bytebank?allowPublicKeyRetrieval=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "$Samsung01";

	private static final String SQL_TABLE = "Package";
	
	private static final String SQL_INSERT = "insert into " + SQL_TABLE + 
	"  (packageCode, packageStatus, packageLevel, packageName, packageDescription, packageLimit, packageFee) VALUES " + " (?, ?, ?, ?, ?, ?, ?);";
	private static final String SQL_READ_ID = "select * from " + SQL_TABLE + " where packageCode =?";
	private static final String SQL_READ_ALL = "select * from " + SQL_TABLE;
	private static final String SQL_DELETE = "delete from " + SQL_TABLE + " where packageCode = ?;";
	private static final String SQL_UPDATE = "update " + SQL_TABLE + 
	" set packageStatus=?, packageLevel=?, packageName=?, packageDescription=?, packageLimit=?, packageFee=? where packageCode = ?;";
	
	/*************************************************************************************
	Default constructor
	**************************************************************************************/
	public PackageDataAccessObject () {
		
	}

	/*************************************************************************************
	Treat Connection with MySql
	**************************************************************************************/
	protected static Connection getConnection() {
		
		System.out.print("CONSOLE -- ENTROU NA PACKAGE DATA ACCESS OBJECT: getConnection \n"  ); 
		
		Connection connection = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return connection;
		
	}

	/*************************************************************************************
	Treat Insert
	**************************************************************************************/
	public static void insertPackage(PackageModel myPackage) throws SQLException {
		
		System.out.print("CONSOLE -- ENTROU NA PACKAGE DATA ACCESS OBJECT: insertPackage \n"  );  
		
		System.out.println(SQL_INSERT);
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)) {
					
			preparedStatement.setInt(1, myPackage.getPackageCode());
			preparedStatement.setString(2, myPackage.getPackageStatus());
			preparedStatement.setString(3, myPackage.getPackageLevel());
			preparedStatement.setString(4, myPackage.getPackageName());
			preparedStatement.setString(5, myPackage.getPackageDescription());
			preparedStatement.setDouble(6, myPackage.getPackageLimit());
			preparedStatement.setDouble(7, myPackage.getPackageFee());
			
			System.out.println(preparedStatement);
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			
			printSQLException(e);
			
		}
		
	}

	/*************************************************************************************
	Treat Read
	**************************************************************************************/
	public static PackageModel readOne(int id) {
		
		System.out.print("CONSOLE -- ENTROU NA PACKAGE DATA ACCESS OBJECT: readOne \n"  );
		
		PackageModel myPackage = null;
		
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SQL_READ_ID);) {
			
			preparedStatement.setInt(1, myPackage.getPackageCode());
			System.out.println(preparedStatement);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				
				int PackageCode = resultSet.getInt("PackageCode");
				String PackageStatus = resultSet.getString("PackageStatus");
				String PackageLevel = resultSet.getString("PackageLevel");
				String PackageName = resultSet.getString("PackageName");
				String PackageDescription = resultSet.getString("PackageDescription");
				double PackageLimit = resultSet.getDouble("PackageLimit");
				double PackageFee = resultSet.getDouble("PackageFee");
				
				myPackage = new PackageModel(PackageCode, PackageStatus, PackageLevel, PackageName, PackageDescription, PackageLimit, PackageFee);
				
			}
			
		} catch (SQLException e) {
			
			printSQLException(e);
			
		}
		
		return myPackage;
		
	}

	/*************************************************************************************
	Treat List
	**************************************************************************************/
	public static List<PackageModel> readAll() {
		
		System.out.print("CONSOLE -- ENTROU NA PACKAGE DATA ACCESS OBJECT: readAll \n ");

		List<PackageModel> myPackage = new ArrayList<>();
		
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SQL_READ_ALL);) {
			
			System.out.println(preparedStatement);

			ResultSet resultSet = preparedStatement.executeQuery();
			
			System.out.println(resultSet);

			while (resultSet.next()) {

				int PackageCode = resultSet.getInt("PackageCode");
				String PackageStatus = resultSet.getString("PackageStatus");
				String PackageLevel = resultSet.getString("PackageLevel");
				String PackageName = resultSet.getString("PackageName");
				String PackageDescription = resultSet.getString("PackageDescription");
				double PackageLimit = resultSet.getDouble("PackageLimit");
				double PackageFee = resultSet.getDouble("PackageFee");
				
				myPackage.add(new PackageModel(PackageCode, PackageStatus, PackageLevel, PackageName, PackageDescription, PackageLimit, PackageFee));
				
			}
			
		} catch (SQLException e) {
			
			printSQLException(e);
			
		}
		
		return myPackage;
		
	}

	/*************************************************************************************
	Treat Delete
	**************************************************************************************/
	public static boolean deletePackage(int id) throws SQLException {
		
		System.out.print("CONSOLE -- ENTROU NA PACKAGE DATA ACCESS OBJECT: deletePackage \n ");
		
		boolean rowDeleted;
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE);) {
			
			preparedStatement.setInt(1, id);
			rowDeleted = preparedStatement.executeUpdate() > 0;
			
		}
		
		return rowDeleted;
	}

	/*************************************************************************************
	Treat Update
	**************************************************************************************/
	public static boolean updatePackage(PackageModel myPackage) throws SQLException {
		
		System.out.print("CONSOLE -- ENTROU NA PACKAGE DATA ACCESS OBJECT: updatePackage \n ");
		
		boolean rowUpdated;
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE);) {
					
			preparedStatement.setInt(1, myPackage.getPackageCode());
			preparedStatement.setString(2, myPackage.getPackageStatus());
			preparedStatement.setString(3, myPackage.getPackageLevel());
			preparedStatement.setString(4, myPackage.getPackageName());
			preparedStatement.setString(5, myPackage.getPackageDescription());
			preparedStatement.setDouble(6, myPackage.getPackageLimit());
			preparedStatement.setDouble(7, myPackage.getPackageFee());

			rowUpdated = preparedStatement.executeUpdate() > 0;
			
		}
		
		return rowUpdated;
		
	}

	/*************************************************************************************
	Treat print exception
	**************************************************************************************/
	private static void printSQLException(SQLException exception) {
		
		System.out.print("CONSOLE -- ENTROU NA PACKAGE DATA ACCESS OBJECT: sqlException \n "); 
		
		for (Throwable e : exception) {
			
			if (e instanceof SQLException) {
				
				e.printStackTrace(System.err);
				
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				
				Throwable t = exception.getCause();
				
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
