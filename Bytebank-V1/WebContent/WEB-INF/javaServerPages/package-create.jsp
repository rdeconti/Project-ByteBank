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
		<title>ByteBank | Package Creation</title>
		
		<!------------------------------------------- INCLUDE HEAD DEFINITIONS -->
   		<jsp:include page="head.jsp"/>
			
	</head>
	
 	<!------------------------------------------------------------- START BODY -->
	<body>

		<!----------------------------------------------------- INCLUDE HEADER -->
   		<jsp:include page="header-page.jsp"/>
	
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
					
						<input type="submit" value="CreatePackage" name="submitAction">
						
					</form>
	
				</div>
				
			</div>
			
		</div>
	
		<!----------------------------------------------------- INCLUDE FOOTER -->
   		<jsp:include page="footer-page.jsp"/>
		
	</body>
	
</html>
