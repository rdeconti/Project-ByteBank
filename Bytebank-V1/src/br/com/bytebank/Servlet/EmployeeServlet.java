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

import br.com.bytebank.DataAccessObject.EmployeeDataAccessObject;
import br.com.bytebank.Model.EmployeeModel;

/*********************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
**********************************************************************************/

/*********************************************************************************
// Addressing servlet
**********************************************************************************/
@WebServlet("/EmployeeServlet")

/*********************************************************************************
// Treat CRUD to database: table PACKAGE
**********************************************************************************/
public class EmployeeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private EmployeeDataAccessObject EmployeeDataAccessObject;
	
	/*****************************************************************************
	// Initialization
	******************************************************************************/
	public void init() {
			
		EmployeeDataAccessObject = new EmployeeDataAccessObject();
		
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
								
				case "CreateEmployee":
					insertEmployee(request, response);
					break;

				case "DeleteEmployee":
					deleteEmployee(request, response);
					break;
									
				case "UpdateEmployee":
					updateEmployee(request, response);
					break;
					
				default:
				case "ListEmployee":
					listEmployee(request, response);
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
			
				case "/createEmployee":
					showCreateForm(request, response);
					break;

				case "/updateEmployee":
					showUpdateForm(request, response);
					break;
					
				case "/deleteEmployee":
					showDeleteForm(request, response);
					break;
					
				case "/homeEmployee":
					showHomePage(request, response);
					break;
					
				default:
				case "/listEmployee":
					listEmployee(request, response);
					break;
					
			}
			
		} catch (SQLException ex) {
			
			throw new ServletException(ex);
			
		}
		
	}

	/*********************************************************************************
	// List all records from database table
	**********************************************************************************/
	private void listEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
			
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: listEmployee \n ");    
		
		List<EmployeeModel> listEmployee = EmployeeDataAccessObject.readAll();
		
		request.setAttribute("myEmployee", listEmployee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/employee-list.jsp");
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
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/employee-create.jsp");
		dispatcher.forward(request, response);
		
	}

	/*********************************************************************************
	// Show form to UPDATE record
	**********************************************************************************/
	private void showUpdateForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: showUpdateForm \n ");
		
		int employeeCode = Integer.parseInt(request.getParameter("id"));
		
		EmployeeModel existingEmployee = EmployeeDataAccessObject.readOne(employeeCode);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/employee-update.jsp");
		request.setAttribute("myEmployee", existingEmployee);
		dispatcher.forward(request, response);

	}
	
	/*********************************************************************************
	// Show form to DELETE record
	**********************************************************************************/
	private void showDeleteForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: showDeleteForm \n ");
		
		int employeeCode = Integer.parseInt(request.getParameter("id"));
		
		EmployeeModel existingEmployee = EmployeeDataAccessObject.readOne(employeeCode);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/employee-delete.jsp");
		request.setAttribute("myEmployee", existingEmployee);
		dispatcher.forward(request, response);

	}

	/*********************************************************************************
	// Insert database table record
	**********************************************************************************/
	private void insertEmployee(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: insertEmployee \n ");
		
		int EmployeeCode = Integer.parseInt(request.getParameter("code"));
		String EmployeeStatus = request.getParameter("status");
		String EmployeeName = request.getParameter("name");
		String EmployeeType = request.getParameter("type");
		int EmployeeDocs = Integer.parseInt(request.getParameter("docs"));
		int EmployeeAddress = Integer.parseInt(request.getParameter("address"));
		int EmployeeContact = Integer.parseInt(request.getParameter("contact"));
		int EmployeeUser = Integer.parseInt(request.getParameter("user"));
			
		EmployeeModel newEmployee = new EmployeeModel(EmployeeCode, EmployeeStatus, EmployeeName, EmployeeType, EmployeeDocs, EmployeeAddress, EmployeeContact, EmployeeUser);
		EmployeeDataAccessObject.insertEmployee(newEmployee);
		
		response.sendRedirect("listEmployee");
		
	}

	/*********************************************************************************
	// Update database table record
	**********************************************************************************/
	private void updateEmployee(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {		
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: updateEmployee \n ");
		
		int EmployeeCode = Integer.parseInt(request.getParameter("code"));
		String EmployeeStatus = request.getParameter("status");
		String EmployeeName = request.getParameter("name");
		String EmployeeType = request.getParameter("type");
		int EmployeeDocs = Integer.parseInt(request.getParameter("docs"));
		int EmployeeAddress = Integer.parseInt(request.getParameter("address"));
		int EmployeeContact = Integer.parseInt(request.getParameter("contact"));
		int EmployeeUser = Integer.parseInt(request.getParameter("user"));
		
		EmployeeModel newEmployee = new EmployeeModel(EmployeeCode, EmployeeStatus, EmployeeName, EmployeeType, EmployeeDocs, EmployeeAddress, EmployeeContact, EmployeeUser);
		EmployeeDataAccessObject.updateEmployee(newEmployee);
		
		response.sendRedirect("listEmployee");
		
	}

	/*********************************************************************************
	// Delete database table record
	**********************************************************************************/
	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: deleteEmployee \n ");  
		
		int objectKey = Integer.parseInt(request.getParameter("code"));
		EmployeeDataAccessObject.deleteEmployee(objectKey);
		response.sendRedirect("listEmployee");

	}

}
