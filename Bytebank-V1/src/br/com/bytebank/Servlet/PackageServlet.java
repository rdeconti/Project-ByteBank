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

import br.com.bytebank.DataAccessObject.PackageDataAccessObject;
import br.com.bytebank.Model.PackageModel;

/*********************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
**********************************************************************************/

// @WebServlet("/PackageServlet")
@WebServlet("/")

/*********************************************************************************
// Treat CRUD to database: table PACKAGE
**********************************************************************************/
public class PackageServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private PackageDataAccessObject PackageDataAccessObject;
	
	/*****************************************************************************
	// Instantiate DAO 
	******************************************************************************/
	public void init() {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: init \n ");  
		
		PackageDataAccessObject = new PackageDataAccessObject();
		
	}

	/*****************************************************************************
	// Treat application doPOST
	******************************************************************************/
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: doPost \n ");  
		
		doGet(request, response);
		
	}

	/*****************************************************************************
	// Treat application doGET
	******************************************************************************/
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: doGet \n ");   

		String action = request.getServletPath();
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: action " + action + "\n " );  
		
		String string1 = new String("/PackageServlet");		
		boolean compareString = string1.equals(action);
		
		if (compareString) {
			
			///// response.getWriter().append("Served at: ").append(request.getContextPath());			
			String submitAction = request.getParameter("/insert");
			System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: submitAction " + submitAction + "\n " );
			
			action = submitAction;
			
		}

		try {
			
			switch (action) {
			
				case "/new":
					showCreateForm(request, response);
					break;
					
				case "/insert":
				case "Create":
					insertPackage(request, response);
					break;
					
				case "/delete":
					deletePackage(request, response);
					break;
					
				case "/edit":
					showUpdateForm(request, response);
					break;
					
				case "/update":
					updatePackage(request, response);
					break;
					
				default:
					listPackage(request, response);
					break;
					
			}
			
		} catch (SQLException ex) {
			
			throw new ServletException(ex);
			
		}
		
	}

	/*********************************************************************************
	// List all records from database table
	**********************************************************************************/
	private void listPackage(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
//		List<User> listUser = userDAO.selectAllUsers();
//		request.setAttribute("listUser", listUser);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
//		dispatcher.forward(request, response);
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: listPackage \n ");    
		
		List<PackageModel> listPackage = PackageDataAccessObject.readAll();	
		request.setAttribute("myPackage", listPackage);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/package-list.jsp");
		dispatcher.forward(request, response);
		
		
	}

	/*********************************************************************************
	// Show form to CREATE record
	**********************************************************************************/
	private void showCreateForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: showCreateForm \n ");   
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/package-form.jsp");
		dispatcher.forward(request, response);
		
	}

	/*********************************************************************************
	// Show form to UPDATE record
	**********************************************************************************/
	private void showUpdateForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
//		int id = Integer.parseInt(request.getParameter("id"));
//		User existingUser = userDAO.selectUser(id);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("package-form.jsp");
//		request.setAttribute("user", existingUser);
//		dispatcher.forward(request, response);
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: showUpdateForm \n ");
		
		int packageCode = Integer.parseInt(request.getParameter("packageCode"));
		PackageModel existingPackage = PackageDataAccessObject.readOne(packageCode);
		RequestDispatcher dispatcher = request.getRequestDispatcher("package-form.jsp");
		request.setAttribute("package", existingPackage);
		dispatcher.forward(request, response);

	}

	/*********************************************************************************
	// Insert database table record
	**********************************************************************************/
	private void insertPackage(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
//		String name = request.getParameter("name");
//		String email = request.getParameter("email");
//		String country = request.getParameter("country");
//		User newUser = new User(name, email, country);
//		userDAO.insertUser(newUser);
//		response.sendRedirect("list");
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: insertPackage \n ");  
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: insertPackage CODE " + request.getParameter("code") + "\n ");
		
		int PackageCode = Integer.parseInt(request.getParameter("code"));
		String PackageStatus = request.getParameter("packageStatus");
		String PackageLevel = request.getParameter("packageLevel");
		String PackageName = request.getParameter("packageName");
		String PackageDescription = request.getParameter("packageDescription");
		double PackageLimit = Double.parseDouble(request.getParameter("packageLimit"));
		double PackageFee = Double.parseDouble(request.getParameter("packageFee"));
			
		PackageModel newPackage = new PackageModel(PackageCode, PackageStatus, PackageLevel, PackageName, PackageDescription, PackageLimit, PackageFee);
		PackageDataAccessObject.insertPackage(newPackage);
		response.sendRedirect("list");
		
	}

	/*********************************************************************************
	// Update database table record
	**********************************************************************************/
	private void updatePackage(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
//		int id = Integer.parseInt(request.getParameter("id"));
//		String name = request.getParameter("name");
//		String email = request.getParameter("email");
//		String country = request.getParameter("country");
//
//		User book = new User(id, name, email, country);
//		userDAO.updateUser(book);
//		response.sendRedirect("list");
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: updatePackage \n ");
		
		int PackageCode = Integer.parseInt(request.getParameter("code"));
		String PackageStatus = request.getParameter("status");
		String PackageLevel = request.getParameter("level");
		String PackageName = request.getParameter("name");
		String PackageDescription = request.getParameter("description");
		double PackageLimit = Double.parseDouble(request.getParameter("limit"));
		double PackageFee = Double.parseDouble(request.getParameter("fee"));
		
		PackageModel newPackage = new PackageModel(PackageCode, PackageStatus, PackageLevel, PackageName, PackageDescription, PackageLimit, PackageFee);
		PackageDataAccessObject.updatePackage(newPackage);
		response.sendRedirect("list");
		
	}

	/*********************************************************************************
	// Delete database table record
	**********************************************************************************/
	private void deletePackage(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
//		int id = Integer.parseInt(request.getParameter("id"));
//		userDAO.deleteUser(id);
//		response.sendRedirect("list");
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: deletePackage \n ");  
		
		int objectKey = Integer.parseInt(request.getParameter("code"));
		PackageDataAccessObject.deletePackage(objectKey);
		response.sendRedirect("list");

	}

}
