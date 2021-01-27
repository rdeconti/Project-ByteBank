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
import java.util.Date;
import java.util.List;

import br.com.bytebank.Model.AccountModel;

/*************************************************************************************
Treatment of Account
**************************************************************************************/
public class AccountDataAccessObject {
	
	private static String jdbcURL = "jdbc:mysql://localhost/Bytebank?allowPublicKeyRetrieval=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "$Samsung01";

	private static final String SQL_TABLE = "Account";
	
	private static final String SQL_INSERT = "insert into " + SQL_TABLE + 
	"  (accountCode, accountStatus, accountType, accountAmount, accountCurrency, accountOpenDate, accountCloseDate, accountBank, accountBranch, accountPackage, accountEmployee) VALUES " + " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	
	private static final String SQL_READ_ID = "select * from " + SQL_TABLE + " where accountCode =?";
	
	private static final String SQL_READ_ALL = "select * from " + SQL_TABLE;
	
	private static final String SQL_DELETE = "delete from " + SQL_TABLE + " where accountCode = ?;";
	
	private static final String SQL_UPDATE = "update " + SQL_TABLE + 
	" set accountCode=?, accountStatus=?, accountType=?, accountAmount=?, accountCurrency=?, accountOpenDate=?, accountCloseDate=?, accountBank=?, accountBranch=?, accountPackage=?, accountEmployee=? where accountCode = ?;";
	
	/*************************************************************************************
	Default constructor
	**************************************************************************************/
	public AccountDataAccessObject () {
		
	}

	/*************************************************************************************
	Treat Connection with MySql
	**************************************************************************************/
	protected static Connection getConnection() {
		
		System.out.print("CONSOLE -- ENTROU NA ACCOUNT DATA ACCESS OBJECT: getConnection \n"  ); 
		
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
	public void insertAccount(AccountModel myAccount) throws SQLException {
		
		System.out.print("CONSOLE -- ENTROU NA ACCOUNT DATA ACCESS OBJECT: insertAccount \n"  );  
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)) {
					
			preparedStatement.setInt(1, myAccount.getAccountCode());
			preparedStatement.setString(2, myAccount.getAccountStatus());
			preparedStatement.setString(3, myAccount.getAccountType());
			preparedStatement.setDouble(4, myAccount.getAccountAmount());
			preparedStatement.setString(5, myAccount.getAccountCurrency());
			preparedStatement.setString(6, myAccount.getAccountOpenDate());
			preparedStatement.setString(7, myAccount.getAccountCloseDate());
			preparedStatement.setInt(8, myAccount.getAccountBank());
			preparedStatement.setInt(9, myAccount.getAccountBranch());
			preparedStatement.setInt(10, myAccount.getAccountPackage());
			preparedStatement.setInt(11, myAccount.getAccountEmployee());
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			
			printSQLException(e);
			
		}
		
	}

	/*************************************************************************************
	Treat Read
	**************************************************************************************/
	public AccountModel readOne(int id) {
		
		System.out.print("CONSOLE -- ENTROU NA ACCOUNT DATA ACCESS OBJECT: readOne \n"  );
		
		AccountModel myAccount = null;
		
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SQL_READ_ID);) {
			
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				
				int AccountCode = resultSet.getInt("AccountCode");
				String AccountStatus = resultSet.getString("AccountStatus");
				String AccountType = resultSet.getString("AccounType");
				Double AccountAmount = resultSet.getDouble("AccountAmount");
				String AccountCurrency = resultSet.getString("AccountCurrency");
				String AccountOpenDate = resultSet.getString("AccountOpenDate");
				String AccountCloseDate = resultSet.getString("AccountCloseDate");
				int AccountBank = resultSet.getInt("AccountBank");
				int AccountBranch = resultSet.getInt("AccountBranch");
				int AccountPackage = resultSet.getInt("AccountPackage");
				int AccountEmployee = resultSet.getInt("AccountEmployee");
				
				myAccount = new AccountModel(AccountCode, AccountStatus, AccountType, AccountAmount, AccountCurrency, AccountOpenDate, AccountCloseDate, AccountBank, AccountBranch, AccountPackage, AccountEmployee);
				
			}
			
		} catch (SQLException e) {
			
			printSQLException(e);
			
		}
		
		return myAccount;
		
	}

	/*************************************************************************************
	Treat List
	**************************************************************************************/
	public List<AccountModel> readAll() {
		
		System.out.print("CONSOLE -- ENTROU NA ACCOUNT DATA ACCESS OBJECT: readAll \n ");

		List<AccountModel> myAccount = new ArrayList<>();
		
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SQL_READ_ALL);) {

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
			
				int AccountCode = resultSet.getInt("AccountCode");
				String AccountStatus = resultSet.getString("AccountStatus");
				String AccountType = resultSet.getString("AccounType");
				Double AccountAmount = resultSet.getDouble("AccountAmount");
				String AccountCurrency = resultSet.getString("AccountCurrency");
				String AccountOpenDate = resultSet.getString("AccountOpenDate");
				String AccountCloseDate = resultSet.getString("AccountCloseDate");
				int AccountBank = resultSet.getInt("AccountBank");
				int AccountBranch = resultSet.getInt("AccountBranch");
				int AccountPackage = resultSet.getInt("AccountPackage");
				int AccountEmployee = resultSet.getInt("AccountEmployee");
				
				myAccount.add(new AccountModel(AccountCode, AccountStatus, AccountType, AccountAmount, AccountCurrency, AccountOpenDate, AccountCloseDate, AccountBank, AccountBranch, AccountPackage, AccountEmployee));
				
			}
			
		} catch (SQLException e) {
			
			printSQLException(e);
			
		}
		
		return myAccount;
		
	}

	/*************************************************************************************
	Treat Delete
	**************************************************************************************/
	public boolean deleteAccount(int id) throws SQLException {
		
		System.out.print("CONSOLE -- ENTROU NA ACCOUNT DATA ACCESS OBJECT: deleteAccount \n ");
		
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
	public boolean updateAccount(AccountModel myAccount) throws SQLException {
		
		System.out.print("CONSOLE -- ENTROU NA ACCOUNT DATA ACCESS OBJECT: updateAccount \n ");
		
		boolean rowUpdated;
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE);) {
								
			preparedStatement.setInt(1, myAccount.getAccountCode());
			preparedStatement.setString(2, myAccount.getAccountStatus());
			preparedStatement.setString(3, myAccount.getAccountType());
			preparedStatement.setDouble(4, myAccount.getAccountAmount());
			preparedStatement.setString(5, myAccount.getAccountCurrency());
			preparedStatement.setString(6, myAccount.getAccountOpenDate());
			preparedStatement.setString(7, myAccount.getAccountCloseDate());
			preparedStatement.setInt(8, myAccount.getAccountBank());
			preparedStatement.setInt(9, myAccount.getAccountBranch());
			preparedStatement.setInt(10, myAccount.getAccountPackage());
			preparedStatement.setInt(11, myAccount.getAccountEmployee());
			preparedStatement.setInt(12, myAccount.getAccountCode());

			rowUpdated = preparedStatement.executeUpdate() > 0;
			
		}
		
		return rowUpdated;
		
	}

	// TODO CREATE JUST ONE ROUTINE TO TREAT SQL EXCEPTION
	/*************************************************************************************
	Treat print exception
	**************************************************************************************/
	private static void printSQLException(SQLException exception) {
		
		System.out.print("CONSOLE -- ENTROU NA ACCOUNT DATA ACCESS OBJECT: sqlException \n "); 
		
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
