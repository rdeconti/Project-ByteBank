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

import br.com.bytebank.Model.CustomerModel;

/*************************************************************************************
Treatment of Customer
**************************************************************************************/
public class CustomerDataAccessObject {
	
	private static String jdbcURL = "jdbc:mysql://localhost/Bytebank?allowPublicKeyRetrieval=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "$Samsung01";

	private static final String SQL_TABLE = "Customer";
	
	private static final String SQL_INSERT = "insert into " + SQL_TABLE + 
	"  (customerCode, customerStatus, customerName, customerType, customerDocs, customerAddress, customerContact, customerUser) VALUES " + " (?, ?, ?, ?, ?, ?, ?, ?);";
	
	private static final String SQL_READ_ID = "select * from " + SQL_TABLE + " where customerCode =?";
	
	private static final String SQL_READ_ALL = "select * from " + SQL_TABLE;
	
	private static final String SQL_DELETE = "delete from " + SQL_TABLE + " where customerCode = ?;";
	
	private static final String SQL_UPDATE = "update " + SQL_TABLE + 
	" set customerCode=?, customerStatus=?, customerName=?, customerType=?, customerDocs=?, customerAddress=?, customerContact=?, customerUser=?;";
	
	/*************************************************************************************
	Default constructor
	**************************************************************************************/
	public CustomerDataAccessObject () {
		
	}

	/*************************************************************************************
	Treat Connection with MySql
	**************************************************************************************/
	protected static Connection getConnection() {
		
		System.out.print("CONSOLE -- ENTROU NA CUSTOMER DATA ACCESS OBJECT: getConnection \n"  ); 
		
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
	public void insertCustomer(CustomerModel myCustomer) throws SQLException {
		
		System.out.print("CONSOLE -- ENTROU NA CUSTOMER DATA ACCESS OBJECT: insertCustomer \n"  );  
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)) {
					
			preparedStatement.setInt(1, myCustomer.getCustomerCode());
			preparedStatement.setString(2, myCustomer.getCustomerStatus());
			preparedStatement.setString(3, myCustomer.getCustomerName());
			preparedStatement.setInt(4, myCustomer.getCustomerType());
			preparedStatement.setInt(5, myCustomer.getCustomerDocs());
			preparedStatement.setInt(6, myCustomer.getCustomerAddress());
			preparedStatement.setInt(7, myCustomer.getCustomerContact());
			preparedStatement.setInt(8, myCustomer.getCustomerUser());
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			
			printSQLException(e);
			
		}
		
	}

	/*************************************************************************************
	Treat Read
	**************************************************************************************/
	public CustomerModel readOne(int id) {
		
		System.out.print("CONSOLE -- ENTROU NA CUSTOMER DATA ACCESS OBJECT: readOne \n"  );
		
		CustomerModel myCustomer = null;
		
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SQL_READ_ID);) {
			
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
							
				int CustomerCode = resultSet.getInt("CustomerCode");
				String CustomerStatus = resultSet.getString("CustomerStatus");
				String CustomerName = resultSet.getString("CustomerName");
				int CustomerType = resultSet.getInt("CustomerType");
				int CustomerDocs = resultSet.getInt("CustomerDocs");
				int CustomerAddress = resultSet.getInt("CustomerAddress");
				int CustomerContact = resultSet.getInt("CustomerContact");
				int CustomerUser = resultSet.getInt("CustomerUser");
				
				myCustomer = new CustomerModel(CustomerCode, CustomerStatus, CustomerName, CustomerType, CustomerDocs, CustomerAddress, CustomerContact, CustomerUser);
				
			}
			
		} catch (SQLException e) {
			
			printSQLException(e);
			
		}
		
		return myCustomer;
		
	}

	/*************************************************************************************
	Treat List
	**************************************************************************************/
	public List<CustomerModel> readAll() {
		
		System.out.print("CONSOLE -- ENTROU NA CUSTOMER DATA ACCESS OBJECT: readAll \n ");

		List<CustomerModel> myCustomer = new ArrayList<>();
		
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SQL_READ_ALL);) {

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int CustomerCode = resultSet.getInt("CustomerCode");
				String CustomerStatus = resultSet.getString("CustomerStatus");
				String CustomerName = resultSet.getString("CustomerName");
				int CustomerType = resultSet.getInt("CustomerType");
				int CustomerDocs = resultSet.getInt("CustomerDocs");
				int CustomerAddress = resultSet.getInt("CustomerAddress");
				int CustomerContact = resultSet.getInt("CustomerContact");
				int CustomerUser = resultSet.getInt("CustomerUser");
				
				myCustomer.add(new CustomerModel(CustomerCode, CustomerStatus, CustomerName, CustomerType, CustomerDocs, CustomerAddress, CustomerContact, CustomerUser));
				
			}
			
		} catch (SQLException e) {
			
			printSQLException(e);
			
		}
		
		return myCustomer;
		
	}

	/*************************************************************************************
	Treat Delete
	**************************************************************************************/
	public boolean deleteCustomer(int id) throws SQLException {
		
		System.out.print("CONSOLE -- ENTROU NA CUSTOMER DATA ACCESS OBJECT: deleteCustomer \n ");
		
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
	public boolean updateCustomer(CustomerModel myCustomer) throws SQLException {
		
		System.out.print("CONSOLE -- ENTROU NA CUSTOMER DATA ACCESS OBJECT: updateCustomer \n ");
		
		boolean rowUpdated;
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE);) {
					
			preparedStatement.setInt(1, myCustomer.getCustomerCode());
			preparedStatement.setString(2, myCustomer.getCustomerStatus());
			preparedStatement.setString(3, myCustomer.getCustomerName());
			preparedStatement.setInt(4, myCustomer.getCustomerType());
			preparedStatement.setInt(5, myCustomer.getCustomerDocs());
			preparedStatement.setInt(6, myCustomer.getCustomerAddress());
			preparedStatement.setInt(7, myCustomer.getCustomerContact());
			preparedStatement.setInt(8, myCustomer.getCustomerUser());
			preparedStatement.setInt(9, myCustomer.getCustomerCode());

			rowUpdated = preparedStatement.executeUpdate() > 0;
			
		}
		
		return rowUpdated;
		
	}

	// TODO CREATE JUST ONE ROUTINE TO TREAT SQL EXCEPTION
	/*************************************************************************************
	Treat print exception
	**************************************************************************************/
	private static void printSQLException(SQLException exception) {
		
		System.out.print("CONSOLE -- ENTROU NA CUSTOMER DATA ACCESS OBJECT: sqlException \n "); 
		
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
