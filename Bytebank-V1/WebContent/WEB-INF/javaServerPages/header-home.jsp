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
		
		<a class="header-anchor-menu" href="<%=request.getContextPath()%>/AccountServlet">Account</a>
		<a class="header-anchor-menu" href="<%=request.getContextPath()%>/BankServlet">Bank</a>
		<a class="header-anchor-menu" href="<%=request.getContextPath()%>/BranchServlet">Branch</a>
		<a class="header-anchor-menu" href="<%=request.getContextPath()%>/CustomerServlet">Customer</a>
		<a class="header-anchor-menu" href="<%=request.getContextPath()%>/EmployeeServlet">Employee</a>
		<a class="header-anchor-menu" href="<%=request.getContextPath()%>/PackageServlet">Package</a>
		<a class="header-anchor-menu" href="<%=request.getContextPath()%>/RoleServlet">Role</a>
		<a class="header-anchor-menu" href="<%=request.getContextPath()%>/StatamentServlet">Statement</a>
		<a class="header-anchor-menu" href="<%=request.getContextPath()%>/TransferServlet">Transfer</a>
		<a class="header-anchor-menu" href="<%=request.getContextPath()%>/UserServlet">User</a>
		
	</div>

</header>