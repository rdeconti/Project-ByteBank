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

/*********************************************************************************
// Addressing servlet
**********************************************************************************/
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
			
		PackageDataAccessObject = new PackageDataAccessObject();
		
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
								
				case "Create":
					insertPackage(request, response);
					break;

				case "Delete":
					deletePackage(request, response);
					break;
									
				case "Update":
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

	/*****************************************************************************
	// Treat application doGET
	******************************************************************************/
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getServletPath();
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: doGet action " + action + "\n " );

		try {
			
			switch (action) {
			
				case "/create":
					showCreateForm(request, response);
					break;

				case "/update":
					showUpdateForm(request, response);
					break;
					
				case "/delete":
					showDeleteForm(request, response);
					break;
					
				case "/home":
					showHomePage(request, response);
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
			
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: listPackage \n ");    
		
		List<PackageModel> listPackage = PackageDataAccessObject.readAll();
		
		request.setAttribute("myPackage", listPackage);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/package-list.jsp");
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
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/package-create.jsp");
		dispatcher.forward(request, response);
		
	}

	/*********************************************************************************
	// Show form to UPDATE record
	**********************************************************************************/
	private void showUpdateForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: showUpdateForm \n ");
		
		int packageCode = Integer.parseInt(request.getParameter("id"));
		
		PackageModel existingPackage = PackageDataAccessObject.readOne(packageCode);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/package-update.jsp");
		request.setAttribute("myPackage", existingPackage);
		dispatcher.forward(request, response);

	}
	
	/*********************************************************************************
	// Show form to DELETE record
	**********************************************************************************/
	private void showDeleteForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: showDeleteForm \n ");
		
		int packageCode = Integer.parseInt(request.getParameter("id"));
		
		PackageModel existingPackage = PackageDataAccessObject.readOne(packageCode);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/package-delete.jsp");
		request.setAttribute("myPackage", existingPackage);
		dispatcher.forward(request, response);

	}

	/*********************************************************************************
	// Insert database table record
	**********************************************************************************/
	private void insertPackage(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: insertPackage \n ");
		
		int PackageCode = Integer.parseInt(request.getParameter("code"));
		String PackageStatus = request.getParameter("status");
		String PackageLevel = request.getParameter("level");
		String PackageName = request.getParameter("name");
		String PackageDescription = request.getParameter("description");
		double PackageLimit = Double.parseDouble(request.getParameter("limit"));
		double PackageFee = Double.parseDouble(request.getParameter("fee"));
			
		PackageModel newPackage = new PackageModel(PackageCode, PackageStatus, PackageLevel, PackageName, PackageDescription, PackageLimit, PackageFee);
		PackageDataAccessObject.insertPackage(newPackage);
		
		response.sendRedirect("list");
		
	}

	/*********************************************************************************
	// Update database table record
	**********************************************************************************/
	private void updatePackage(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {		
		
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
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: deletePackage \n ");  
		
		int objectKey = Integer.parseInt(request.getParameter("code"));
		PackageDataAccessObject.deletePackage(objectKey);
		response.sendRedirect("list");

	}

}
