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

<footer>

	<div class="footer-container">
	
		<a class="footer-anchor" href="<%=request.getContextPath()%>/home"><img class="footer-logo" src="resources/img/bytebank-logo.png" alt="ByteBank Logo"></a>  

		<a class="footer-anchor-menu" href="#home">Home</a>
		<a class="footer-anchor-menu" href="#contact">Contact</a>
		<a class="footer-anchor-menu" href="#about">About</a>
		
	</div>

</footer>