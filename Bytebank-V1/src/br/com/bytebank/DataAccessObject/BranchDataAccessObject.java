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

import br.com.bytebank.Model.BranchModel;

/*************************************************************************************
Treatment of Branch
**************************************************************************************/
public class BranchDataAccessObject {
	
	private static String jdbcURL = "jdbc:mysql://localhost/Bytebank?allowPublicKeyRetrieval=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "$Samsung01";

	private static final String SQL_TABLE = "Branch";
	
	private static final String SQL_INSERT = "insert into " + SQL_TABLE + 
	"  (branchCode, branchStatus, branchName, branchAddress, branchContact, branchEmployee, branchBank) VALUES " + " (?, ?, ?, ?, ?, ?, ?);";
	
	private static final String SQL_READ_ID = "select * from " + SQL_TABLE + " where branchCode =?";
	
	private static final String SQL_READ_ALL = "select * from " + SQL_TABLE;
	
	private static final String SQL_DELETE = "delete from " + SQL_TABLE + " where branchCode = ?;";
	
	private static final String SQL_UPDATE = "update " + SQL_TABLE + 
	" set branchCode=?, branchStatus=?, branchName=?, branchAddress=?, branchContact=?, branchEmployee=?, branchBank=? where branchCode = ?;";
	
	/*************************************************************************************
	Default constructor
	**************************************************************************************/
	public BranchDataAccessObject () {
		
	}

	/*************************************************************************************
	Treat Connection with MySql
	**************************************************************************************/
	protected static Connection getConnection() {
		
		System.out.print("CONSOLE -- ENTROU NA BRANCH DATA ACCESS OBJECT: getConnection \n"  ); 
		
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
	public void insertBranch(BranchModel myBranch) throws SQLException {
		
		System.out.print("CONSOLE -- ENTROU NA BRANCH DATA ACCESS OBJECT: insertBranch \n"  );  
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)) {
					
			preparedStatement.setInt(1, myBranch.getBranchCode());
			preparedStatement.setString(2, myBranch.getBranchStatus());
			preparedStatement.setString(3, myBranch.getBranchName());
			preparedStatement.setInt(4, myBranch.getBranchAddress());
			preparedStatement.setInt(5, myBranch.getBranchContact());
			preparedStatement.setInt(6, myBranch.getBranchEmployee());
			preparedStatement.setInt(7, myBranch.getBranchBank());
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			
			printSQLException(e);
			
		}
		
	}

	/*************************************************************************************
	Treat Read
	**************************************************************************************/
	public BranchModel readOne(int id) {
		
		System.out.print("CONSOLE -- ENTROU NA BRANCH DATA ACCESS OBJECT: readOne \n"  );
		
		BranchModel myBranch = null;
		
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SQL_READ_ID);) {
			
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
							
				int BranchCode = resultSet.getInt("BranchCode");
				String BranchStatus = resultSet.getString("BranchStatus");
				String BranchName = resultSet.getString("BranchName");
				int BranchAddress = resultSet.getInt("BranchAddress");
				int BranchContact = resultSet.getInt("BranchContact");
				int BranchEmployee = resultSet.getInt("BranchEmployee");
				int BranchBank = resultSet.getInt("BranchBank");
				
				myBranch = new BranchModel(BranchCode, BranchStatus, BranchName, BranchAddress, BranchContact, BranchEmployee, BranchBank);
				
			}
			
		} catch (SQLException e) {
			
			printSQLException(e);
			
		}
		
		return myBranch;
		
	}

	/*************************************************************************************
	Treat List
	**************************************************************************************/
	public List<BranchModel> readAll() {
		
		System.out.print("CONSOLE -- ENTROU NA BRANCH DATA ACCESS OBJECT: readAll \n ");

		List<BranchModel> myBranch = new ArrayList<>();
		
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SQL_READ_ALL);) {

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int BranchCode = resultSet.getInt("BranchCode");
				String BranchStatus = resultSet.getString("BranchStatus");
				String BranchName = resultSet.getString("BranchName");
				int BranchAddress = resultSet.getInt("BranchAddress");
				int BranchContact = resultSet.getInt("BranchContact");
				int BranchEmployee = resultSet.getInt("BranchEmployee");
				int BranchBank = resultSet.getInt("BranchBank");
				
				myBranch.add(new BranchModel(BranchCode, BranchStatus, BranchName, BranchAddress, BranchContact, BranchEmployee, BranchBank));
				
			}
			
		} catch (SQLException e) {
			
			printSQLException(e);
			
		}
		
		return myBranch;
		
	}

	/*************************************************************************************
	Treat Delete
	**************************************************************************************/
	public boolean deleteBranch(int id) throws SQLException {
		
		System.out.print("CONSOLE -- ENTROU NA BRANCH DATA ACCESS OBJECT: deleteBranch \n ");
		
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
	public boolean updateBranch(BranchModel myBranch) throws SQLException {
		
		System.out.print("CONSOLE -- ENTROU NA BRANCH DATA ACCESS OBJECT: updateBranch \n ");
		
		boolean rowUpdated;
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE);) {
					
			preparedStatement.setInt(1, myBranch.getBranchCode());
			preparedStatement.setString(2, myBranch.getBranchStatus());
			preparedStatement.setString(3, myBranch.getBranchName());
			preparedStatement.setInt(4, myBranch.getBranchAddress());
			preparedStatement.setInt(5, myBranch.getBranchContact());
			preparedStatement.setInt(6, myBranch.getBranchEmployee());
			preparedStatement.setInt(7, myBranch.getBranchBank());
			preparedStatement.setInt(8, myBranch.getBranchCode());

			rowUpdated = preparedStatement.executeUpdate() > 0;
			
		}
		
		return rowUpdated;
		
	}

	// TODO CREATE JUST ONE ROUTINE TO TREAT SQL EXCEPTION
	/*************************************************************************************
	Treat print exception
	**************************************************************************************/
	private static void printSQLException(SQLException exception) {
		
		System.out.print("CONSOLE -- ENTROU NA BRANCH DATA ACCESS OBJECT: sqlException \n "); 
		
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
