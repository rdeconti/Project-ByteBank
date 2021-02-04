<!--
***********************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
***********************************************************************************
-->

<!-- Configuring charset and pageEncoding -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Using JSTL core -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!-- Determining HMTL version to server -->
<!DOCTYPE html>

<!----------------------------------------------------------------- START HTML -->
<html lang="pt-br" dir="ltr">

	<!------------------------------------------------------------- START HEAD -->
	<head>
	
		<!-- Defining page title -->
		<title>ByteBank | Package Reporting</title>
		
		<!------------------------------------------- INCLUDE HEAD DEFINITIONS -->
   		<jsp:include page="head.jsp"/>
			
	</head>
	
 	<!------------------------------------------------------------- START BODY -->
	<body class="list-body">
	
		<!----------------------------------------------------- INCLUDE HEADER -->
   		<jsp:include page="header-home.jsp"/>

		<main class="main-container">
		
				<h1 class="main-header">List of Packages</h1>
				
     			<br />
				
				<table class="main-table">
				
					<thead>
					
						<tr>
						
							<th class="main-table-header">Code</th>
							<th class="main-table-header">Status</th>
							<th class="main-table-header">Level</th>
							<th class="main-table-header">Name</th>
							<th class="main-table-header">Description</th>
							<th class="main-table-header">Limit</th>
							<th class="main-table-header">Tax</th>
							<th class="main-table-header">User action</th>
							
						</tr>
						
					</thead>
					
					<tbody>
					
						<jsp:useBean id="dao" class="br.com.bytebank.DataAccessObject.PackageDataAccessObject" scope="request"/> 
																			
						<c:forEach var="myPackage" items="${dao.readAll()}">					
	
							<tr>
															
								<td><c:out value="${myPackage.packageCode}" /></td>
								<td><c:out value="${myPackage.packageStatus}" /></td>
								<td><c:out value="${myPackage.packageLevel}" /></td>
								<td><c:out value="${myPackage.packageName}" /></td>
								<td><c:out value="${myPackage.packageDescription}" /></td>
								<td><c:out value="${myPackage.packageLimit}" /></td>
								<td><c:out value="${myPackage.packageFee}" /></td>
								
								<td>								
											
									<form method="post" action="PackageServlet">
									
										<input type="hidden" name="id" value=<c:out value='${myPackage.packageCode}' />>
																											
										<button class="custom-icon-button" type="submit" value="/updatePackage" name="submitAction" ><span><i class="fas fa-user-edit custom-icon-list"></i></span></button>
										<button class="custom-icon-button" type="submit" value="/deletePackage" name="submitAction" ><span><i class="fas fa-trash-alt custom-icon-list"></i></span></button>																			
										<button class="custom-icon-button" type="submit" value="/createPackage" name="submitAction" ><span><i class="fas fa-plus-circle custom-icon-list"></i></span></button>
																		
									</form>
						
								</td>
			
							</tr>
							
						</c:forEach>
											
					</tbody>
	
				</table>
				
    			<br />
				
		</main>
		
		<!----------------------------------------------------- INCLUDE FOOTER -->
   		<jsp:include page="footer.jsp"/>
		
	</body>
	
</html>