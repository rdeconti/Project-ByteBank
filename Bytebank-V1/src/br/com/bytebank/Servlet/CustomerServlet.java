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

import br.com.bytebank.DataAccessObject.CustomerDataAccessObject;
import br.com.bytebank.Model.CustomerModel;

/*********************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
**********************************************************************************/

/*********************************************************************************
// Addressing servlet
**********************************************************************************/
@WebServlet("/CustomerServlet")

/*********************************************************************************
// Treat CRUD to database: table PACKAGE
**********************************************************************************/
public class CustomerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private CustomerDataAccessObject CustomerDataAccessObject;
	
	/*****************************************************************************
	// Initialization
	******************************************************************************/
	public void init() {
			
		CustomerDataAccessObject = new CustomerDataAccessObject();
		
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
								
				case "CreateCustomer":
					insertCustomer(request, response);
					break;

				case "DeleteCustomer":
					deleteCustomer(request, response);
					break;
									
				case "UpdateCustomer":
					updateCustomer(request, response);
					break;
					
				default:
				case "ListCustomer":
					listCustomer(request, response);
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
			
				case "/createCustomer":
					showCreateForm(request, response);
					break;

				case "/updateCustomer":
					showUpdateForm(request, response);
					break;
					
				case "/deleteCustomer":
					showDeleteForm(request, response);
					break;
					
				case "/homeCustomer":
					showHomePage(request, response);
					break;
					
				default:
				case "/listCustomer":
					listCustomer(request, response);
					break;
					
			}
			
		} catch (SQLException ex) {
			
			throw new ServletException(ex);
			
		}
		
	}

	/*********************************************************************************
	// List all records from database table
	**********************************************************************************/
	private void listCustomer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
			
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: listCustomer \n ");    
		
		List<CustomerModel> listCustomer = CustomerDataAccessObject.readAll();
		
		request.setAttribute("myCustomer", listCustomer);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/customer-list.jsp");
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
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/customer-create.jsp");
		dispatcher.forward(request, response);
		
	}

	/*********************************************************************************
	// Show form to UPDATE record
	**********************************************************************************/
	private void showUpdateForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: showUpdateForm \n ");
		
		int customerCode = Integer.parseInt(request.getParameter("id"));
		
		CustomerModel existingCustomer = CustomerDataAccessObject.readOne(customerCode);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/customer-update.jsp");
		request.setAttribute("myCustomer", existingCustomer);
		dispatcher.forward(request, response);

	}
	
	/*********************************************************************************
	// Show form to DELETE record
	**********************************************************************************/
	private void showDeleteForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: showDeleteForm \n ");
		
		int customerCode = Integer.parseInt(request.getParameter("id"));
		
		CustomerModel existingCustomer = CustomerDataAccessObject.readOne(customerCode);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/customer-delete.jsp");
		request.setAttribute("myCustomer", existingCustomer);
		dispatcher.forward(request, response);

	}

	/*********************************************************************************
	// Insert database table record
	**********************************************************************************/
	private void insertCustomer(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: insertCustomer \n ");
		
		int CustomerCode = Integer.parseInt(request.getParameter("code"));
		String CustomerStatus = request.getParameter("status");
		String CustomerName = request.getParameter("name");
		int CustomerType = Integer.parseInt(request.getParameter("type"));
		int CustomerDocs = Integer.parseInt(request.getParameter("docs"));
		int CustomerAddress = Integer.parseInt(request.getParameter("address"));
		int CustomerContact = Integer.parseInt(request.getParameter("contact"));
		int CustomerUser = Integer.parseInt(request.getParameter("user"));
			
		CustomerModel newCustomer = new CustomerModel(CustomerCode, CustomerStatus, CustomerName, CustomerType, CustomerDocs, CustomerAddress, CustomerContact, CustomerUser);
		CustomerDataAccessObject.insertCustomer(newCustomer);
		
		response.sendRedirect("listCustomer");
		
	}

	/*********************************************************************************
	// Update database table record
	**********************************************************************************/
	private void updateCustomer(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {		
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: updateCustomer \n ");
		
		int CustomerCode = Integer.parseInt(request.getParameter("code"));
		String CustomerStatus = request.getParameter("status");
		String CustomerName = request.getParameter("name");
		int CustomerType = Integer.parseInt(request.getParameter("type"));
		int CustomerDocs = Integer.parseInt(request.getParameter("docs"));
		int CustomerAddress = Integer.parseInt(request.getParameter("address"));
		int CustomerContact = Integer.parseInt(request.getParameter("contact"));
		int CustomerUser = Integer.parseInt(request.getParameter("user"));
		
		CustomerModel newCustomer = new CustomerModel(CustomerCode, CustomerStatus, CustomerName, CustomerType, CustomerDocs, CustomerAddress, CustomerContact, CustomerUser);
		CustomerDataAccessObject.updateCustomer(newCustomer);
		
		response.sendRedirect("listCustomer");
		
	}

	/*********************************************************************************
	// Delete database table record
	**********************************************************************************/
	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: deleteCustomer \n ");  
		
		int objectKey = Integer.parseInt(request.getParameter("code"));
		CustomerDataAccessObject.deleteCustomer(objectKey);
		response.sendRedirect("listCustomer");

	}

}
