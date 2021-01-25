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

import br.com.bytebank.Model.UserModel;

/*************************************************************************************
Treatment of User
**************************************************************************************/
public class UserDataAccessObject {
	
	private static String jdbcURL = "jdbc:mysql://localhost/Bytebank?allowPublicKeyRetrieval=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "$Samsung01";

	private static final String SQL_TABLE = "User";
	
	private static final String SQL_INSERT = "insert into " + SQL_TABLE + 
	"  (UserCode, UserStatus, UserLevel, UserFailed, UserName, UserPassword) VALUES " + " (?, ?, ?, ?, ?);";
	
	private static final String SQL_READ_ID = "select * from " + SQL_TABLE + " where UserCode =?";
	
	private static final String SQL_READ_ALL = "select * from " + SQL_TABLE;
	
	private static final String SQL_DELETE = "delete from " + SQL_TABLE + " where UserCode = ?;";
	
	private static final String SQL_UPDATE = "update " + SQL_TABLE + 
	" set UserCode=?, UserStatus=?, UserLevel=?, UserFailed=?, UserName=?, UserPassword=? where UserCode = ?;";
	
	/*************************************************************************************
	Default constructor
	**************************************************************************************/
	public UserDataAccessObject () {
		
	}

	/*************************************************************************************
	Treat Connection with MySql
	**************************************************************************************/
	protected static Connection getConnection() {
		
		System.out.print("CONSOLE -- ENTROU NA User DATA ACCESS OBJECT: getConnection \n"  ); 
		
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
	public void insertUser(UserModel myUser) throws SQLException {
		
		System.out.print("CONSOLE -- ENTROU NA User DATA ACCESS OBJECT: insertUser \n"  );  
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)) {
					
			preparedStatement.setInt(1, myUser.getUserCode());
			preparedStatement.setString(2, myUser.getUserStatus());
			preparedStatement.setString(3, myUser.getUserLevel());
			preparedStatement.setInt(4, myUser.getUserFailed());
			preparedStatement.setString(5, myUser.getUserName());
			preparedStatement.setString(6, myUser.getUserPassword());
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			
			printSQLException(e);
			
		}
		
	}

	/*************************************************************************************
	Treat Read
	**************************************************************************************/
	public UserModel readOne(int id) {
		
		System.out.print("CONSOLE -- ENTROU NA User DATA ACCESS OBJECT: readOne \n"  );
		
		UserModel myUser = null;
		
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SQL_READ_ID);) {
			
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				
				int UserCode = resultSet.getInt("UserCode");
				String UserStatus = resultSet.getString("UserStatus");
				String UserLevel = resultSet.getString("UserLevel");
				int UserFailed = resultSet.getInt("UserFailed");
				String UserName = resultSet.getString("UserName");
				String UserPassword = resultSet.getString("UserPassword");
				
				myUser = new UserModel(UserCode, UserStatus, UserLevel, UserFailed, UserName, UserPassword);
				
			}
			
		} catch (SQLException e) {
			
			printSQLException(e);
			
		}
		
		return myUser;
		
	}

	/*************************************************************************************
	Treat List
	**************************************************************************************/
	public List<UserModel> readAll() {
		
		System.out.print("CONSOLE -- ENTROU NA User DATA ACCESS OBJECT: readAll \n ");

		List<UserModel> myUser = new ArrayList<>();
		
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SQL_READ_ALL);) {

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int UserCode = resultSet.getInt("UserCode");
				String UserStatus = resultSet.getString("UserStatus");
				String UserLevel = resultSet.getString("UserLevel");
				int UserFailed = resultSet.getInt("UserFailed");
				String UserName = resultSet.getString("UserName");
				String UserPassword = resultSet.getString("UserPassword");
							
				myUser.add(new UserModel(UserCode, UserStatus, UserLevel, UserFailed, UserName, UserPassword));
				
			}
			
		} catch (SQLException e) {
			
			printSQLException(e);
			
		}
		
		return myUser;
		
	}

	/*************************************************************************************
	Treat Delete
	**************************************************************************************/
	public boolean deleteUser(int id) throws SQLException {
		
		System.out.print("CONSOLE -- ENTROU NA User DATA ACCESS OBJECT: deleteUser \n ");
		
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
	public boolean updateUser(UserModel myUser) throws SQLException {
		
		System.out.print("CONSOLE -- ENTROU NA User DATA ACCESS OBJECT: updateUser \n ");
		
		boolean rowUpdated;
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE);) {
					
			preparedStatement.setInt(1, myUser.getUserCode());
			preparedStatement.setString(2, myUser.getUserStatus());
			preparedStatement.setString(3, myUser.getUserLevel());
			preparedStatement.setInt(4, myUser.getUserFailed());
			preparedStatement.setString(5, myUser.getUserName());
			preparedStatement.setString(6, myUser.getUserPassword());
			preparedStatement.setInt(8, myUser.getUserCode());

			rowUpdated = preparedStatement.executeUpdate() > 0;
			
		}
		
		return rowUpdated;
		
	}

	/*************************************************************************************
	Treat User Login
	**************************************************************************************/
	public boolean validateUser(UserModel myUser) throws ClassNotFoundException {
		
		System.out.print("CONSOLE -- ENTROU NA User DATA ACCESS OBJECT: validateUser \n ");
		
		boolean status = false;

		Class.forName("com.mysql.cj.jdbc.Driver");

		try (Connection connection = 
				
			DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

			PreparedStatement preparedStatement 
				= connection.prepareStatement("select * from User where UserName=? and UserPassword=? ")) 
		{
			preparedStatement.setString(1, myUser.getUserName());
			preparedStatement.setString(2, myUser.getUserPassword());

			ResultSet resultSet = preparedStatement.executeQuery();
			
			status = resultSet.next();

		} catch (SQLException e) {
			
			printSQLException(e);
			
		}
		
		return status;
	}
	
	/*************************************************************************************
	Treat print exception
	**************************************************************************************/
	private static void printSQLException(SQLException exception) {
		
		System.out.print("CONSOLE -- ENTROU NA User DATA ACCESS OBJECT: sqlException \n "); 
		
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