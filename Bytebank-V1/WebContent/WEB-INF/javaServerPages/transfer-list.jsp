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
       	<br />
       	<br />

		<div class="row">
		
			<div class="container">
			
				<h3 class="text-center">List of ByteBank Packages</h3>
				
				<hr>
				
				<div class="container text-left">
	
					<a href="<%=request.getContextPath()%>/createPackage" class="btn btn-success">Create package</a>
					
				</div>
				
				<br>
				
				<table class="table table-bordered">
				
					<thead>
					
						<tr>
						
							<th>Code</th>
							<th>Status</th>
							<th>Level</th>
							<th>Name</th>
							<th>Description</th>
							<th>Limit</th>
							<th>Tax</th>
							<th>Actions</th>
							
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
									<a href="updatePackage?id=<c:out value='${myPackage.packageCode}' />">Update</a>
									&nbsp;&nbsp;&nbsp;&nbsp; 
									<a href="deletePackage?id=<c:out value='${myPackage.packageCode}' />">Delete</a>
								</td>
									
							</tr>
							
						</c:forEach>
											
					</tbody>
	
				</table>
				
			</div>
			
		</div>
		
		<!----------------------------------------------------- INCLUDE FOOTER -->
   		<jsp:include page="footer.jsp"/>
		
	</body>
	
</html>