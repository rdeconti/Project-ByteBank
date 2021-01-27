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

import br.com.bytebank.DataAccessObject.StatamentDataAccessObject;
import br.com.bytebank.Model.StatamentModel;

/*********************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
**********************************************************************************/

/*********************************************************************************
// Addressing servlet
**********************************************************************************/
@WebServlet("/StatamentServlet")

/*********************************************************************************
// Treat CRUD to database: table STATAMENT
**********************************************************************************/
public class StatamentServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private StatamentDataAccessObject StatamentDataAccessObject;
	
	/*****************************************************************************
	// Initialization
	******************************************************************************/
	public void init() {
			
		StatamentDataAccessObject = new StatamentDataAccessObject();
		
	}

	/*****************************************************************************
	// Treat application doPOST
	******************************************************************************/
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
					
	 	String submitAction = request.getParameter("submitAction");
	 	System.out.print("CONSOLE -- ENTROU NA SERVLET STATAMENT: doPost " + submitAction + "\n " );	

		try {
			
			switch (submitAction) {
								
				case "CreateStatament":
					insertStatament(request, response);
					break;

				case "DeleteStatament":
					deleteStatament(request, response);
					break;
									
				case "UpdateStatament":
					updateStatament(request, response);
					break;
					
				default:
				case "ListStatament":
					listStatament(request, response);
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
		System.out.print("CONSOLE -- ENTROU NA SERVLET STATAMENT: doGet action " + action + "\n " );

		try {
			
			switch (action) {
			
				case "/createStatament":
					showCreateForm(request, response);
					break;

				case "/updateStatament":
					showUpdateForm(request, response);
					break;
					
				case "/deleteStatament":
					showDeleteForm(request, response);
					break;
					
				case "/homeStatament":
					showHomePage(request, response);
					break;
					
				default:
				case "/listStatament":
					listStatament(request, response);
					break;
					
			}
			
		} catch (SQLException ex) {
			
			throw new ServletException(ex);
			
		}
		
	}

	/*********************************************************************************
	// List all records from database table
	**********************************************************************************/
	private void listStatament(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
			
		System.out.print("CONSOLE -- ENTROU NA SERVLET STATAMENT: listStatament \n ");    
		
		List<StatamentModel> listStatament = StatamentDataAccessObject.readAll();
		
		request.setAttribute("myStatament", listStatament);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/statament-list.jsp");
		dispatcher.forward(request, response);
		
		
	}
	
	/*********************************************************************************
	// Show Home Page
	**********************************************************************************/
	private void showHomePage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET STATAMENT: showHomePage \n ");   
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/home.jsp");
		dispatcher.forward(request, response);
		
	}

	/*********************************************************************************
	// Show form to CREATE record
	**********************************************************************************/
	private void showCreateForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET STATAMENT: showCreateForm \n ");   
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/statament-create.jsp");
		dispatcher.forward(request, response);
		
	}

	/*********************************************************************************
	// Show form to UPDATE record
	**********************************************************************************/
	private void showUpdateForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET STATAMENT: showUpdateForm \n ");
		
		int statamentCode = Integer.parseInt(request.getParameter("id"));
		
		StatamentModel existingStatament = StatamentDataAccessObject.readOne(statamentCode);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/statament-update.jsp");
		request.setAttribute("myStatament", existingStatament);
		dispatcher.forward(request, response);

	}
	
	/*********************************************************************************
	// Show form to DELETE record
	**********************************************************************************/
	private void showDeleteForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET STATAMENT: showDeleteForm \n ");
		
		int statamentCode = Integer.parseInt(request.getParameter("id"));
		
		StatamentModel existingStatament = StatamentDataAccessObject.readOne(statamentCode);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/statament-delete.jsp");
		request.setAttribute("myStatament", existingStatament);
		dispatcher.forward(request, response);

	}

	/*********************************************************************************
	// Insert database table record
	**********************************************************************************/
	private void insertStatament(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET STATAMENT: insertStatament \n ");
		
		int StatamentCode = Integer.parseInt(request.getParameter("code"));
		String StatamentStatus = request.getParameter("status");
		String StatamentType = request.getParameter("type");
		int StatamentBank = Integer.parseInt(request.getParameter("bank"));
		int StatamentBranch = Integer.parseInt(request.getParameter("branch"));
		int StatamentAccount = Integer.parseInt(request.getParameter("account"));
		int StatamentCustomer = Integer.parseInt(request.getParameter("customer"));
		double StatamentAmmount = Double.parseDouble(request.getParameter("ammount"));
		String StatamentCurrency = request.getParameter("currency");
		String StatamentDate = request.getParameter("date");
			
		StatamentModel newStatament = new StatamentModel(StatamentCode, StatamentStatus, StatamentType, StatamentBank, StatamentBranch, StatamentAccount, StatamentCustomer, StatamentAmmount, StatamentCurrency, StatamentDate);
		StatamentDataAccessObject.insertStatament(newStatament);
		
		response.sendRedirect("listStatament");
		
	}

	/*********************************************************************************
	// Update database table record
	**********************************************************************************/
	private void updateStatament(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {		
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET STATAMENT: updateStatament \n ");
		
		int StatamentCode = Integer.parseInt(request.getParameter("code"));
		String StatamentStatus = request.getParameter("status");
		String StatamentType = request.getParameter("type");
		int StatamentBank = Integer.parseInt(request.getParameter("bank"));
		int StatamentBranch = Integer.parseInt(request.getParameter("branch"));
		int StatamentAccount = Integer.parseInt(request.getParameter("account"));
		int StatamentCustomer = Integer.parseInt(request.getParameter("customer"));
		double StatamentAmmount = Double.parseDouble(request.getParameter("ammount"));
		String StatamentCurrency = request.getParameter("currency");
		String StatamentDate = request.getParameter("date");
		
		StatamentModel newStatament = new StatamentModel(StatamentCode, StatamentStatus, StatamentType, StatamentBank, StatamentBranch, StatamentAccount, StatamentCustomer, StatamentAmmount, StatamentCurrency, StatamentDate);
		StatamentDataAccessObject.updateStatament(newStatament);
		
		response.sendRedirect("listStatament");
		
	}

	/*********************************************************************************
	// Delete database table record
	**********************************************************************************/
	private void deleteStatament(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET STATAMENT: deleteStatament \n ");  
		
		int objectKey = Integer.parseInt(request.getParameter("code"));
		StatamentDataAccessObject.deleteStatament(objectKey);
		response.sendRedirect("listStatament");

	}

}
