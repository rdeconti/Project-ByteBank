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

	<nav class="navbar navbar-expand-md navbar-dark" style="background-color: blue">
		
		<div>	      	
			<a href="<%=request.getContextPath()%>/home" class="navbar-brand">ByteBank Application</a>
		</div>

		<ul class="navbar-nav">
			<li><a href="<%=request.getContextPath()%>/home" class="nav-link">Your Digital Bank Manager</a></li>
		</ul>
		
	</nav>
	
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	
		<div>	      	
			<a href="<%=request.getContextPath()%>/home" class="navbar-brand">ByteBank Application</a>
			
		</div>
		
		<ul class="navbar-nav">
		
		  <li class="nav-item">
			<a class="nav-link" href="#">Account</a>
		  </li>
		  
		  <li class="nav-item">
		    <a class="nav-link" href="#">Bank</a>
		  </li>
		  
		  <li class="nav-item">
		    <a class="nav-link" href="#">Branch</a>
		  </li>
		  
  		  <li class="nav-item">
		    <a class="nav-link" href="#">Customer</a>
		  </li>
		  
   		  <li class="nav-item">
		    <a class="nav-link" href="#">Employee</a>
		  </li>
		  
   		  <li class="nav-item">
		    <a class="nav-link" href="#">Package</a>
		  </li>
		  
   		  <li class="nav-item">
		    <a class="nav-link" href="#">Role</a>
		  </li>
		  
   		  <li class="nav-item">
		    <a class="nav-link" href="#">Statement</a>
		  </li>
		  
   		  <li class="nav-item">
		    <a class="nav-link" href="#">Transfer</a>
		  </li>
		  
   		  <li class="nav-item">
		    <a class="nav-link" href="#">User</a>
		  </li>
		  
		</ul>
	</nav>
	
</header>