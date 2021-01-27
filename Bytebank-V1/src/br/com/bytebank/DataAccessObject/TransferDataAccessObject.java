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

import br.com.bytebank.Model.TransferModel;

/*************************************************************************************
Treatment of Transfer
**************************************************************************************/
public class TransferDataAccessObject {
	
	private static String jdbcURL = "jdbc:mysql://localhost/Bytebank?allowPublicKeyRetrieval=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "$Samsung01";

	private static final String SQL_TABLE = "Transfer";
	
	private static final String SQL_INSERT = "insert into " + SQL_TABLE + 
	"  (transferCode, transferStatus, transferFromBank, transferFromBranch, transferFromAccount, transferFromCustomer, transferToBank, transferToBranch, transferToAccount, transferToCustomer, transferAmmount, transferCurrency, transferDate) VALUES " + " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	
	private static final String SQL_READ_ID = "select * from " + SQL_TABLE + " where transferCode =?";
	
	private static final String SQL_READ_ALL = "select * from " + SQL_TABLE;
	
	private static final String SQL_DELETE = "delete from " + SQL_TABLE + " where transferCode = ?;";
	
	private static final String SQL_UPDATE = "update " + SQL_TABLE + 
	" set transferCode=?, transferStatus=?, transferFromBank=?, transferFromBranch=?, transferFromAccount=?, transferFromCustomer=?, transferToBank=?, transferToBranch=?, transferToAccount=?, transferToCustomer=?, transferAmmount=?, transferCurrency=?, transferDate=? where transferCode = ?;";
	
	/*************************************************************************************
	Default constructor
	**************************************************************************************/
	public TransferDataAccessObject () {
		
	}

	/*************************************************************************************
	Treat Connection with MySql
	**************************************************************************************/
	protected static Connection getConnection() {
		
		System.out.print("CONSOLE -- ENTROU NA TRANSFER DATA ACCESS OBJECT: getConnection \n"  ); 
		
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
	public void insertTransfer(TransferModel myTransfer) throws SQLException {
		
		System.out.print("CONSOLE -- ENTROU NA TRANSFER DATA ACCESS OBJECT: insertTransfer \n"  );  
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)) {
					
			preparedStatement.setInt(1, myTransfer.getTransferCode());
			preparedStatement.setString(2, myTransfer.getTransferStatus());
			preparedStatement.setInt(3, myTransfer.getTransferFromBank());
			preparedStatement.setInt(4, myTransfer.getTransferFromBranch());
			preparedStatement.setInt(5, myTransfer.getTransferFromAccount());
			preparedStatement.setInt(6, myTransfer.getTransferFromCustomer());
			preparedStatement.setInt(7, myTransfer.getTransferToBank());
			preparedStatement.setInt(8, myTransfer.getTransferToBranch());
			preparedStatement.setInt(9, myTransfer.getTransferToAccount());
			preparedStatement.setInt(10, myTransfer.getTransferToCustomer());
			preparedStatement.setDouble(11, myTransfer.getTransferAmmount());
			preparedStatement.setString(12, myTransfer.getTransferCurrency());
			preparedStatement.setString(13, myTransfer.getTransferDate());
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			
			printSQLException(e);
			
		}
		
	}

	/*************************************************************************************
	Treat Read
	**************************************************************************************/
	public TransferModel readOne(int id) {
		
		System.out.print("CONSOLE -- ENTROU NA TRANSFER DATA ACCESS OBJECT: readOne \n"  );
		
		TransferModel myTransfer = null;
		
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SQL_READ_ID);) {
			
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
							
				int TransferCode = resultSet.getInt("TransferCode");
				String TransferStatus = resultSet.getString("TransferStatus");
				int TransferFromBank = resultSet.getInt("TransferFromBank");
				int TransferFromBranch = resultSet.getInt("TransferFromBranch");
				int TransferFromAccount = resultSet.getInt("TransferFromAccount");
				int TransferFromCustomer = resultSet.getInt("TransferFromCustomer");
				int TransferToBank = resultSet.getInt("TransferToBank");
				int TransferToBranch = resultSet.getInt("TransferToBranch");
				int TransferToAccount = resultSet.getInt("TransferToAccount");
				int TransferToCustomer = resultSet.getInt("TransferToCustomer");
				double TransferAmmount = resultSet.getDouble("TransferAmmount");
				String TransferCurrency = resultSet.getString("TransferCurrency");
				String TransferDate = resultSet.getString("TransferDate");
				
				myTransfer = new TransferModel(TransferCode, TransferStatus, TransferFromBank, TransferFromBranch, TransferFromAccount, TransferFromCustomer, TransferToBank, TransferToBranch, TransferToAccount, TransferToCustomer, TransferAmmount, TransferCurrency, TransferDate);
				
			}
			
		} catch (SQLException e) {
			
			printSQLException(e);
			
		}
		
		return myTransfer;
		
	}

	/*************************************************************************************
	Treat List
	**************************************************************************************/
	public List<TransferModel> readAll() {
		
		System.out.print("CONSOLE -- ENTROU NA TRANSFER DATA ACCESS OBJECT: readAll \n ");

		List<TransferModel> myTransfer = new ArrayList<>();
		
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SQL_READ_ALL);) {

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int TransferCode = resultSet.getInt("TransferCode");
				String TransferStatus = resultSet.getString("TransferStatus");
				int TransferFromBank = resultSet.getInt("TransferFromBank");
				int TransferFromBranch = resultSet.getInt("TransferFromBranch");
				int TransferFromAccount = resultSet.getInt("TransferFromAccount");
				int TransferFromCustomer = resultSet.getInt("TransferFromCustomer");
				int TransferToBank = resultSet.getInt("TransferToBank");
				int TransferToBranch = resultSet.getInt("TransferToBranch");
				int TransferToAccount = resultSet.getInt("TransferToAccount");
				int TransferToCustomer = resultSet.getInt("TransferToCustomer");
				double TransferAmmount = resultSet.getDouble("TransferAmmount");
				String TransferCurrency = resultSet.getString("TransferCurrency");
				String TransferDate = resultSet.getString("TransferDate");
				
				myTransfer.add(new TransferModel(TransferCode, TransferStatus, TransferFromBank, TransferFromBranch, TransferFromAccount, TransferFromCustomer, TransferToBank, TransferToBranch, TransferToAccount, TransferToCustomer, TransferAmmount, TransferCurrency, TransferDate));
				
			}
			
		} catch (SQLException e) {
			
			printSQLException(e);
			
		}
		
		return myTransfer;
		
	}

	/*************************************************************************************
	Treat Delete
	**************************************************************************************/
	public boolean deleteTransfer(int id) throws SQLException {
		
		System.out.print("CONSOLE -- ENTROU NA TRANSFER DATA ACCESS OBJECT: deleteTransfer \n ");
		
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
	public boolean updateTransfer(TransferModel myTransfer) throws SQLException {
		
		System.out.print("CONSOLE -- ENTROU NA TRANSFER DATA ACCESS OBJECT: updateTransfer \n ");
		
		boolean rowUpdated;
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE);) {
					
			preparedStatement.setInt(1, myTransfer.getTransferCode());
			preparedStatement.setString(2, myTransfer.getTransferStatus());
			preparedStatement.setInt(3, myTransfer.getTransferFromBank());
			preparedStatement.setInt(4, myTransfer.getTransferFromBranch());
			preparedStatement.setInt(5, myTransfer.getTransferFromAccount());
			preparedStatement.setInt(6, myTransfer.getTransferFromCustomer());
			preparedStatement.setInt(7, myTransfer.getTransferToBank());
			preparedStatement.setInt(8, myTransfer.getTransferToBranch());
			preparedStatement.setInt(9, myTransfer.getTransferToAccount());
			preparedStatement.setInt(10, myTransfer.getTransferToCustomer());
			preparedStatement.setDouble(11, myTransfer.getTransferAmmount());
			preparedStatement.setString(12, myTransfer.getTransferCurrency());
			preparedStatement.setString(13, myTransfer.getTransferDate());
			preparedStatement.setInt(14, myTransfer.getTransferCode());

			rowUpdated = preparedStatement.executeUpdate() > 0;
			
		}
		
		return rowUpdated;
		
	}

	// TODO CREATE JUST ONE ROUTINE TO TREAT SQL EXCEPTION
	/*************************************************************************************
	Treat print exception
	**************************************************************************************/
	private static void printSQLException(SQLException exception) {
		
		System.out.print("CONSOLE -- ENTROU NA TRANSFER DATA ACCESS OBJECT: sqlException \n "); 
		
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
