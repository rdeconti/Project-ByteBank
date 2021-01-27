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
		<title>ByteBank | Login</title>
		
		<!------------------------------------------- INCLUDE HEAD DEFINITIONS -->
   		<jsp:include page="head.jsp"/>
			
	</head>
	
 	<!------------------------------------------------------------- START BODY -->
	<body>
	
		<!----------------------------------------------------- INCLUDE HEADER -->
   		<jsp:include page="header.jsp"/>
       	<br />
       	<br />
       	
		<form method="post" action="UserServlet">
		
			<div class="container">
			
				<div class="division">
				
					<div class="row">
					
				 		<h1>Login your account</h1>
		       
		        	</div>
		        	
		        	<br />
		        	<br />
		        
		           	<div class="input-group">
		           	
						<div class="input-group-prepend">
						
							<span class="input-group-text"><i class="fas fa-user-lock"></i></span>
							
						</div>
						
						<input 
							type="text"
							value="<c:out value='${userName}' />" 
							class="form-control" 							 
							name="username" 
							required="required"
							placeholder="type your username"
						/>
						
					</div>
					
					<br />
		         
		           	<div class="input-group">
		           	
						<div class="input-group-prepend">
						
							<span class="input-group-text"><i class="fa fa-key icon"></i></span>
							
						</div>
												
						<input 
							type="Password"
							value="<c:out value='${userPassword}' />" 
							class="form-control" 							 
							name="password" 
							required="required"
							placeholder="type your password"
						/>
						
						</div>
						
						<br />
						
			            <div class="checkbox">
			            
			              	<label><input type="checkbox" value=""/> Remember me</label>
			              
			            </div>
			            
			            <br />
			            			            
		              	<button type="submit" value="Login" name="submitAction" class="btn btn-success"><span class="glyphicon glyphicon-off"></span>Login</button>	         
		         
			        	<br />
			        	<br />
		               	          		
				        <div class="footer">
				        
		                  	<p>Don't have an Account! <a href="#">Sign Up Here</a></p>
			          		<p>Forgot <a href="#">Password ?</a></p>
			          		
				        </div>
					
					</div>
	 
			</div>
		
		</form>	
		
	</body>
	
</html>