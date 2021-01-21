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
				
					<c:if test="${user != null}">
						<form action="update" method="post"></form>
					</c:if>
					
					<c:if test="${user == null}">
						<form action="insert" method="post"></form>
					</c:if>
	
					<caption>
					
						<h2>
						
							<c:if test="${user != null}">
		            			Update Package of Bank
		            		</c:if>
		            		
							<c:if test="${user == null}">
		            			Create Package of Bank
		            		</c:if>
		            		
						</h2>
						
					</caption>
	
					<c:if test="${user != null}">
						<input type="hidden" name="id" value="<c:out value='${packageCode}' />" />
					</c:if>
					
					<form method="post" action="PackageServlet">
					
						<fieldset class="form-group">
							<label>Package Code</label> 
							<input 
								type="number"
								required value="${PackageCode}" 
								class="form-control"
								name="code" 
								required="required">
						</fieldset>
		
						<fieldset class="form-group">
							<label>Package Status</label> 
							<input 
								type="text"
								size="1"
								value="<c:out value='${packageStatus}' />" 
								class="form-control"
								name="packageStatus" 
								required="required"	>
						</fieldset>
		
						<fieldset class="form-group">
							<label>Package Level</label> 
							<input type="text"
								value="<c:out value='${packageLevel}' />" class="form-control"
								name="packageLevel" required="required">
						</fieldset>
		
						<fieldset class="form-group">
							<label>Package Name</label> 
							<input type="text"
								value="<c:out value='${packageName}' />" class="form-control"
								name="packageName" required="required">
						</fieldset>
						
						<fieldset class="form-group">
							<label>Package Description</label> 
							<input type="text"
								value="<c:out value='${packageDescription}' />" class="form-control"
								name="packageDescription" required="required">
						</fieldset>
						
						<fieldset class="form-group">
							<label>Package Limit</label> 
							<input type="number"
								value="<c:out value='${packageLimit}' />" class="form-control"
								name="packageLimit" required="required">
						</fieldset>
						
						<fieldset class="form-group">
							<label>Package Fee</label> 
							<input type="number"
								value="<c:out value='${packageFee}' />" class="form-control"
								name="packageFee" required="required">
						</fieldset>
					
						<input type="submit" value="Create" name="/insert">
						
					</form>
	
				</div>
				
			</div>
			
		</div>
	
	</body>
	
</html>
