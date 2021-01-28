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
       	
       	<main>
       	
   			<form method="post" action="UserServlet">
		
				<div class="login-container">
				
					<h1 class="login-header">Login ByteBank</h1>
		        	<br />
		        	<br />
	        				           	
           			<div class="login-division">
						
						<span><i class="fas fa-user-lock custom-icon"></i></span>
						
						<input 
							type="text"
							value="<c:out value='${userName}' />" 						 
							name="username" 
							required="required"
							placeholder="type your username"
						/>
			
					</div>
					
		        	<br />
					
					<div>
					
						<span><i class="fas fa-key custom-icon"></i></span>
						
						<input 
					
							type="Password"
							value="<c:out value='${userPassword}' />" 							 
							name="password" 
							required="required"
							placeholder="type your password"
						
						/>
						
					</div>
					
		        	<br />
		        	
		            <div>
		            
		              	<label><input type="checkbox" value=""/> Remember me</label>
		              
		            </div>
		            
           		 	<br />
		            
		            <div>
		            
   		              	<button class="header-button" type="submit" value="Login" name="submitAction" >Login</button>	
		            
		            </div>
		            
		        	<br />
		               	          		
			        <div>
			        
	                  	<a class="header-anchor-line" href="#">Don't have an Account ?  Sign Up Here !</a>
     			        
     			        <br />
       			        <br />
		          		
		          		<a class = "header-anchor-line" href="#">Do you forgot password ?</a>
		          		
			        </div>
		        			        	
	        	</div>					
		
			</form>	
       	
       	</main>
       	
		<!----------------------------------------------------- INCLUDE FOOTER -->
       	<br />
       	<br />
   		<jsp:include page="footer.jsp"/>
		
	</body>
	
</html>