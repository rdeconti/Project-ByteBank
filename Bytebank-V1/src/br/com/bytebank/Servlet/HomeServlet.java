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

import br.com.bytebank.DataAccessObject.AccountDataAccessObject;
import br.com.bytebank.DataAccessObject.BankDataAccessObject;
import br.com.bytebank.DataAccessObject.BranchDataAccessObject;
import br.com.bytebank.DataAccessObject.CustomerDataAccessObject;
import br.com.bytebank.DataAccessObject.EmployeeDataAccessObject;
import br.com.bytebank.DataAccessObject.PackageDataAccessObject;
import br.com.bytebank.DataAccessObject.RoleDataAccessObject;
import br.com.bytebank.DataAccessObject.StatamentDataAccessObject;
import br.com.bytebank.DataAccessObject.TransferDataAccessObject;
import br.com.bytebank.DataAccessObject.UserDataAccessObject;

import br.com.bytebank.Model.AccountModel;
import br.com.bytebank.Model.BankModel;
import br.com.bytebank.Model.BranchModel;
import br.com.bytebank.Model.CustomerModel;
import br.com.bytebank.Model.EmployeeModel;
import br.com.bytebank.Model.PackageModel;
import br.com.bytebank.Model.RoleModel;
import br.com.bytebank.Model.StatamentModel;
import br.com.bytebank.Model.TransferModel;
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
@WebServlet("/HomeServlet")

/*********************************************************************************
// Treat CRUD to database: table PACKAGE
**********************************************************************************/
public class HomeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private AccountDataAccessObject AccountDataAccessObject;
	private BankDataAccessObject BankDataAccessObject;
	private BranchDataAccessObject BranchDataAccessObject;
	private CustomerDataAccessObject CustomerDataAccessObject;
	private EmployeeDataAccessObject EmployeeDataAccessObject;
	private PackageDataAccessObject PackageDataAccessObject;
	private RoleDataAccessObject RoleDataAccessObject;
	private StatamentDataAccessObject StatamentDataAccessObject;
	private TransferDataAccessObject TransferDataAccessObject;
	private UserDataAccessObject UserDataAccessObject;
	
	/*****************************************************************************
	// Initialization
	******************************************************************************/
	public void init() {
		
		AccountDataAccessObject = new AccountDataAccessObject();
		BankDataAccessObject = new BankDataAccessObject();
		BranchDataAccessObject = new BranchDataAccessObject();
		CustomerDataAccessObject = new CustomerDataAccessObject();
		EmployeeDataAccessObject = new EmployeeDataAccessObject();
		PackageDataAccessObject = new PackageDataAccessObject();
		RoleDataAccessObject = new RoleDataAccessObject();
		StatamentDataAccessObject = new StatamentDataAccessObject();
		TransferDataAccessObject = new TransferDataAccessObject();
		UserDataAccessObject = new UserDataAccessObject();
		
	}

	/*****************************************************************************
	// Treat application doPOST
	******************************************************************************/
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
					
	 	String submitAction = request.getParameter("submitAction");
	 	System.out.print("CONSOLE -- ENTROU NA SERVLET HOME: doPost " + submitAction + "\n " );	 	
	 	
		try {
			
			switch (submitAction) {
								
				case "ListAccount":
					listAccount(request, response);
					break;

				case "ListBank":
					listBank(request, response);
					break;
									
				case "ListBranch":
					listBranch(request, response);
					break;
					
				case "ListCustomer":
					listCustomer(request, response);
					break;
					
				case "ListEmployee":
					listEmployee(request, response);
					break;
					
				case "ListPackage":
					listPackage(request, response);
					break;
					
				case "ListRole":
					listRole(request, response);
					break;
					
				case "ListStatament":
					listStatament(request, response);
					break;
					
				case "ListTransfer":
					listTransfer(request, response);
					break;
					
				case "ListUser":
					listUser(request, response);
					break;
					
				default:
				case "HomeServlet":
					showHomePage(request, response);
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
		System.out.print("CONSOLE -- ENTROU NA SERVLET HOME: doGet action " + action + "\n " );

		try {
			
			switch (action) {
			
				case "/listAccount":
					listAccount(request, response);
					break;
	
				case "/listBank":
					listBank(request, response);
					break;
									
				case "/listBranch":
					listBranch(request, response);
					break;
					
				case "/listCustomer":
					listCustomer(request, response);
					break;
					
				case "/listEmployee":
					listEmployee(request, response);
					break;
					
				case "/listPackage":
					listPackage(request, response);
					break;
					
				case "/listRole":
					listRole(request, response);
					break;
					
				case "/listStatament":
					listStatament(request, response);
					break;
					
				case "/listTransfer":
					listTransfer(request, response);
					break;
					
				case "/listUser":
					listUser(request, response);
					break;
					
				default:
				case "/HomeServlet":
					showHomePage(request, response);
					break;
					
			}
			
		} catch (SQLException ex) {
			
			throw new ServletException(ex);
			
		}
		
	}

	/*********************************************************************************
	// List all records from database table
	**********************************************************************************/
	private void listAccount(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
			
		System.out.print("CONSOLE -- ENTROU NA SERVLET PACKAGE: listAccount \n ");    
		
		List<AccountModel> listAccount = AccountDataAccessObject.readAll();
		
		request.setAttribute("myAccount", listAccount);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/account-list.jsp");
		dispatcher.forward(request, response);
		
	}
	
	/*********************************************************************************
	// List all records from database table
	**********************************************************************************/
	private void listBank(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
			
		System.out.print("CONSOLE -- ENTROU NA SERVLET bank: listbank \n ");    
		
		List<BankModel> listbank = BankDataAccessObject.readAll();
		
		request.setAttribute("mybank", listbank);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/bank-list.jsp");
		dispatcher.forward(request, response);
		
	}
	
	/*********************************************************************************
	// List all records from database table
	**********************************************************************************/
	private void listBranch(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
			
		System.out.print("CONSOLE -- ENTROU NA SERVLET branch: listbranch \n ");    
		
		List<BranchModel> listbranch = BranchDataAccessObject.readAll();
		
		request.setAttribute("mybranch", listbranch);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/branch-list.jsp");
		dispatcher.forward(request, response);
		
	}
	
	/*********************************************************************************
	// List all records from database table
	**********************************************************************************/
	private void listCustomer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
			
		System.out.print("CONSOLE -- ENTROU NA SERVLET customer: listcustomer \n ");    
		
		List<CustomerModel> listcustomer = CustomerDataAccessObject.readAll();
		
		request.setAttribute("mycustomer", listcustomer);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/customer-list.jsp");
		dispatcher.forward(request, response);
		
	}
	
	/*********************************************************************************
	// List all records from database table
	**********************************************************************************/
	private void listEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
			
		System.out.print("CONSOLE -- ENTROU NA SERVLET employee: listemployee \n ");    
		
		List<EmployeeModel> listemployee = EmployeeDataAccessObject.readAll();
		
		request.setAttribute("myemployee", listemployee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/employee-list.jsp");
		dispatcher.forward(request, response);
				
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
	// List all records from database table
	**********************************************************************************/
	private void listRole(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
			
		System.out.print("CONSOLE -- ENTROU NA SERVLET role: listrole \n ");    
		
		List<RoleModel> listrole = RoleDataAccessObject.readAll();
		
		request.setAttribute("myrole", listrole);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/role-list.jsp");
		dispatcher.forward(request, response);
			
	}
	
	/*********************************************************************************
	// List all records from database table
	**********************************************************************************/
	private void listStatament(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
			
		System.out.print("CONSOLE -- ENTROU NA SERVLET statament: liststatament \n ");    
		
		List<StatamentModel> liststatament = StatamentDataAccessObject.readAll();
		
		request.setAttribute("mystatament", liststatament);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/statament-list.jsp");
		dispatcher.forward(request, response);
				
	}
	
	/*********************************************************************************
	// List all records from database table
	**********************************************************************************/
	private void listTransfer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
			
		System.out.print("CONSOLE -- ENTROU NA SERVLET transfer: listtransfer \n ");    
		
		List<TransferModel> listtransfer = TransferDataAccessObject.readAll();
		
		request.setAttribute("mytransfer", listtransfer);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/transfer-list.jsp");
		dispatcher.forward(request, response);
				
	}
	
	/*********************************************************************************
	// List all records from database table
	**********************************************************************************/
	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
			
		System.out.print("CONSOLE -- ENTROU NA SERVLET user: listuser \n ");    
		
		List<UserModel> listuser = UserDataAccessObject.readAll();
		
		request.setAttribute("myuser", listuser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javaServerPages/user-list.jsp");
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

}
