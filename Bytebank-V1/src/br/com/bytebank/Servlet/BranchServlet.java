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

import br.com.bytebank.DataAccessObject.BranchDataAccessObject;
import br.com.bytebank.Model.BranchModel;

/*********************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
**********************************************************************************/

/*********************************************************************************
// Addressing servlet
**********************************************************************************/
@WebServlet("/BranchServlet")

/*********************************************************************************
// Treat CRUD to database: table PACKAGE
**********************************************************************************/
public class BranchServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private BranchDataAccessObject BranchDataAccessObject;
	
	/*****************************************************************************
	// Initialization
	******************************************************************************/
	public void init() {
			
		BranchDataAccessObject = new BranchDataAccessObject();
		
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
								
				case "CreateBranch":
					insertBranch(request, response);
					break;

				case "DeleteBranch":
					deleteBranch(request, response);
					break;
									
				case "UpdateBranch":
					updateBranch(request, response);
					break;
					
				default:
				case "ListBranch":
					listBranch(request, response);
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
			
				case "/createBranch":
					showCreateForm(request, response);
					break;

				case "/updateBranch":
					showUpdateForm(request, response);
					break;
					
				case "/deleteBranch":
					showDeleteForm(request, response);
					break;
					
				case "/homeBranch":
					showHomePage(request, response);
					break;
					
				default:
				case "/listBranch":
					listBranch(request, response);
					break;
					
			}
			
		} catch (SQLException ex) {
			
			throw new ServletException(ex);
			
		}
		
	}

	/*********************************************************************************
	// List all records from database table
	**********************************************************************************/
	private void listBranch(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
			
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: listBranch \n ");    
		
		List<BranchModel> listBranch = BranchDataAccessObject.readAll();
		
		request.setAttribute("myBranch", listBranch);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/branch-list.jsp");
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
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/branch-create.jsp");
		dispatcher.forward(request, response);
		
	}

	/*********************************************************************************
	// Show form to UPDATE record
	**********************************************************************************/
	private void showUpdateForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: showUpdateForm \n ");
		
		int branchCode = Integer.parseInt(request.getParameter("id"));
		
		BranchModel existingBranch = BranchDataAccessObject.readOne(branchCode);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/branch-update.jsp");
		request.setAttribute("myBranch", existingBranch);
		dispatcher.forward(request, response);

	}
	
	/*********************************************************************************
	// Show form to DELETE record
	**********************************************************************************/
	private void showDeleteForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: showDeleteForm \n ");
		
		int branchCode = Integer.parseInt(request.getParameter("id"));
		
		BranchModel existingBranch = BranchDataAccessObject.readOne(branchCode);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/branch-delete.jsp");
		request.setAttribute("myBranch", existingBranch);
		dispatcher.forward(request, response);

	}

	/*********************************************************************************
	// Insert database table record
	**********************************************************************************/
	private void insertBranch(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: insertBranch \n ");
		
		int BranchCode = Integer.parseInt(request.getParameter("code"));
		String BranchStatus = request.getParameter("status");
		String BranchName = request.getParameter("name");
		int BranchAddress = Integer.parseInt(request.getParameter("address"));
		int BranchContact = Integer.parseInt(request.getParameter("contact"));
		int BranchEmployee = Integer.parseInt(request.getParameter("employee"));
		int BranchBank = Integer.parseInt(request.getParameter("bank"));
			
		BranchModel newBranch = new BranchModel(BranchCode, BranchStatus, BranchName, BranchAddress, BranchContact, BranchEmployee, BranchBank);
		BranchDataAccessObject.insertBranch(newBranch);
		
		response.sendRedirect("list");
		
	}

	/*********************************************************************************
	// Update database table record
	**********************************************************************************/
	private void updateBranch(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {		
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: updateBranch \n ");
		
		int BranchCode = Integer.parseInt(request.getParameter("code"));
		String BranchStatus = request.getParameter("status");
		String BranchName = request.getParameter("name");
		int BranchAddress = Integer.parseInt(request.getParameter("address"));
		int BranchContact = Integer.parseInt(request.getParameter("contact"));
		int BranchEmployee = Integer.parseInt(request.getParameter("employee"));
		int BranchBank = Integer.parseInt(request.getParameter("bank"));
		
		BranchModel newBranch = new BranchModel(BranchCode, BranchStatus, BranchName, BranchAddress, BranchContact, BranchEmployee, BranchBank);
		BranchDataAccessObject.updateBranch(newBranch);
		
		response.sendRedirect("list");
		
	}

	/*********************************************************************************
	// Delete database table record
	**********************************************************************************/
	private void deleteBranch(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: deleteBranch \n ");  
		
		int objectKey = Integer.parseInt(request.getParameter("code"));
		BranchDataAccessObject.deleteBranch(objectKey);
		response.sendRedirect("list");

	}

}
