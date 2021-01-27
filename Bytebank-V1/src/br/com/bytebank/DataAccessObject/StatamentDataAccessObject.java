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

import br.com.bytebank.Model.StatamentModel;

/*************************************************************************************
Treatment of Statement
**************************************************************************************/
public class StatamentDataAccessObject {
	
	private static String jdbcURL = "jdbc:mysql://localhost/Bytebank?allowPublicKeyRetrieval=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "$Samsung01";

	private static final String SQL_TABLE = "Statament";
	
	private static final String SQL_INSERT = "insert into " + SQL_TABLE + 
	"  (statamentCode, statamentStatus, statamentType, statamentBank, statamentBranch, statamentAccount, statamentCustomer, statamentAmount, statamentCurrency, statamentDate) VALUES " + " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	
	private static final String SQL_READ_ID = "select * from " + SQL_TABLE + " where statamentCode =?";
	
	private static final String SQL_READ_ALL = "select * from " + SQL_TABLE;
	
	private static final String SQL_DELETE = "delete from " + SQL_TABLE + " where statamentCode = ?;";
	
	private static final String SQL_UPDATE = "update " + SQL_TABLE + 
	" set statamentCode=?, statamentStatus=?, statamentLevel=?, statamentName=?, statamentDescription=?, statamentLimit=?, statamentFee=? where statamentCode = ?;";
	
	/*************************************************************************************
	Default constructor
	**************************************************************************************/
	public StatamentDataAccessObject () {
		
	}

	/*************************************************************************************
	Treat Connection with MySql
	**************************************************************************************/
	protected static Connection getConnection() {
		
		System.out.print("CONSOLE -- ENTROU NA STATAMENT DATA ACCESS OBJECT: getConnection \n"  ); 
		
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
	public void insertStatament(StatamentModel myStatament) throws SQLException {
		
		System.out.print("CONSOLE -- ENTROU NA STATAMENT DATA ACCESS OBJECT: insertStatament \n"  );  
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)) {
					
			preparedStatement.setInt(1, myStatament.getStatamentCode());
			preparedStatement.setString(2, myStatament.getStatamentStatus());
			preparedStatement.setString(3, myStatament.getStatamentType());
			preparedStatement.setInt(4, myStatament.getStatamentBank());
			preparedStatement.setInt(5, myStatament.getStatamentBranch());
			preparedStatement.setInt(6, myStatament.getStatamentAccount());
			preparedStatement.setInt(7, myStatament.getStatamentCustomer());
			preparedStatement.setDouble(8, myStatament.getStatamentAmount());
			preparedStatement.setString(9, myStatament.getStatamentCurrency());
			preparedStatement.setString(10, myStatament.getStatamentDate());
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			
			printSQLException(e);
			
		}
		
	}

	/*************************************************************************************
	Treat Read
	**************************************************************************************/
	public StatamentModel readOne(int id) {
		
		System.out.print("CONSOLE -- ENTROU NA STATAMENT DATA ACCESS OBJECT: readOne \n"  );
		
		StatamentModel myStatament = null;
		
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SQL_READ_ID);) {
			
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				
				int StatamentCode = resultSet.getInt("StatamentCode");
				String StatamentStatus = resultSet.getString("StatamentStatus");
				String StatamentType = resultSet.getString("StatamentType");
				int StatamentBank = resultSet.getInt("StatamentBank");
				int StatamentBranch = resultSet.getInt("StatamentBranch");
				int StatamentAccount = resultSet.getInt("StatamentAccount");
				int StatamentCustomer = resultSet.getInt("StatamentCustomer");
				double StatamentAmmount = resultSet.getDouble("StatamentAmmount");
				String StatamentCurrency = resultSet.getString("StatamentCurrency");
				String StatamentDate = resultSet.getString("StatamentDate");
				
				myStatament = new StatamentModel(StatamentCode, StatamentStatus, StatamentType, StatamentBank, StatamentBranch, StatamentAccount, StatamentCustomer, StatamentAmmount, StatamentCurrency, StatamentDate);
				
			}
			
		} catch (SQLException e) {
			
			printSQLException(e);
			
		}
		
		return myStatament;
		
	}

	/*************************************************************************************
	Treat List
	**************************************************************************************/
	public List<StatamentModel> readAll() {
		
		System.out.print("CONSOLE -- ENTROU NA STATAMENT DATA ACCESS OBJECT: readAll \n ");

		List<StatamentModel> myStatament = new ArrayList<>();
		
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SQL_READ_ALL);) {

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int StatamentCode = resultSet.getInt("StatamentCode");
				String StatamentStatus = resultSet.getString("StatamentStatus");
				String StatamentType = resultSet.getString("StatamentType");
				int StatamentBank = resultSet.getInt("StatamentBank");
				int StatamentBranch = resultSet.getInt("StatamentBranch");
				int StatamentAccount = resultSet.getInt("StatamentAccount");
				int StatamentCustomer = resultSet.getInt("StatamentCustomer");
				double StatamentAmmount = resultSet.getDouble("StatamentAmmount");
				String StatamentCurrency = resultSet.getString("StatamentCurrency");
				String StatamentDate = resultSet.getString("StatamentDate");
				
				myStatament.add(new StatamentModel(StatamentCode, StatamentStatus, StatamentType, StatamentBank, StatamentBranch, StatamentAccount, StatamentCustomer, StatamentAmmount, StatamentCurrency, StatamentDate));
				
			}
			
		} catch (SQLException e) {
			
			printSQLException(e);
			
		}
		
		return myStatament;
		
	}

	/*************************************************************************************
	Treat Delete
	**************************************************************************************/
	public boolean deleteStatament(int id) throws SQLException {
		
		System.out.print("CONSOLE -- ENTROU NA STATAMENT DATA ACCESS OBJECT: deleteStatament \n ");
		
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
	public boolean updateStatament(StatamentModel myStatament) throws SQLException {
		
		System.out.print("CONSOLE -- ENTROU NA STATAMENT DATA ACCESS OBJECT: updateStatament \n ");
		
		boolean rowUpdated;
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE);) {
					
			preparedStatement.setInt(1, myStatament.getStatamentCode());
			preparedStatement.setString(2, myStatament.getStatamentStatus());
			preparedStatement.setString(3, myStatament.getStatamentType());
			preparedStatement.setInt(4, myStatament.getStatamentBank());
			preparedStatement.setInt(5, myStatament.getStatamentBranch());
			preparedStatement.setInt(6, myStatament.getStatamentAccount());
			preparedStatement.setInt(7, myStatament.getStatamentCustomer());
			preparedStatement.setDouble(8, myStatament.getStatamentAmount());
			preparedStatement.setString(9, myStatament.getStatamentCurrency());
			preparedStatement.setString(10, myStatament.getStatamentDate());
			preparedStatement.setInt(11, myStatament.getStatamentCode());

			rowUpdated = preparedStatement.executeUpdate() > 0;
			
		}
		
		return rowUpdated;
		
	}

	// TODO CREATE JUST ONE ROUTINE TO TREAT SQL EXCEPTION
	/*************************************************************************************
	Treat print exception
	**************************************************************************************/
	private static void printSQLException(SQLException exception) {
		
		System.out.print("CONSOLE -- ENTROU NA STATAMENT DATA ACCESS OBJECT: sqlException \n "); 
		
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
