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

import br.com.bytebank.Model.ContactModel;

/*************************************************************************************
Treatment of Contact
**************************************************************************************/
public class ContactDataAccessObject {
	
	private static String jdbcURL = "jdbc:mysql://localhost/Bytebank?allowPublicKeyRetrieval=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "$Samsung01";

	private static final String SQL_TABLE = "Contact";
	
	private static final String SQL_INSERT = "insert into " + SQL_TABLE + 
	"  (contactCode, contactStatus, contactEmail, contactPhone) VALUES " + " (?, ?, ?, ?);";
	
	private static final String SQL_READ_ID = "select * from " + SQL_TABLE + " where contactCode =?";
	
	private static final String SQL_READ_ALL = "select * from " + SQL_TABLE;
	
	private static final String SQL_DELETE = "delete from " + SQL_TABLE + " where contactCode = ?;";
	
	private static final String SQL_UPDATE = "update " + SQL_TABLE + 
	" set contactCode=?, contactStatus=?, contactEmail=?, contactPhone=? where contactCode = ?;";
	
	/*************************************************************************************
	Default constructor
	**************************************************************************************/
	public ContactDataAccessObject () {
		
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
	public void insertContact(ContactModel myContact) throws SQLException {
		
		System.out.print("CONSOLE -- ENTROU NA PACKAGE DATA ACCESS OBJECT: insertContact \n"  );  
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)) {
					
			preparedStatement.setInt(1, myContact.getContactCode());
			preparedStatement.setString(2, myContact.getContactStatus());
			preparedStatement.setString(3, myContact.getContactEmail());
			preparedStatement.setInt(4, myContact.getContactPhone());
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			
			printSQLException(e);
			
		}
		
	}

	/*************************************************************************************
	Treat Read
	**************************************************************************************/
	public ContactModel readOne(int id) {
		
		System.out.print("CONSOLE -- ENTROU NA PACKAGE DATA ACCESS OBJECT: readOne \n"  );
		
		ContactModel myContact = null;
		
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SQL_READ_ID);) {
			
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
							
				int ContactCode = resultSet.getInt("ContactCode");
				String ContactStatus = resultSet.getString("ContactStatus");
				String ContactEmail = resultSet.getString("ContactEmail");
				int ContactPhone = resultSet.getInt("ContactPhone");
				
				myContact = new ContactModel(ContactCode, ContactStatus, ContactEmail, ContactPhone);
				
			}
			
		} catch (SQLException e) {
			
			printSQLException(e);
			
		}
		
		return myContact;
		
	}

	/*************************************************************************************
	Treat List
	**************************************************************************************/
	public List<ContactModel> readAll() {
		
		System.out.print("CONSOLE -- ENTROU NA PACKAGE DATA ACCESS OBJECT: readAll \n ");

		List<ContactModel> myContact = new ArrayList<>();
		
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SQL_READ_ALL);) {

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int ContactCode = resultSet.getInt("ContactCode");
				String ContactStatus = resultSet.getString("ContactStatus");
				String ContactEmail = resultSet.getString("ContactEmail");
				int ContactPhone = resultSet.getInt("ContactPhone");
				
				myContact.add(new ContactModel(ContactCode, ContactStatus, ContactEmail, ContactPhone));
				
			}
			
		} catch (SQLException e) {
			
			printSQLException(e);
			
		}
		
		return myContact;
		
	}

	/*************************************************************************************
	Treat Delete
	**************************************************************************************/
	public boolean deleteContact(int id) throws SQLException {
		
		System.out.print("CONSOLE -- ENTROU NA PACKAGE DATA ACCESS OBJECT: deleteContact \n ");
		
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
	public boolean updateContact(ContactModel myContact) throws SQLException {
		
		System.out.print("CONSOLE -- ENTROU NA PACKAGE DATA ACCESS OBJECT: updateContact \n ");
		
		boolean rowUpdated;
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE);) {
					
			preparedStatement.setInt(1, myContact.getContactCode());
			preparedStatement.setString(2, myContact.getContactStatus());
			preparedStatement.setString(3, myContact.getContactEmail());
			preparedStatement.setInt(4, myContact.getContactPhone());
			preparedStatement.setInt(5, myContact.getContactCode());

			rowUpdated = preparedStatement.executeUpdate() > 0;
			
		}
		
		return rowUpdated;
		
	}

	// TODO CREATE JUST ONE ROUTINE TO TREAT SQL EXCEPTION
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
