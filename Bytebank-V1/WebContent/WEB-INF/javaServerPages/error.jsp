<!--
********************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
********************************************************************************
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1 " pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<!----------------------------------------------------------------- START HTML -->
<html>

	<!------------------------------------------------------------- START HEAD -->
	<head>
	
	  <meta charset="UTF-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1.0">
	  
	  <!-- Reset style sheets ---------------------------------------------------->
	  <link rel="stylesheet" href="WEB-INF-CascadingStyleSheets/reset.css">
	  
	  <!-- Windows FAVICON  ----------------------------------------------------->
	  <link rel="shortcut icon" href="WEB-INF-favicon/favicon.ico" />
	  
	  <!-- Windows tab name ----------------------------------------------------->
	  <title>ByteBank | Error</title>
	  
	  <!-- https://fonts.google.com/ -------------------------------------------->
	  <link
	      href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
	      rel="stylesheet">
	      
	</head>
	
 	<!------------------------------------------------------------- START BODY -->
	<body>
	
		<h1>DESCULPE OCORREU UM ERRO. POR FAVOR TENTE NOVAMENTE</h1>
		<br>
		<h2>Verifique o erro: ${mensagem}</h2>
		<br>
		<a href="menu.jsp">Voltar</a>
	
	</body>
	
</html>