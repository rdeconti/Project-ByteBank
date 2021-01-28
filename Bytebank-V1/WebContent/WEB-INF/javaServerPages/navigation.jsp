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

<div class="navigation-container">

	<ul class="navigation-ul">
	
		<li class="navigation-li">
			<form method="post" action="AccountServlet">
				<input class="navigation-input-logo" type="image" src="resources/img/bytebank-logo.png" value="Home" name="submitAction">		
			</form>
		</li>
	
		<li class="navigation-li">
			<form method="post" action="AccountServlet">
				<input class="navigation-input" type="submit" value="Account" name="submitAction">			
			</form>
		</li>
		
		<li class="navigation-li">
			<form method="post" action="BankServlet">
				<input class="navigation-input" type="submit" value="Bank" name="submitAction">			
			</form>
		</li>
		
		<li class="navigation-li">
			<form method="post" action="BranchServlet">
				<input class="navigation-input" type="submit" value="Branch" name="submitAction">			
			</form>
		</li>
		
		<li class="navigation-li">
			<form method="post" action="CustomerServlet">
				<input class="navigation-input" type="submit" value="Customer" name="submitAction">			
			</form>
		</li>
		
		<li class="navigation-li">	  
			<form method="post" action="EmployeeServlet">
				<input class="navigation-input" type="submit" value="Employee" name="submitAction">			
			</form>
		</li>
		
		<li class="navigation-li">	  
			<form method="post" action="PackageServlet">
				<input class="navigation-input" type="submit" value="Package" name="submitAction">			
			</form>
		</li>
		
		<li class="navigation-li">	  
			<form method="post" action="RoleServlet">
				<input class="navigation-input" type="submit" value="Role" name="submitAction">			
			</form>
		</li>
		
		<li class="navigation-li">	  
		<form method="post" action="StatamentServlet">
			<input class="navigation-input" type="submit" value="Statament" name="submitAction">			
		</form>
		</li>
		
		<li class="navigation-li">		  
			<form method="post" action="TransferServlet">
				<input class="navigation-input" type="submit" value="Transfer" name="submitAction">			
			</form>
		</li>
		
		<li class="navigation-li">	  
			<form method="post" action="UserServlet">
				<input class="navigation-input" type="submit" value="User" name="submitAction">			
			</form>
		</li>
		
	</ul>

</div>