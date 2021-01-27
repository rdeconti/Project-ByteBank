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

import br.com.bytebank.Model.EmployeeModel;

/*************************************************************************************
Treatment of Employee
**************************************************************************************/
public class EmployeeDataAccessObject {
	
	private static String jdbcURL = "jdbc:mysql://localhost/Bytebank?allowPublicKeyRetrieval=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "$Samsung01";

	private static final String SQL_TABLE = "Employee";
	
	private static final String SQL_INSERT = "insert into " + SQL_TABLE + 
	"  (employeeCode, employeeStatus, employeeName, employeeType, employeeDocs, employeeAddress, employeeContact, employeeUser) VALUES " + " (?, ?, ?, ?, ?, ?, ?, ?);";
	
	private static final String SQL_READ_ID = "select * from " + SQL_TABLE + " where employeeCode =?";
	
	private static final String SQL_READ_ALL = "select * from " + SQL_TABLE;
	
	private static final String SQL_DELETE = "delete from " + SQL_TABLE + " where employeeCode = ?;";
	
	private static final String SQL_UPDATE = "update " + SQL_TABLE + 
	" set employeeCode=?, employeeStatus=?, employeeName=?, employeeType=?, employeeDocs=?, employeeAddress=?, employeeContact=?, employeeUser=? where employeeCode = ?;";
	
	/*************************************************************************************
	Default constructor
	**************************************************************************************/
	public EmployeeDataAccessObject () {
		
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
	public void insertEmployee(EmployeeModel myEmployee) throws SQLException {
		
		System.out.print("CONSOLE -- ENTROU NA PACKAGE DATA ACCESS OBJECT: insertEmployee \n"  );  
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)) {
					
			preparedStatement.setInt(1, myEmployee.getEmployeeCode());
			preparedStatement.setString(2, myEmployee.getEmployeeStatus());
			preparedStatement.setString(3, myEmployee.getEmployeeName());
			preparedStatement.setString(4, myEmployee.getEmployeeType());
			preparedStatement.setInt(5, myEmployee.getEmployeeDocs());
			preparedStatement.setInt(6, myEmployee.getEmployeeAddress());
			preparedStatement.setInt(7, myEmployee.getEmployeeContact());
			preparedStatement.setInt(8, myEmployee.getEmployeeUser());
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			
			printSQLException(e);
			
		}
		
	}

	/*************************************************************************************
	Treat Read
	**************************************************************************************/
	public EmployeeModel readOne(int id) {
		
		System.out.print("CONSOLE -- ENTROU NA PACKAGE DATA ACCESS OBJECT: readOne \n"  );
		
		EmployeeModel myEmployee = null;
		
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SQL_READ_ID);) {
			
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				
				int EmployeeCode = resultSet.getInt("EmployeeCode");
				String EmployeeStatus = resultSet.getString("EmployeeStatus");
				String EmployeeName = resultSet.getString("EmployeeName");
				String EmployeeType = resultSet.getString("EmployeeType");
				int EmployeeDocs = resultSet.getInt("EmployeeDocs");
				int EmployeeAddress = resultSet.getInt("EmployeeAddress");
				int EmployeeContact = resultSet.getInt("EmployeeContact");
				int EmployeeUser = resultSet.getInt("EmployeeUser");
				
				myEmployee = new EmployeeModel(EmployeeCode, EmployeeStatus, EmployeeName, EmployeeType, EmployeeDocs, EmployeeAddress, EmployeeContact, EmployeeUser);
				
			}
			
		} catch (SQLException e) {
			
			printSQLException(e);
			
		}
		
		return myEmployee;
		
	}

	/*************************************************************************************
	Treat List
	**************************************************************************************/
	public List<EmployeeModel> readAll() {
		
		System.out.print("CONSOLE -- ENTROU NA PACKAGE DATA ACCESS OBJECT: readAll \n ");

		List<EmployeeModel> myEmployee = new ArrayList<>();
		
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SQL_READ_ALL);) {

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int EmployeeCode = resultSet.getInt("EmployeeCode");
				String EmployeeStatus = resultSet.getString("EmployeeStatus");
				String EmployeeName = resultSet.getString("EmployeeName");
				String EmployeeType = resultSet.getString("EmployeeType");
				int EmployeeDocs = resultSet.getInt("EmployeeDocs");
				int EmployeeAddress = resultSet.getInt("EmployeeAddress");
				int EmployeeContact = resultSet.getInt("EmployeeContact");
				int EmployeeUser = resultSet.getInt("EmployeeUser");
				
				myEmployee.add(new EmployeeModel(EmployeeCode, EmployeeStatus, EmployeeName, EmployeeType, EmployeeDocs, EmployeeAddress, EmployeeContact, EmployeeUser));
				
			}
			
		} catch (SQLException e) {
			
			printSQLException(e);
			
		}
		
		return myEmployee;
		
	}

	/*************************************************************************************
	Treat Delete
	**************************************************************************************/
	public boolean deleteEmployee(int id) throws SQLException {
		
		System.out.print("CONSOLE -- ENTROU NA PACKAGE DATA ACCESS OBJECT: deleteEmployee \n ");
		
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
	public boolean updateEmployee(EmployeeModel myEmployee) throws SQLException {
		
		System.out.print("CONSOLE -- ENTROU NA PACKAGE DATA ACCESS OBJECT: updateEmployee \n ");
		
		boolean rowUpdated;
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE);) {
					
			preparedStatement.setInt(1, myEmployee.getEmployeeCode());
			preparedStatement.setString(2, myEmployee.getEmployeeStatus());
			preparedStatement.setString(3, myEmployee.getEmployeeName());
			preparedStatement.setString(4, myEmployee.getEmployeeType());
			preparedStatement.setInt(5, myEmployee.getEmployeeDocs());
			preparedStatement.setInt(6, myEmployee.getEmployeeAddress());
			preparedStatement.setInt(7, myEmployee.getEmployeeContact());
			preparedStatement.setInt(8, myEmployee.getEmployeeUser());
			preparedStatement.setInt(9, myEmployee.getEmployeeCode());

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
