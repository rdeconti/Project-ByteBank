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

<header>

	<div class="header-container">
	
		<a class="header-anchor" href="<%=request.getContextPath()%>/HomeServlet"><img class="header-logo" src="resources/img/bytebank-logo.png" alt="ByteBank Logo"></a>  

		<a class="header-anchor-menu" href="<%=request.getContextPath()%>/HomeServlet">Home</a>
		<a class="header-anchor-menu" href="#contact">Contact</a>
		<a class="header-anchor-menu" href="#about">About</a>
		
	</div>

</header>



