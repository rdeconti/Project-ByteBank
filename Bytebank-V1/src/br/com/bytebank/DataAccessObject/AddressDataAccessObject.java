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

import br.com.bytebank.Model.AddressModel;

/*************************************************************************************
Treatment of Address
**************************************************************************************/
public class AddressDataAccessObject {
	
	private static String jdbcURL = "jdbc:mysql://localhost/Bytebank?allowPublicKeyRetrieval=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "$Samsung01";

	private static final String SQL_TABLE = "Address";
	
	private static final String SQL_INSERT = "insert into " + SQL_TABLE + 
	"  (addressCode, addressStatus, addressCountry, addressState, addressCity, addressNumber, addressCep, AddressDetail) VALUES " + " (?, ?, ?, ?, ?, ?, ?, ?);";
	
	private static final String SQL_READ_ID = "select * from " + SQL_TABLE + " where addressCode =?";
	
	private static final String SQL_READ_ALL = "select * from " + SQL_TABLE;
	
	private static final String SQL_DELETE = "delete from " + SQL_TABLE + " where addressCode = ?;";
	
	private static final String SQL_UPDATE = "update " + SQL_TABLE + 
	" set addressCode=?, addressStatus=?, addressCountry=?, addressState=?, addressCity=?, addressNumber=?, addressCep=?, AddressDetail=? where addressCode = ?;";
	
	/*************************************************************************************
	Default constructor
	**************************************************************************************/
	public AddressDataAccessObject () {
		
	}

	/*************************************************************************************
	Treat Connection with MySql
	**************************************************************************************/
	protected static Connection getConnection() {
		
		System.out.print("CONSOLE -- ENTROU NA ADDRESS DATA ACCESS OBJECT: getConnection \n"  ); 
		
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
	public void insertAddress(AddressModel myAddress) throws SQLException {
		
		System.out.print("CONSOLE -- ENTROU NA ADDRESS DATA ACCESS OBJECT: insertAddress \n"  );  
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)) {
					
			preparedStatement.setInt(1, myAddress.getAddressCode());
			preparedStatement.setString(2, myAddress.getAddressStatus());
			preparedStatement.setString(3, myAddress.getAddressCountry());
			preparedStatement.setString(4, myAddress.getAddressState());
			preparedStatement.setString(5, myAddress.getAddressCity());
			preparedStatement.setString(6, myAddress.getAddressNumber());
			preparedStatement.setString(7, myAddress.getAddressCep());
			preparedStatement.setString(8, myAddress.getAddressDetail());
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			
			printSQLException(e);
			
		}
		
	}

	/*************************************************************************************
	Treat Read
	**************************************************************************************/
	public AddressModel readOne(int id) {
		
		System.out.print("CONSOLE -- ENTROU NA ADDRESS DATA ACCESS OBJECT: readOne \n"  );
		
		AddressModel myAddress = null;
		
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SQL_READ_ID);) {
			
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				
				int AddressCode = resultSet.getInt("AddressCode");
				String AddressStatus = resultSet.getString("AddressStatus");
				String AddressCountry = resultSet.getString("AddressCountry");
				String AddressState = resultSet.getString("AddressState");
				String AddressCity = resultSet.getString("AddressCity");
				String AddressNumber = resultSet.getString("AddressNumber");
				String AddressCep = resultSet.getString("AddressCep");
				String AddressDetail = resultSet.getString("AddressDetail");
				
				myAddress = new AddressModel(AddressCode, AddressStatus, AddressCountry, AddressState, AddressCity, AddressNumber, AddressCep, AddressDetail);
				
			}
			
		} catch (SQLException e) {
			
			printSQLException(e);
			
		}
		
		return myAddress;
		
	}

	/*************************************************************************************
	Treat List
	**************************************************************************************/
	public List<AddressModel> readAll() {
		
		System.out.print("CONSOLE -- ENTROU NA ADDRESS DATA ACCESS OBJECT: readAll \n ");

		List<AddressModel> myAddress = new ArrayList<>();
		
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SQL_READ_ALL);) {

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int AddressCode = resultSet.getInt("AddressCode");
				String AddressStatus = resultSet.getString("AddressStatus");
				String AddressCountry = resultSet.getString("AddressCountry");
				String AddressState = resultSet.getString("AddressState");
				String AddressCity = resultSet.getString("AddressCity");
				String AddressNumber = resultSet.getString("AddressNumber");
				String AddressCep = resultSet.getString("AddressCep");
				String AddressDetail = resultSet.getString("AddressDetail");
				
				myAddress.add(new AddressModel(AddressCode, AddressStatus, AddressCountry, AddressState, AddressCity, AddressNumber, AddressCep, AddressDetail));
				
			}
			
		} catch (SQLException e) {
			
			printSQLException(e);
			
		}
		
		return myAddress;
		
	}

	/*************************************************************************************
	Treat Delete
	**************************************************************************************/
	public boolean deleteAddress(int id) throws SQLException {
		
		System.out.print("CONSOLE -- ENTROU NA ADDRESS DATA ACCESS OBJECT: deleteAddress \n ");
		
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
	public boolean updateAddress(AddressModel myAddress) throws SQLException {
		
		System.out.print("CONSOLE -- ENTROU NA ADDRESS DATA ACCESS OBJECT: updateAddress \n ");
		
		boolean rowUpdated;
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE);) {
					
			preparedStatement.setInt(1, myAddress.getAddressCode());
			preparedStatement.setString(2, myAddress.getAddressStatus());
			preparedStatement.setString(3, myAddress.getAddressCountry());
			preparedStatement.setString(4, myAddress.getAddressState());
			preparedStatement.setString(5, myAddress.getAddressCity());
			preparedStatement.setString(6, myAddress.getAddressNumber());
			preparedStatement.setString(7, myAddress.getAddressCep());
			preparedStatement.setString(8, myAddress.getAddressDetail());
			preparedStatement.setInt(8, myAddress.getAddressCode());

			rowUpdated = preparedStatement.executeUpdate() > 0;
			
		}
		
		return rowUpdated;
		
	}

	// TODO CREATE JUST ONE ROUTINE TO TREAT SQL EXCEPTION
	/*************************************************************************************
	Treat print exception
	**************************************************************************************/
	private static void printSQLException(SQLException exception) {
		
		System.out.print("CONSOLE -- ENTROU NA ADDRESS DATA ACCESS OBJECT: sqlException \n "); 
		
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
