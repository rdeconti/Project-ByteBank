package br.com.bytebank.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import br.com.bytebank.DataAccessObject.TransferDataAccessObject;
import br.com.bytebank.Model.TransferModel;

/*********************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
**********************************************************************************/

/*********************************************************************************
// Addressing servlet
**********************************************************************************/
@WebServlet("/TransferServlet")

/*********************************************************************************
// Treat CRUD to database: table TRANSFER
**********************************************************************************/
public class TransferServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private TransferDataAccessObject TransferDataAccessObject;
	
	/*****************************************************************************
	// Initialization
	******************************************************************************/
	public void init() {
			
		TransferDataAccessObject = new TransferDataAccessObject();
		
	}

	/*****************************************************************************
	// Treat application doPOST
	******************************************************************************/
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
					
	 	String submitAction = request.getParameter("submitAction");
	 	System.out.print("CONSOLE -- ENTROU NA SERVLET TRANSFER: doPost " + submitAction + "\n " );	

		try {
			
			switch (submitAction) {
								
				case "CreateTransfer":
					insertTransfer(request, response);
					break;

				case "DeleteTransfer":
					deleteTransfer(request, response);
					break;
									
				case "UpdateTransfer":
					updateTransfer(request, response);
					break;
					
				default:
				case "ListTransfer":
					listTransfer(request, response);
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
		System.out.print("CONSOLE -- ENTROU NA SERVLET TRANSFER: doGet action " + action + "\n " );

		try {
			
			switch (action) {
			
				case "/createTransfer":
					showCreateForm(request, response);
					break;

				case "/updateTransfer":
					showUpdateForm(request, response);
					break;
					
				case "/deleteTransfer":
					showDeleteForm(request, response);
					break;
					
				case "/homeTransfer":
					showHomePage(request, response);
					break;
					
				default:
				case "/listTransfer":
					listTransfer(request, response);
					break;
					
			}
			
		} catch (SQLException ex) {
			
			throw new ServletException(ex);
			
		}
		
	}

	/*********************************************************************************
	// List all records from database table
	**********************************************************************************/
	private void listTransfer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
			
		System.out.print("CONSOLE -- ENTROU NA SERVLET TRANSFER: listTransfer \n ");    
		
		List<TransferModel> listTransfer = TransferDataAccessObject.readAll();
		
		request.setAttribute("myTransfer", listTransfer);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/transfer-list.jsp");
		dispatcher.forward(request, response);
		
		
	}
	
	/*********************************************************************************
	// Show Home Page
	**********************************************************************************/
	private void showHomePage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET TRANSFER: showHomePage \n ");   
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/home.jsp");
		dispatcher.forward(request, response);
		
	}

	/*********************************************************************************
	// Show form to CREATE record
	**********************************************************************************/
	private void showCreateForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET TRANSFER: showCreateForm \n ");   
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/transfer-create.jsp");
		dispatcher.forward(request, response);
		
	}

	/*********************************************************************************
	// Show form to UPDATE record
	**********************************************************************************/
	private void showUpdateForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET TRANSFER: showUpdateForm \n ");
		
		int transferCode = Integer.parseInt(request.getParameter("id"));
		
		TransferModel existingTransfer = TransferDataAccessObject.readOne(transferCode);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/transfer-update.jsp");
		request.setAttribute("myTransfer", existingTransfer);
		dispatcher.forward(request, response);

	}
	
	/*********************************************************************************
	// Show form to DELETE record
	**********************************************************************************/
	private void showDeleteForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET TRANSFER: showDeleteForm \n ");
		
		int transferCode = Integer.parseInt(request.getParameter("id"));
		
		TransferModel existingTransfer = TransferDataAccessObject.readOne(transferCode);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/transfer-delete.jsp");
		request.setAttribute("myTransfer", existingTransfer);
		dispatcher.forward(request, response);

	}

	/*********************************************************************************
	// Insert database table record
	**********************************************************************************/
	private void insertTransfer(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET TRANSFER: insertTransfer \n ");
		
		int TransferCode = Integer.parseInt(request.getParameter("Code"));
		String TransferStatus = request.getParameter("status");
		int TransferFromBank = Integer.parseInt(request.getParameter("fromBank"));
		int TransferFromBranch = Integer.parseInt(request.getParameter("fromBranch"));
		int TransferFromAccount = Integer.parseInt(request.getParameter("fromAccount"));
		int TransferFromCustomer = Integer.parseInt(request.getParameter("fromCustomer"));
		int TransferToBank = Integer.parseInt(request.getParameter("toBank"));
		int TransferToBranch = Integer.parseInt(request.getParameter("toBranch"));
		int TransferToAccount = Integer.parseInt(request.getParameter("toAccount"));
		int TransferToCustomer = Integer.parseInt(request.getParameter("toCustomer"));
		double TransferAmmount = Double.parseDouble(request.getParameter("ammount"));
		String TransferCurrency = request.getParameter("currency");
		String TransferDate = request.getParameter("date");
			
		TransferModel newTransfer = new TransferModel(TransferCode, TransferStatus, TransferFromBank, TransferFromBranch, TransferFromAccount, TransferFromCustomer, TransferToBank, TransferToBranch, TransferToAccount, TransferToCustomer, TransferAmmount, TransferCurrency, TransferDate);
		TransferDataAccessObject.insertTransfer(newTransfer);
		
		response.sendRedirect("list");
		
	}

	/*********************************************************************************
	// Update database table record
	**********************************************************************************/
	private void updateTransfer(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {		
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET TRANSFER: updateTransfer \n ");
		
		int TransferCode = Integer.parseInt(request.getParameter("Code"));
		String TransferStatus = request.getParameter("status");
		int TransferFromBank = Integer.parseInt(request.getParameter("fromBank"));
		int TransferFromBranch = Integer.parseInt(request.getParameter("fromBranch"));
		int TransferFromAccount = Integer.parseInt(request.getParameter("fromAccount"));
		int TransferFromCustomer = Integer.parseInt(request.getParameter("fromCustomer"));
		int TransferToBank = Integer.parseInt(request.getParameter("toBank"));
		int TransferToBranch = Integer.parseInt(request.getParameter("toBranch"));
		int TransferToAccount = Integer.parseInt(request.getParameter("toAccount"));
		int TransferToCustomer = Integer.parseInt(request.getParameter("toCustomer"));
		double TransferAmmount = Double.parseDouble(request.getParameter("ammount"));
		String TransferCurrency = request.getParameter("currency");
		String TransferDate = request.getParameter("date");
		
		TransferModel newTransfer = new TransferModel(TransferCode, TransferStatus, TransferFromBank, TransferFromBranch, TransferFromAccount, TransferFromCustomer, TransferToBank, TransferToBranch, TransferToAccount, TransferToCustomer, TransferAmmount, TransferCurrency, TransferDate);
		TransferDataAccessObject.updateTransfer(newTransfer);
		
		response.sendRedirect("list");
		
	}

	/*********************************************************************************
	// Delete database table record
	**********************************************************************************/
	private void deleteTransfer(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET TRANSFER: deleteTransfer \n ");  
		
		int objectKey = Integer.parseInt(request.getParameter("code"));
		TransferDataAccessObject.deleteTransfer(objectKey);
		response.sendRedirect("list");

	}

}
