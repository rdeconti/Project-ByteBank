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
import jakarta.servlet.http.HttpSession;
import br.com.bytebank.DataAccessObject.UserDataAccessObject;
import br.com.bytebank.Model.UserModel;

/*********************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
**********************************************************************************/

/*********************************************************************************
// Addressing servlet
**********************************************************************************/
@WebServlet("/UserServlet")

/*********************************************************************************
// Treat CRUD to database: table USER
**********************************************************************************/
public class UserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private UserDataAccessObject UserDataAccessObject;
	
	/*****************************************************************************
	// Initialization
	******************************************************************************/
	public void init() {
			
		UserDataAccessObject = new UserDataAccessObject();
		
	}

	/*****************************************************************************
	// Treat application doPOST
	******************************************************************************/
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
					
	 	String submitAction = request.getParameter("submitAction");
	 	System.out.print("CONSOLE -- ENTROU NA SERVLET USER: doPost " + submitAction + "\n " );	

		try {
			
			switch (submitAction) {
								
				case "Create":
					insertUser(request, response);
					break;

				case "Delete":
					deleteUser(request, response);
					break;
									
				case "Update":
					updateUser(request, response);
					break;
					
				case "Login":
					loginUser(request, response);
					break;
					
				default:
					listUser(request, response);
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
		System.out.print("CONSOLE -- ENTROU NA SERVLET USER: doGet action " + action + "\n " );

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
					listUser(request, response);
					break;
					
			}
			
		} catch (SQLException ex) {
			
			throw new ServletException(ex);
			
		}
		
	}

	/*********************************************************************************
	// List all records from database table
	**********************************************************************************/
	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
			
		System.out.print("CONSOLE -- ENTROU NA SERVLET USER: listUser \n ");    
		
		List<UserModel> listUser = UserDataAccessObject.readAll();
		
		request.setAttribute("myUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/user-list.jsp");
		dispatcher.forward(request, response);
		
		
	}
	
	/*********************************************************************************
	// Show Home Page
	**********************************************************************************/
	private void showHomePage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET USER: showHomePage \n ");   
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/home.jsp");
		dispatcher.forward(request, response);
		
	}

	/*********************************************************************************
	// Show form to CREATE record
	**********************************************************************************/
	private void showCreateForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET USER: showCreateForm \n ");   
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/user-create.jsp");
		dispatcher.forward(request, response);
		
	}

	/*********************************************************************************
	// Show form to UPDATE record
	**********************************************************************************/
	private void showUpdateForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET USER: showUpdateForm \n ");
		
		int UserCode = Integer.parseInt(request.getParameter("id"));
		
		UserModel existingUser = UserDataAccessObject.readOne(UserCode);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/user-update.jsp");
		request.setAttribute("myUser", existingUser);
		dispatcher.forward(request, response);

	}
	
	/*********************************************************************************
	// Show form to DELETE record
	**********************************************************************************/
	private void showDeleteForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET USER: showDeleteForm \n ");
		
		int UserCode = Integer.parseInt(request.getParameter("id"));
		
		UserModel existingUser = UserDataAccessObject.readOne(UserCode);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/user-delete.jsp");
		request.setAttribute("myUser", existingUser);
		dispatcher.forward(request, response);

	}

	/*********************************************************************************
	// Insert database table record
	**********************************************************************************/
	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET USER: insertUser \n ");
		
		int UserCode = Integer.parseInt(request.getParameter("code"));
		String UserStatus = request.getParameter("status");
		String UserLevel = request.getParameter("level");
		int UserFailed = Integer.parseInt(request.getParameter("failed"));
		String UserName = request.getParameter("name");
		String UserPassword = request.getParameter("password");
			
		UserModel newUser = new UserModel(UserCode, UserStatus, UserLevel, UserFailed, UserName, UserPassword);
		UserDataAccessObject.insertUser(newUser);
		
		response.sendRedirect("list");
		
	}

	/*********************************************************************************
	// Update database table record
	**********************************************************************************/
	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {		
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET USER: updateUser \n ");
		
		int UserCode = Integer.parseInt(request.getParameter("code"));
		String UserStatus = request.getParameter("status");
		String UserLevel = request.getParameter("level");
		int UserFailed = Integer.parseInt(request.getParameter("failed"));
		String UserName = request.getParameter("name");
		String UserPassword = request.getParameter("password");
			
		UserModel newUser = new UserModel(UserCode, UserStatus, UserLevel, UserFailed, UserName, UserPassword);
		UserDataAccessObject.updateUser(newUser);
		
		response.sendRedirect("list");
		
	}

	/*********************************************************************************
	// Delete database table record
	**********************************************************************************/
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET USER: deleteUser \n ");  
		
		int objectKey = Integer.parseInt(request.getParameter("code"));
		UserDataAccessObject.deleteUser(objectKey);
		response.sendRedirect("list");

	}

	/*********************************************************************************
	// Login user
	**********************************************************************************/
	private void loginUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		System.out.print("CONSOLE -- ENTROU NA SERVLET USER: loginUser \n ");  
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserModel newUser = new UserModel();
		
		newUser.setUserName(username);
		newUser.setUserPassword(password);

		try {
			
			if (UserDataAccessObject.validateUser(newUser)) {
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/home.jsp");
				
				try {
					dispatcher.forward(request, response);
				
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
				}
				
			} else {
									
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/login-user.jsp");
				
				try {
					dispatcher.forward(request, response);
				
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
				}

			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}

	}
}
