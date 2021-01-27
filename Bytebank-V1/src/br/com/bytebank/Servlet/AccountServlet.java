package br.com.bytebank.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import br.com.bytebank.DataAccessObject.AccountDataAccessObject;
import br.com.bytebank.Model.AccountModel;

/*********************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
**********************************************************************************/

/*********************************************************************************
// Addressing servlet
**********************************************************************************/
@WebServlet("/AccountServlet")

/*********************************************************************************
// Treat CRUD to database: table PACKAGE
**********************************************************************************/
public class AccountServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private AccountDataAccessObject AccountDataAccessObject;
	
	/*****************************************************************************
	// Initialization
	******************************************************************************/
	public void init() {
			
		AccountDataAccessObject = new AccountDataAccessObject();
		
	}

	/*****************************************************************************
	// Treat application doPOST
	******************************************************************************/
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
					
	 	String submitAction = request.getParameter("submitAction");
	 	System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: doPost " + submitAction + "\n " );	

		try {
			
			switch (submitAction) {
								
				case "CreateAccount":
					insertAccount(request, response);
					break;

				case "DeleteAccount":
					deleteAccount(request, response);
					break;
									
				case "UpdateAccount":
					updateAccount(request, response);
					break;
					
				default:
				case "ListAccount":
					listAccount(request, response);
					break;
					
			}
			
		} catch (SQLException ex) {
			
			throw new ServletException(ex);
			
		}
		
	}

	/*****************************************************************************
	// Treat application doGET
	******************************************************************************/
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getServletPath();
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: doGet action " + action + "\n " );

		try {
			
			switch (action) {
			
				case "/createAccount":
					showCreateForm(request, response);
					break;

				case "/updateAccount":
					showUpdateForm(request, response);
					break;
					
				case "/deleteAccount":
					showDeleteForm(request, response);
					break;
					
				case "/homeAccount":
					showHomePage(request, response);
					break;
					
				default:
				case "/listAccount":
					listAccount(request, response);
					break;
					
			}
			
		} catch (SQLException ex) {
			
			throw new ServletException(ex);
			
		}
		
	}

	/*********************************************************************************
	// List all records from database table
	**********************************************************************************/
	private void listAccount(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
			
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: listAccount \n ");    
		
		List<AccountModel> listAccount = AccountDataAccessObject.readAll();
		
		request.setAttribute("myAccount", listAccount);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/account-list.jsp");
		dispatcher.forward(request, response);
		
		
	}
	
	/*********************************************************************************
	// Show Home Page
	**********************************************************************************/
	private void showHomePage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: showHomePage \n ");   
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/home.jsp");
		dispatcher.forward(request, response);
		
	}

	/*********************************************************************************
	// Show form to CREATE record
	**********************************************************************************/
	private void showCreateForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: showCreateForm \n ");   
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/account-create.jsp");
		dispatcher.forward(request, response);
		
	}

	/*********************************************************************************
	// Show form to UPDATE record
	**********************************************************************************/
	private void showUpdateForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: showUpdateForm \n ");
		
		int accountCode = Integer.parseInt(request.getParameter("id"));
		
		AccountModel existingAccount = AccountDataAccessObject.readOne(accountCode);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/account-update.jsp");
		request.setAttribute("myAccount", existingAccount);
		dispatcher.forward(request, response);

	}
	
	/*********************************************************************************
	// Show form to DELETE record
	**********************************************************************************/
	private void showDeleteForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: showDeleteForm \n ");
		
		int accountCode = Integer.parseInt(request.getParameter("id"));
		
		AccountModel existingAccount = AccountDataAccessObject.readOne(accountCode);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/account-delete.jsp");
		request.setAttribute("myAccount", existingAccount);
		dispatcher.forward(request, response);

	}

	/*********************************************************************************
	// Insert database table record
	**********************************************************************************/
	private void insertAccount(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: insertAccount \n ");
		
		int AccountCode = Integer.parseInt(request.getParameter("code"));
		String AccountStatus = request.getParameter("status");
		String AccountType = request.getParameter("type");
		Double AccountAmount = Double.parseDouble(request.getParameter("amount"));
		String AccountCurrency = request.getParameter("currency");
		String AccountOpenDate = request.getParameter("openDate");
		String AccountCloseDate = request.getParameter("closeDate");
		int AccountBank = Integer.parseInt(request.getParameter("bank"));
		int AccountBranch = Integer.parseInt(request.getParameter("branch"));
		int AccountPackage = Integer.parseInt(request.getParameter("package"));
		int AccountEmployee = Integer.parseInt(request.getParameter("employee"));
			
		AccountModel newAccount = new AccountModel(AccountCode, AccountStatus, AccountType, AccountAmount, AccountCurrency, AccountOpenDate, AccountCloseDate, AccountBank, AccountBranch, AccountPackage, AccountEmployee);
		AccountDataAccessObject.insertAccount(newAccount);

		response.sendRedirect("listAccount");
		
	}

	/*********************************************************************************
	// Update database table record
	**********************************************************************************/
	private void updateAccount(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {		
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: updateAccount \n ");
		
		int AccountCode = Integer.parseInt(request.getParameter("code"));
		String AccountStatus = request.getParameter("status");
		String AccountType = request.getParameter("type");
		Double AccountAmount = Double.parseDouble(request.getParameter("amount"));
		String AccountCurrency = request.getParameter("currency");
		String AccountOpenDate = request.getParameter("openDate");
		String AccountCloseDate = request.getParameter("closeDate");
		int AccountBank = Integer.parseInt(request.getParameter("bank"));
		int AccountBranch = Integer.parseInt(request.getParameter("branch"));
		int AccountPackage = Integer.parseInt(request.getParameter("package"));
		int AccountEmployee = Integer.parseInt(request.getParameter("employee"));
			
		AccountModel newAccount = new AccountModel(AccountCode, AccountStatus, AccountType, AccountAmount, AccountCurrency, AccountOpenDate, AccountCloseDate, AccountBank, AccountBranch, AccountPackage, AccountEmployee);
		AccountDataAccessObject.updateAccount(newAccount);
		
		response.sendRedirect("listAccount");
		
	}

	/*********************************************************************************
	// Delete database table record
	**********************************************************************************/
	private void deleteAccount(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: deleteAccount \n ");  
		
		int objectKey = Integer.parseInt(request.getParameter("code"));
		AccountDataAccessObject.deleteAccount(objectKey);
		response.sendRedirect("listAccount");

	}

}
