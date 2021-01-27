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

import br.com.bytebank.Model.BankModel;

/*************************************************************************************
Treatment of Bank
**************************************************************************************/
public class BankDataAccessObject {
	
	private static String jdbcURL = "jdbc:mysql://localhost/Bytebank?allowPublicKeyRetrieval=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "$Samsung01";

	private static final String SQL_TABLE = "Bank";
	
	private static final String SQL_INSERT = "insert into " + SQL_TABLE + 
	"  (bankCode, bankStatus, bankName, bankAddress, bankContact, bankEmployee) VALUES " + " (?, ?, ?, ?, ?, ?);";
	
	private static final String SQL_READ_ID = "select * from " + SQL_TABLE + " where bankCode =?";
	
	private static final String SQL_READ_ALL = "select * from " + SQL_TABLE;
	
	private static final String SQL_DELETE = "delete from " + SQL_TABLE + " where bankCode = ?;";
	
	private static final String SQL_UPDATE = "update " + SQL_TABLE + 
	" set bankCode=?, bankStatus=?, bankName=?, bankAddress=?, bankContact=?, bankEmployee=? where bankCode = ?;";
	
	/*************************************************************************************
	Default constructor
	**************************************************************************************/
	public BankDataAccessObject () {
		
	}

	/*************************************************************************************
	Treat Connection with MySql
	**************************************************************************************/
	protected static Connection getConnection() {
		
		System.out.print("CONSOLE -- ENTROU NA BANK DATA ACCESS OBJECT: getConnection \n"  ); 
		
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
	public void insertBank(BankModel myBank) throws SQLException {
		
		System.out.print("CONSOLE -- ENTROU NA BANK DATA ACCESS OBJECT: insertBank \n"  );  
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)) {
							
			preparedStatement.setInt(1, myBank.getBankCode());
			preparedStatement.setString(2, myBank.getBankStatus());
			preparedStatement.setString(3, myBank.getBankName());
			preparedStatement.setInt(4, myBank.getBankAddress());
			preparedStatement.setInt(5, myBank.getBankContact());
			preparedStatement.setInt(6, myBank.getBankEmployee());
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			
			printSQLException(e);
			
		}
		
	}

	/*************************************************************************************
	Treat Read
	**************************************************************************************/
	public BankModel readOne(int id) {
		
		System.out.print("CONSOLE -- ENTROU NA BANK DATA ACCESS OBJECT: readOne \n"  );
		
		BankModel myBank = null;
		
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SQL_READ_ID);) {
			
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
							
				int BankCode = resultSet.getInt("BankCode");
				String BankStatus = resultSet.getString("BankStatus");
				String BankName = resultSet.getString("BankName");
				int BankAddress = resultSet.getInt("BankAddress");
				int BankContact = resultSet.getInt("BankContact");
				int BankEmployee = resultSet.getInt("BankEmployee");
				
				myBank = new BankModel(BankCode, BankStatus, BankName, BankAddress, BankContact, BankEmployee);
				
			}
			
		} catch (SQLException e) {
			
			printSQLException(e);
			
		}
		
		return myBank;
		
	}

	/*************************************************************************************
	Treat List
	**************************************************************************************/
	public List<BankModel> readAll() {
		
		System.out.print("CONSOLE -- ENTROU NA BANK DATA ACCESS OBJECT: readAll \n ");

		List<BankModel> myBank = new ArrayList<>();
		
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SQL_READ_ALL);) {

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int BankCode = resultSet.getInt("BankCode");
				String BankStatus = resultSet.getString("BankStatus");
				String BankName = resultSet.getString("BankName");
				int BankAddress = resultSet.getInt("BankAddress");
				int BankContact = resultSet.getInt("BankContact");
				int BankEmployee = resultSet.getInt("BankEmployee");
				
				myBank.add(new BankModel(BankCode, BankStatus, BankName, BankAddress, BankContact, BankEmployee));
				
			}
			
		} catch (SQLException e) {
			
			printSQLException(e);
			
		}
		
		return myBank;
		
	}

	/*************************************************************************************
	Treat Delete
	**************************************************************************************/
	public boolean deleteBank(int id) throws SQLException {
		
		System.out.print("CONSOLE -- ENTROU NA BANK DATA ACCESS OBJECT: deleteBank \n ");
		
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
	public boolean updateBank(BankModel myBank) throws SQLException {
		
		System.out.print("CONSOLE -- ENTROU NA BANK DATA ACCESS OBJECT: updateBank \n ");
		
		boolean rowUpdated;
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE);) {
					
			preparedStatement.setInt(1, myBank.getBankCode());
			preparedStatement.setString(2, myBank.getBankStatus());
			preparedStatement.setString(3, myBank.getBankName());
			preparedStatement.setInt(4, myBank.getBankAddress());
			preparedStatement.setInt(5, myBank.getBankContact());
			preparedStatement.setInt(6, myBank.getBankEmployee());
			preparedStatement.setInt(7, myBank.getBankCode());

			rowUpdated = preparedStatement.executeUpdate() > 0;
			
		}
		
		return rowUpdated;
		
	}

	// TODO CREATE JUST ONE ROUTINE TO TREAT SQL EXCEPTION
	/*************************************************************************************
	Treat print exception
	**************************************************************************************/
	private static void printSQLException(SQLException exception) {
		
		System.out.print("CONSOLE -- ENTROU NA BANK DATA ACCESS OBJECT: sqlException \n "); 
		
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
