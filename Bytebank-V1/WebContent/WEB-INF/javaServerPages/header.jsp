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

<header class="fixed-top">

	<nav class="navbar navbar-expand-md navbar-dark" style="background-color: blue">
		
		<div>	      	
			<a href="<%=request.getContextPath()%>/home" class="navbar-brand"><img class="header-logo" src="resources/img/bytebank-logo.png" alt="ByteBank Logo "></a>
		</div>

		<ul class="navbar-nav">
			<li><a href="<%=request.getContextPath()%>/home" class="nav-link">Your Digital Bank Manager</a></li>
		</ul>
		
	</nav>
	
</header>