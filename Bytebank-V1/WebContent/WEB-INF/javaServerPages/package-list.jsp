<!--
********************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
********************************************************************************
-->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

	<head>
	
		<title>ByteBank - Package Report</title>
		
		<link rel="stylesheet"
		
			href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
			crossorigin="anonymous">
			
	</head>
	
	<body>
	
		<header>
		
			<nav class="navbar navbar-expand-md navbar-dark" style="background-color: blue">
				
				<div>
					<a href="https://www.javaguides.net" class="navbar-brand"> ByteBank Application </a>
				</div>
	
				<ul class="navbar-nav">
					<li><a href="<%=request.getContextPath()%>/list" class="nav-link">Packages</a></li>
				</ul>
				
			</nav>
			
		</header>
		
		<br>

		<div class="row">
		
			<div class="container">
			
				<h3 class="text-center">List of ByteBank Packages</h3>
				
				<hr>
				
				<div class="container text-left">
	
					<a href="<%=request.getContextPath()%>/create" class="btn btn-success">Create package</a>
					
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
									<a href="update?id=<c:out value='${myPackage.packageCode}' />">Update</a>
									&nbsp;&nbsp;&nbsp;&nbsp; 
									<a href="delete?id=<c:out value='${myPackage.packageCode}' />">Delete</a>
								</td>
									
							</tr>
							
						</c:forEach>
											
					</tbody>
	
				</table>
				
			</div>
			
		</div>
		
	</body>
	
</html>