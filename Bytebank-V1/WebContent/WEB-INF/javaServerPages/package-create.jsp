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
   		<jsp:include page="header-home.jsp"/>
       	<br />
       	<br />
	
		<div class="crud-container">
				
			<h2 class="crud-header" >Create ByteBank Package</h2>
			
			<form class="crud-form" method="post" action="PackageServlet">
			
				<div class="crud-input-row">
				
					<div class="crud-input-25">
						<label class="crud-input-label">Package Code</label> 					
					</div>
					
					<div class="crud-input-75">
						<input 
						type="number"
						value="<c:out value='${packageCode}' />" 
						class="crud-input-text"
						name="code" 
						required="required">
					</div>
				
				</div>
				
				<div class="crud-input-row">
				
					<div class="crud-input-25">
						<label class="crud-input-label">Package Status</label> 					
					</div>
					
					<div class="crud-input-75">
						<input 
						type="text"
						value="<c:out value='${packageStatus}' />" 
						class="crud-input-text"
						name="status" 
						required="required"	>
					</div>
				
				</div>
				
				<div class="crud-input-row">
				
					<div class="crud-input-25">
						<label class="crud-input-label">Package Level</label> 
					</div>
					
					<div class="crud-input-75">
						<input 
						type="text"
						value="<c:out value='${packageLevel}' />" 
						class="crud-input-text"
						name="level" 
						required="required">				
					</div>
				
				</div>
				
				<div class="crud-input-row">
				
					<div class="crud-input-25">
						<label class="crud-input-label">Package Name</label> 
					</div>
					
					<div class="crud-input-75">
						<input 
						type="text"
						value="<c:out value='${packageName}' />" 
						class="crud-input-text"
						name="name" 
						required="required">					
					</div>
				
				</div>
				
				<div class="crud-input-row">
				
					<div class="crud-input-25">
						<label class="crud-input-label">Package Description</label> 
					</div>
					
					<div class="crud-input-75">
						<input 
							type="text"
							value="<c:out value='${packageDescription}' />" 
							class="crud-input-text"
							name="description" 
							required="required">					
					</div>
				
				</div>
				
				<div class="crud-input-row">
				
					<div class="crud-input-25">
						<label class="crud-input-label">Package Limit</label> 					
					</div>
					
					<div class="crud-input-75">
						<input 
							type="number"
							value="<c:out value='${packageLimit}' />" 
							class="crud-input-text"
							name="limit" 
							required="required">					
					</div>
				
				</div>
				
				<div class="crud-input-row">
				
					<div class="crud-input-25">
						<label class="crud-input-label">Package Fee</label> 					
					</div>
					
					<div class="crud-input-75">
						<input 
							type="number"
							value="<c:out value='${packageFee}' />" 
							class="crud-input-text"
							name="fee" 
							required="required">					
					</div>
				
				</div>
				
				<input class="crud-button-submit" type="submit" value="CreatePackage" name="submitAction">
				
			</form>
			
		</div>
	
		<!----------------------------------------------------- INCLUDE FOOTER -->
   		<jsp:include page="footer.jsp"/>
		
	</body>
	
</html>
