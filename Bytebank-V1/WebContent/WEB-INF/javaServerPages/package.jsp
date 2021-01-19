<!--
********************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
********************************************************************************
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1 " pageEncoding="UTF-8"%>

<!DOCTYPE html>

<!----------------------------------------------------------------- START HTML -->
<html lang="pt-br" dir="ltr">

	<!------------------------------------------------------------- START HEAD -->
	<head>
	
	  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

	  <meta charset="UTF-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1.0">
	  
	  <!-- Reset style sheets ---------------------------------------------------->
	  <link rel="stylesheet" href="WEB-INF-CascadingStyleSheets/reset.css">
	
	   <!-- Style sheets --------------------------------------------------------->
   	  <link rel="stylesheet" href="WEB-INF-CascadingStyleSheets/current-date.css">
   	  <link rel="stylesheet" href="WEB-INF-CascadingStyleSheets/footer.css">
  	  <link rel="stylesheet" href="WEB-INF-CascadingStyleSheets/header.css">
	  <link rel="stylesheet" href="WEB-INF-CascadingStyleSheets/package.css">
	  
	  <!-- Windows FAVICON  ----------------------------------------------------->
	  <link rel="shortcut icon" href="WEB-INF-favicon/favicon.ico" />
	  
	  <!-- Windows tab name ----------------------------------------------------->
	  <title>ByteBank | Packages</title>
	  
	  <!-- https://fonts.google.com/ -------------------------------------------->
	  <link
	      href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
	      rel="stylesheet">
	      
	</head>
	
 	<!------------------------------------------------------------- START BODY -->
	<body>

  		<p class="current-date" id="current-date"></p>
  		
		<!----------------------------------------------------- INCLUDE HEADER -->
    	<%@include file="../javaServerPages/header.jsp" %>

		<!-------------------------------------------------------- START PARTS -->
		<div class="part-total">
		
			<div class="part-left">
			
				<h2>Menu options</h2>
						
				<nav>
				
					<ul>
					  	    
					<li><a class="a-menu" href="#">Account</a></li>
					<li><a class="a-menu" href="#">Address</a></li>
					<li><a class="a-menu" href="#">Bank</a></li>		      
					<li><a class="a-menu" href="#">Branch</a></li>
					<li><a class="a-menu" href="#">Contact</a></li>
					<li><a class="a-menu" href="#">Customer</a></li>		
					<li><a class="a-menu" href="#">Employee</a></li>
					<li><a class="a-menu" href="#">Package</a></li>
					<li><a class="a-menu" href="#">Role</a></li>
					<li><a class="a-menu" href="#">Statement</a></li>
					<li><a class="a-menu" href="#">Transfer</a></li>		      
					<li><a class="a-menu" href="#">User</a></li>	
						         		      
					</ul>
				  
				</nav>
			
			</div>
			
			<div class="part-central">
			
				<h2>List of bank packages</h2>
						
				<table>
				
					<thead>
					
						<tr>
							<th>Code</th>
							<th>Status</th>
							<th>Level</th>
							<th>Name</th>
							<th>Limit</th>
							<th>Tax</th>
							
						</tr>
						
					</thead>
				
					<tbody>
						
						<jsp:useBean id="dao" class="br.com.bytebank.DataAccessObject.PackageDataAccessObject" scope="request"/> 
				
						<c:forEach var="myPackage" items="${dao.readAll()}" varStatus="id" >
						
							<tr>
													
								<td>${myPackage.packageCode}</td>
								<td>${myPackage.packageStatus}</td>
								<td>${myPackage.packageLevel}</td>
								<td>${myPackage.packageName}</td>
								<td>${myPackage.packageDescription}</td>
								<td>${myPackage.packageLimit}</td>
								<td>${myPackage.packageFee}</td>
								<!-- <td><a href="Servlet?action=editar&id" >Change</a></td> -->
								<!-- <td><a href="Servlet?action=deletar&id" >Delete</a></td> -->
								
							</tr>	
												
						</c:forEach>
												
					</tbody>
				
				</table>
			
			</div>
		
			<div class="part-rigth">
			
				<h2>Maintenance of bank packages</h2>
				
				<form method="post" action="PackageServlet">
				
					<fieldset>
					
						<label>Code</label>					
						<input type="text" name="code" required value="${PackageModel.PackageCode}" placeholder="Ativo" />
						<br/>
						<br/>
					
						<label>Status</label>					
						<input type="text" name="status" required value="${PackageModel.PackageStatus}" placeholder="Ativo" />
						<br/>
						<br/>
						
						<label>Level</label>					
						<input type="text" name="level" required value="${PackageModel.PackageLevel}" placeholder="Prime" />
						<br/>
						<br/>
						
						<label>Name</label>					
						<input type="text" name="name" required value="${PackageModel.PackageName}" placeholder="Prime" />
						<br/>
						<br/>
						
						<label>Description</label>					
						<input type="text" name="description" required value="${PackageModel.PackageDescription}" placeholder="Prime" />
						<br/>
						<br/>
						
						<label>Limit</label>					
						<input type="text" name="limit" required value="${PackageModel.PackageLimit}" placeholder="5.000,00" />
						<br/>
						<br/>
						
						<label>Tax</label>					
						<input type="text" name="fee" required value="${PackageModel.PackageFee}" placeholder="2%" />
						<br/>
						<br/>
						
						<input type="submit" value="Update"> 				
						<input type="submit" value="Delete"> 
						<input type="submit" value="Create"> 
						<br/>
						<br/>
						
					</fieldset>
					
				</form>
					
			</div>
		
		</div>


		<!------------------------------------------------------ INCLUDE FOOTER -->
    	<%@include file="../javaServerPages/footer.jsp" %>
				
		<!---------------------------------------------------- START JAVASCRIPT -->
		<script>
			var d = new Date();
			document.getElementById("current-date").innerHTML = d;
		</script>
				
	</body>
	
</html>