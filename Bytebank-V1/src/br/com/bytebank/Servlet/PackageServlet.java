/*************************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
**************************************************************************************/
package br.com.bytebank.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.bytebank.DataAccessObject.PackageDataAccessObject;
import br.com.bytebank.Model.PackageModel;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*************************************************************************************
Servlet implementation class
**************************************************************************************/
@WebServlet("/Package")

/*************************************************************************************
Servlet implementation class
**************************************************************************************/
public class PackageServlet extends HttpServlet {
	
	/*********************************************************************************
	Initialize Data Access Object
	**********************************************************************************/
	public void init() {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: init \n ");
		
		new PackageDataAccessObject();
		
	}
       
	/*********************************************************************************
	// TODO Definition is pending
	**********************************************************************************/
    public PackageServlet() {
    	
        super();
        
        // TODO Auto-generated constructor stub
    }

	/*********************************************************************************
	// TODO Definition is pending
	**********************************************************************************/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: doPost \n ");  
		
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}
    
	/*********************************************************************************
	// TODO Definition is pending
	**********************************************************************************/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: doGet \n ");
		
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
				
		String submitAction= request.getParameter("submitAction");
		
		if (submitAction == null) {
			submitAction = "mantain";
		}
		
		System.out.print("CONSOLE -- BUTTON = " + submitAction + "\n");
		
		String stringCode = request.getParameter("packageCode");
		System.out.print("CONSOLE -- ENTROU stringCode: " +  stringCode + "\n ");

		try {
			
			switch (submitAction) {
			
				case "mantain":
					showUpdateForm(request, response);
					break;
				
				case "/new":
					showInsertForm(request, response);
					break;
			
				case "Create":
					insertPackage(request, response);
					break;
					
				case "update":
					showUpdateForm(request, response);
					break;
					
				case "Update":
					updatePackage(request, response);
					break;
					
				case "Delete":
					deletePackage(request, response);
					break;

				default:
					listPackages(request, response);
					break;
			}
			
		} catch (SQLException ex) {
			
			throw new ServletException(ex);
			
		}		
	}
	
	/*********************************************************************************
	// Treat show change form
	**********************************************************************************/
	private void showUpdateForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: showUpdateForm \n ");
		
		String stringCode = request.getParameter("packageCode");
		System.out.print("CONSOLE -- ENTROU stringCode: " +  stringCode + "\n ");
		
		int packageCode = Integer.parseInt(request.getParameter("packageCode"));
			
		PackageModel existingPackage = PackageDataAccessObject.readOne(packageCode);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("packageform.jsp");
		
		request.setAttribute("package", existingPackage);
		
		dispatcher.forward(request, response);

	}
	
	/*********************************************************************************
	// Treat show insert form
	**********************************************************************************/
	private void showInsertForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: showInsertForm \n ");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("packageForm.jsp");
		
		dispatcher.forward(request, response);
		
	}
	
	/*********************************************************************************
	// Treat insert object
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
		
		// response.sendRedirect("list");
		System.out.print("CONSOLE -- GERAR LISTA DEPOIS DO INSERT \n ");    
		
		List<PackageModel> listPackage = PackageDataAccessObject.readAll();
		
		request.setAttribute("myPackage", listPackage);
		
		response.sendRedirect("package.jsp");
		
		
		
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("package.jsp");
//		
//		try {
//			requestDispatcher.forward(request, response);
//		} catch (ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
	}
	
	/*********************************************************************************
	// Treat delete object
	**********************************************************************************/
	private void deletePackage(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: deletePackage \n ");  
		
		int objectKey = Integer.parseInt(request.getParameter("code"));
		
		PackageDataAccessObject.deletePackage(objectKey);
		
		response.sendRedirect("list");

	}
	
	/*********************************************************************************
	// Treat update object
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
	// Treat list all objects
	**********************************************************************************/
	private void listPackages(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: listPackage \n ");    
		
		List<PackageModel> listPackage = PackageDataAccessObject.readAll();
		
		request.setAttribute("myPackage", listPackage);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("package.jsp");
		
		requestDispatcher.forward(request, response);
		
	}

}
