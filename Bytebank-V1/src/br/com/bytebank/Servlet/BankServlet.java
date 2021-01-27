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

import br.com.bytebank.DataAccessObject.BankDataAccessObject;
import br.com.bytebank.Model.BankModel;

/*********************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
**********************************************************************************/

/*********************************************************************************
// Addressing servlet
**********************************************************************************/
@WebServlet("/BankServlet")

/*********************************************************************************
// Treat CRUD to database: table PACKAGE
**********************************************************************************/
public class BankServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private BankDataAccessObject BankDataAccessObject;
	
	/*****************************************************************************
	// Initialization
	******************************************************************************/
	public void init() {
			
		BankDataAccessObject = new BankDataAccessObject();
		
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
								
				case "CreateBank":
					insertBank(request, response);
					break;

				case "DeleteBank":
					deleteBank(request, response);
					break;
									
				case "UpdateBank":
					updateBank(request, response);
					break;
					
				default:
				case "ListBank":
					listBank(request, response);
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
			
				case "/createBank":
					showCreateForm(request, response);
					break;

				case "/updateBank":
					showUpdateForm(request, response);
					break;
					
				case "/deleteBank":
					showDeleteForm(request, response);
					break;
					
				case "/homeBank":
					showHomePage(request, response);
					break;
					
				default:
				case "/listBank":
					listBank(request, response);
					break;
					
			}
			
		} catch (SQLException ex) {
			
			throw new ServletException(ex);
			
		}
		
	}

	/*********************************************************************************
	// List all records from database table
	**********************************************************************************/
	private void listBank(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
			
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: listBank \n ");    
		
		List<BankModel> listBank = BankDataAccessObject.readAll();
		
		request.setAttribute("myBank", listBank);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/bank-list.jsp");
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
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/bank-create.jsp");
		dispatcher.forward(request, response);
		
	}

	/*********************************************************************************
	// Show form to UPDATE record
	**********************************************************************************/
	private void showUpdateForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: showUpdateForm \n ");
		
		int bankCode = Integer.parseInt(request.getParameter("id"));
		
		BankModel existingBank = BankDataAccessObject.readOne(bankCode);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/bank-update.jsp");
		request.setAttribute("myBank", existingBank);
		dispatcher.forward(request, response);

	}
	
	/*********************************************************************************
	// Show form to DELETE record
	**********************************************************************************/
	private void showDeleteForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: showDeleteForm \n ");
		
		int bankCode = Integer.parseInt(request.getParameter("id"));
		
		BankModel existingBank = BankDataAccessObject.readOne(bankCode);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/bank-delete.jsp");
		request.setAttribute("myBank", existingBank);
		dispatcher.forward(request, response);

	}

	/*********************************************************************************
	// Insert database table record
	**********************************************************************************/
	private void insertBank(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: insertBank \n ");
			
		int BankCode = Integer.parseInt(request.getParameter("code"));
		String BankStatus = request.getParameter("status");
		String BankName = request.getParameter("name");
		int BankAddress = Integer.parseInt(request.getParameter("address"));
		int BankContact = Integer.parseInt(request.getParameter("contact"));
		int BankEmployee = Integer.parseInt(request.getParameter("employee"));
			
		BankModel newBank = new BankModel(BankCode, BankStatus, BankName, BankAddress, BankContact, BankEmployee);
		BankDataAccessObject.insertBank(newBank);
		
		response.sendRedirect("listBank");
		
	}

	/*********************************************************************************
	// Update database table record
	**********************************************************************************/
	private void updateBank(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {		
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: updateBank \n ");
		
		int BankCode = Integer.parseInt(request.getParameter("code"));
		String BankStatus = request.getParameter("status");
		String BankName = request.getParameter("name");
		int BankAddress = Integer.parseInt(request.getParameter("address"));
		int BankContact = Integer.parseInt(request.getParameter("contact"));
		int BankEmployee = Integer.parseInt(request.getParameter("employee"));
		
		BankModel newBank = new BankModel(BankCode, BankStatus, BankName, BankAddress, BankContact, BankEmployee);
		BankDataAccessObject.updateBank(newBank);
		
		response.sendRedirect("listBank");
		
	}

	/*********************************************************************************
	// Delete database table record
	**********************************************************************************/
	private void deleteBank(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: deleteBank \n ");  
		
		int objectKey = Integer.parseInt(request.getParameter("code"));
		BankDataAccessObject.deleteBank(objectKey);
		response.sendRedirect("listBank");

	}

}
