<!--
********************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
********************************************************************************
-->


<!-- https://www.nicesnippets.com/snippet/bootstrap-4-page-not-found-404-error-page-design -->
<!-- https://www.journaldev.com/2049/jsp-exception-handling-jsp-error-page -->
<!-- http://www.avajava.com/tutorials/lessons/how-do-i-create-a-jsp-error-page-to-handle-exceptions.html -->


<!-- Configuring charset and pageEncoding -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Using JSTL core -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isErrorPage="true" import="java.io.*"%>

<!-- Determining HMTL version to server -->
<!DOCTYPE html>

<!----------------------------------------------------------------- START HTML -->
<html lang="pt-br" dir="ltr">

	<!------------------------------------------------------------- START HEAD -->
	<head>
	
		<!-- Defining page title -->
		<title>ByteBank | Error found</title>
		
		<!------------------------------------------- INCLUDE HEAD DEFINITIONS -->
   		<jsp:include page="head.jsp"/>
			
	</head>
	
 	<!------------------------------------------------------------- START BODY -->
	<body>
	
		<!----------------------------------------------------- INCLUDE HEADER -->
   		<jsp:include page="header-home.jsp"/>
       	<br />
       	<br />
		
	    <div class="container">
	      <div class="row text-center">
	        <div class="col-lg-6 offset-lg-3 col-sm-6 offset-sm-3 col-12 p-3 error-main">
	          <div class="row">
	            <div class="col-lg-8 col-12 col-sm-10 offset-lg-2 offset-sm-1">
	                         
					<h1 class="m-04"><%=response.getStatus() %></h1>
					
					<h6>Sorry! We had a problem ...</h6>
              
					<p>Please try again!<span class="text-info"> The error was: <%=exception.getMessage()%> </span></p>
	              
	            </div>
	          </div>
	        </div>
	      </div>
	    </div>
	    
   		<!----------------------------------------------------- INCLUDE FOOTER -->
   		<jsp:include page="footer.jsp"/>
	
	</body>
	
</html>