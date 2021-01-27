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

import br.com.bytebank.Model.RoleModel;

/*************************************************************************************
Treatment of Role
**************************************************************************************/
public class RoleDataAccessObject {
	
	private static String jdbcURL = "jdbc:mysql://localhost/Bytebank?allowPublicKeyRetrieval=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "$Samsung01";

	private static final String SQL_TABLE = "Role";
	
	private static final String SQL_INSERT = "insert into " + SQL_TABLE + 
	"  (roleCode, roleStatus, roleName, roleDescription, roleSalary, roleBonus, roleCurrency) VALUES " + " (?, ?, ?, ?, ?, ?, ?);";
	
	private static final String SQL_READ_ID = "select * from " + SQL_TABLE + " where roleCode =?";
	
	private static final String SQL_READ_ALL = "select * from " + SQL_TABLE;
	
	private static final String SQL_DELETE = "delete from " + SQL_TABLE + " where roleCode = ?;";
	
	private static final String SQL_UPDATE = "update " + SQL_TABLE + 
	" set roleCode=?, roleStatus=?, roleName=?, roleDescription=?, roleSalary=?, roleBonus=?, roleCurrency=? where roleCode = ?;";
	
	/*************************************************************************************
	Default constructor
	**************************************************************************************/
	public RoleDataAccessObject () {
		
	}

	/*************************************************************************************
	Treat Connection with MySql
	**************************************************************************************/
	protected static Connection getConnection() {
		
		System.out.print("CONSOLE -- ENTROU NA ROLE DATA ACCESS OBJECT: getConnection \n"  ); 
		
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
	public void insertRole(RoleModel myRole) throws SQLException {
		
		System.out.print("CONSOLE -- ENTROU NA ROLE DATA ACCESS OBJECT: insertRole \n"  );  
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)) {
					
			preparedStatement.setInt(1, myRole.getRoleCode());
			preparedStatement.setString(2, myRole.getRoleStatus());
			preparedStatement.setString(3, myRole.getRoleName());
			preparedStatement.setString(4, myRole.getRoleDescription());
			preparedStatement.setDouble(5, myRole.getRoleSalary());
			preparedStatement.setDouble(6, myRole.getRoleBonus());
			preparedStatement.setString(7, myRole.getRoleCurrency());
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			
			printSQLException(e);
			
		}
		
	}

	/*************************************************************************************
	Treat Read
	**************************************************************************************/
	public RoleModel readOne(int id) {
		
		System.out.print("CONSOLE -- ENTROU NA ROLE DATA ACCESS OBJECT: readOne \n"  );
		
		RoleModel myRole = null;
		
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SQL_READ_ID);) {
			
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {				
				
				int RoleCode = resultSet.getInt("RoleCode");
				String RoleStatus = resultSet.getString("RoleStatus");
				String RoleName = resultSet.getString("RoleName");
				String RoleDescription = resultSet.getString("RoleDescription");
				double RoleSalary = resultSet.getDouble("RoleSalary");
				double RoleBonus = resultSet.getDouble("RoleBonus");
				String RoleCurrency = resultSet.getString("RoleCurrency");
				
				myRole = new RoleModel(RoleCode, RoleStatus, RoleName, RoleDescription, RoleSalary, RoleBonus, RoleCurrency);
				
			}
			
		} catch (SQLException e) {
			
			printSQLException(e);
			
		}
		
		return myRole;
		
	}

	/*************************************************************************************
	Treat List
	**************************************************************************************/
	public List<RoleModel> readAll() {
		
		System.out.print("CONSOLE -- ENTROU NA ROLE DATA ACCESS OBJECT: readAll \n ");

		List<RoleModel> myRole = new ArrayList<>();
		
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SQL_READ_ALL);) {

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int RoleCode = resultSet.getInt("RoleCode");
				String RoleStatus = resultSet.getString("RoleStatus");
				String RoleName = resultSet.getString("RoleName");
				String RoleDescription = resultSet.getString("RoleDescription");
				double RoleSalary = resultSet.getDouble("RoleSalary");
				double RoleBonus = resultSet.getDouble("RoleBonus");
				String RoleCurrency = resultSet.getString("RoleCurrency");
				
				myRole.add(new RoleModel(RoleCode, RoleStatus, RoleName, RoleDescription, RoleSalary, RoleBonus, RoleCurrency));
				
			}
			
		} catch (SQLException e) {
			
			printSQLException(e);
			
		}
		
		return myRole;
		
	}

	/*************************************************************************************
	Treat Delete
	**************************************************************************************/
	public boolean deleteRole(int id) throws SQLException {
		
		System.out.print("CONSOLE -- ENTROU NA ROLE DATA ACCESS OBJECT: deleteRole \n ");
		
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
	public boolean updateRole(RoleModel myRole) throws SQLException {
		
		System.out.print("CONSOLE -- ENTROU NA ROLE DATA ACCESS OBJECT: updateRole \n ");
		
		boolean rowUpdated;
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE);) {
					
			preparedStatement.setInt(1, myRole.getRoleCode());
			preparedStatement.setString(2, myRole.getRoleStatus());
			preparedStatement.setString(3, myRole.getRoleName());
			preparedStatement.setString(4, myRole.getRoleDescription());
			preparedStatement.setDouble(5, myRole.getRoleSalary());
			preparedStatement.setDouble(6, myRole.getRoleBonus());
			preparedStatement.setString(7, myRole.getRoleCurrency());
			preparedStatement.setInt(8, myRole.getRoleCode());

			rowUpdated = preparedStatement.executeUpdate() > 0;
			
		}
		
		return rowUpdated;
		
	}

	// TODO CREATE JUST ONE ROUTINE TO TREAT SQL EXCEPTION
	/*************************************************************************************
	Treat print exception
	**************************************************************************************/
	private static void printSQLException(SQLException exception) {
		
		System.out.print("CONSOLE -- ENTROU NA ROLE DATA ACCESS OBJECT: sqlException \n "); 
		
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
