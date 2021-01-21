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
	
		<title>ByteBank - Package Creation</title>
		
		<link rel="stylesheet"
			href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
			crossorigin="anonymous">
			
	</head>
	
	<body>

		<header>
		
			<nav class="navbar navbar-expand-md navbar-dark"
			
				style="background-color: blue">
				
				<div>
					<a href="https://www.javaguides.net" class="navbar-brand"> ByteBank Application </a>
				</div>
	
				<ul class="navbar-nav">
				
					<li><a href="<%=request.getContextPath()%>/list" class="nav-link">Packages</a></li>
					
				</ul>
				
			</nav>
			
		</header>
	
		<br>
	
		<div class="container col-md-5">
		
			<div class="card">
			
				<div class="card-body">
				
					<h2>Create ByteBank Package</h2>
					
					<form method="post" action="PackageServlet">
					
						<fieldset class="form-group">
							<label>Package Code</label> 
							<input 
								type="number"
								value="<c:out value='${packageCode}' />" 
								class="form-control"
								name="code" 
								required="required">
						</fieldset>
		
						<fieldset class="form-group">
							<label>Package Status</label> 
							<input 
								type="text"
								value="<c:out value='${packageStatus}' />" 
								class="form-control"
								name="status" 
								required="required"	>
						</fieldset>
		
						<fieldset class="form-group">
							<label>Package Level</label> 
							<input 
								type="text"
								value="<c:out value='${packageLevel}' />" 
								class="form-control"
								name="level" 
								required="required">
						</fieldset>
		
						<fieldset class="form-group">
							<label>Package Name</label> 
							<input 
								type="text"
								value="<c:out value='${packageName}' />" 
								class="form-control"
								name="name" 
								required="required">
						</fieldset>
						
						<fieldset class="form-group">
							<label>Package Description</label> 
							<input 
								type="text"
								value="<c:out value='${packageDescription}' />" 
								class="form-control"
								name="description" 
								required="required">
						</fieldset>
						
						<fieldset class="form-group">
							<label>Package Limit</label> 
							<input 
								type="number"
								value="<c:out value='${packageLimit}' />" 
								class="form-control"
								name="limit" 
								required="required">
						</fieldset>
						
						<fieldset class="form-group">
							<label>Package Fee</label> 
							<input 
								type="number"
								value="<c:out value='${packageFee}' />" 
								class="form-control"
								name="fee" 
								required="required">
						</fieldset>
					
						<input type="submit" value="Create" name="submitAction">
						
					</form>
	
				</div>
				
			</div>
			
		</div>
	
	</body>
	
</html>
