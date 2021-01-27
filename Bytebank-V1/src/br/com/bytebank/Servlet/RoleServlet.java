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

import br.com.bytebank.DataAccessObject.RoleDataAccessObject;
import br.com.bytebank.Model.RoleModel;

/*********************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
**********************************************************************************/

/*********************************************************************************
// Addressing servlet
**********************************************************************************/
@WebServlet("/RoleServlet")

/*********************************************************************************
// Treat CRUD to database: table PACKAGE
**********************************************************************************/
public class RoleServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private RoleDataAccessObject RoleDataAccessObject;
	
	/*****************************************************************************
	// Initialization
	******************************************************************************/
	public void init() {
			
		RoleDataAccessObject = new RoleDataAccessObject();
		
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
								
				case "CreateRole":
					insertRole(request, response);
					break;

				case "DeleteRole":
					deleteRole(request, response);
					break;
									
				case "UpdateRole":
					updateRole(request, response);
					break;
					
				default:
				case "ListRole":
					listRole(request, response);
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
			
				case "/createRole":
					showCreateForm(request, response);
					break;

				case "/updateRole":
					showUpdateForm(request, response);
					break;
					
				case "/deleteRole":
					showDeleteForm(request, response);
					break;
					
				case "/homeRole":
					showHomePage(request, response);
					break;
					
				default:
				case "/listRole":
					listRole(request, response);
					break;
					
			}
			
		} catch (SQLException ex) {
			
			throw new ServletException(ex);
			
		}
		
	}

	/*********************************************************************************
	// List all records from database table
	**********************************************************************************/
	private void listRole(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
			
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: listRole \n ");    
		
		List<RoleModel> listRole = RoleDataAccessObject.readAll();
		
		request.setAttribute("myRole", listRole);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/role-list.jsp");
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
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/role-create.jsp");
		dispatcher.forward(request, response);
		
	}

	/*********************************************************************************
	// Show form to UPDATE record
	**********************************************************************************/
	private void showUpdateForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: showUpdateForm \n ");
		
		int roleCode = Integer.parseInt(request.getParameter("id"));
		
		RoleModel existingRole = RoleDataAccessObject.readOne(roleCode);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/role-update.jsp");
		request.setAttribute("myRole", existingRole);
		dispatcher.forward(request, response);

	}
	
	/*********************************************************************************
	// Show form to DELETE record
	**********************************************************************************/
	private void showDeleteForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: showDeleteForm \n ");
		
		int roleCode = Integer.parseInt(request.getParameter("id"));
		
		RoleModel existingRole = RoleDataAccessObject.readOne(roleCode);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/role-delete.jsp");
		request.setAttribute("myRole", existingRole);
		dispatcher.forward(request, response);

	}

	/*********************************************************************************
	// Insert database table record
	**********************************************************************************/
	private void insertRole(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: insertRole \n ");
		
		int RoleCode = Integer.parseInt(request.getParameter("code"));
		String RoleStatus = request.getParameter("status");
		String RoleName = request.getParameter("name");
		String RoleDescription = request.getParameter("description");
		double RoleSalary = Double.parseDouble(request.getParameter("salary"));
		double RoleBonus = Double.parseDouble(request.getParameter("bonus"));
		String RoleCurrency = request.getParameter("currency");
			
		RoleModel newRole = new RoleModel(RoleCode, RoleStatus, RoleName, RoleDescription, RoleSalary, RoleBonus, RoleCurrency);
		RoleDataAccessObject.insertRole(newRole);
		
		response.sendRedirect("listRole");
		
	}

	/*********************************************************************************
	// Update database table record
	**********************************************************************************/
	private void updateRole(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {		
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: updateRole \n ");
		
		int RoleCode = Integer.parseInt(request.getParameter("code"));
		String RoleStatus = request.getParameter("status");
		String RoleName = request.getParameter("name");
		String RoleDescription = request.getParameter("description");
		double RoleSalary = Double.parseDouble(request.getParameter("salary"));
		double RoleBonus = Double.parseDouble(request.getParameter("bonus"));
		String RoleCurrency = request.getParameter("currency");
		
		RoleModel newRole = new RoleModel(RoleCode, RoleStatus, RoleName, RoleDescription, RoleSalary, RoleBonus, RoleCurrency);
		RoleDataAccessObject.updateRole(newRole);
		
		response.sendRedirect("listRole");
		
	}

	/*********************************************************************************
	// Delete database table record
	**********************************************************************************/
	private void deleteRole(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: deleteRole \n ");  
		
		int objectKey = Integer.parseInt(request.getParameter("code"));
		RoleDataAccessObject.deleteRole(objectKey);
		response.sendRedirect("listRole");

	}

}
