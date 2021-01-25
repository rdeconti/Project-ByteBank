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
			<a href="<%=request.getContextPath()%>/home" class="navbar-brand"><img src="resources/img/bytebank-logo.png" alt="ByteBank Logo ">ByteBank Application</a>
		</div>

		<ul class="navbar-nav">
			<li><a href="<%=request.getContextPath()%>/home" class="nav-link">Your Digital Bank Manager</a></li>
		</ul>
		
	</nav>
	
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		
		<ul class="navbar-nav">
		
		  <li class="nav-item">
			<a class="nav-link" href="<%=request.getContextPath()%>/listPackage">Account</a>
		  </li>
		  
		  <li class="nav-item">
		    <a class="nav-link" href="<%=request.getContextPath()%>/listPackage">Bank</a>
		  </li>
		  
		  <li class="nav-item">
		    <a class="nav-link" href="<%=request.getContextPath()%>/listPackage">Branch</a>
		  </li>
		  
  		  <li class="nav-item">
		    <a class="nav-link" href="<%=request.getContextPath()%>/listPackage">Customer</a>
		  </li>
		  
   		  <li class="nav-item">
		    <a class="nav-link" href="<%=request.getContextPath()%>/listPackage">Employee</a>
		  </li>
		  
   		  <li class="nav-item">
		    <a class="nav-link" href="<%=request.getContextPath()%>/listPackage">Package</a>
		  </li>
		  
   		  <li class="nav-item">
		    <a class="nav-link" href="<%=request.getContextPath()%>/listPackage">Role</a>
		  </li>
		  
   		  <li class="nav-item">
		    <a class="nav-link" href="<%=request.getContextPath()%>/listPackage">Statement</a>
		  </li>
		  
   		  <li class="nav-item">
		    <a class="nav-link" href="<%=request.getContextPath()%>/listPackage">Transfer</a>
		  </li>
		  
   		  <li class="nav-item">
		    <a class="nav-link" href="<%=request.getContextPath()%>/listPackage">User</a>
		  </li>
		  
		</ul>
	</nav>
	
</header>