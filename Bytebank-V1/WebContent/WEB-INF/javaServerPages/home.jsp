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
		<title>ByteBank | Home</title>
		
		<!------------------------------------------- INCLUDE HEAD DEFINITIONS -->
   		<jsp:include page="head.jsp"/>
			
	</head>
	
 	<!------------------------------------------------------------- START BODY -->
	<body>
	
		<!----------------------------------------------------- INCLUDE HEADER -->
   		<jsp:include page="header.jsp"/>
   		
    	<!------------------------------------------------- INCLUDE NAVIGATION -->
		<jsp:include page="navigation.jsp"/>
       	<br />
       	<br />
   		
		<!------------------------------------------------------- INCLUDE MAIN -->
   		<main class="container-fluid p-0 pr-sm-3 pl-sm-3">
   		

       	
       	
	       	
  
   		
   		</main>
   		
    	<!-------------------------------------------------- INCLUDE FOOTER -->
    	<br />
       	<br />
   		<jsp:include page="footer.jsp"/>  
   		
   		<!-- TODO VERIFICAR TODOS JAVASCRIPTS -->
		<!---------------------------------------------------------- JAVASCRIPT -->
   		<script>
   		
			function myFunction() {
			  var x = document.getElementById("myTopnav");
			  if (x.className === "topnav") {
			    x.className += " responsive";
			  } else {
			    x.className = "topnav";
			  }
			}
			
		</script>
   		      	
	</body>
	
</html>