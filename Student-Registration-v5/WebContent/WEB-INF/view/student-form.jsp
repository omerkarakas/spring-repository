	<!-- v2 -->
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-9"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-9">
<title>Student Form</title>

	<!-- v2 -->
	<link type="text/css" rel="stylesheet"
	      href="${pageContext.request.contextPath}/resources/css/style.css">
	
	<link type="text/css" rel="stylesheet"
	      href="${pageContext.request.contextPath}/resources/css/add-student-style.css">
	
</head>
<body>
<!-- v1 
	buraya form gelecek ıİçğ
	-->
	
	
<div id="wrapper">
	<div id="header">
		<h1> Student Registration System </h1>
	</div>
</div>


<div id="container">

	<h3>Save Student</h3>
	<frm:form action="saveStudent" modelAttribute="student" method="POST">
	
		<!-- pk field, how to insert or update  -->
		<frm:hidden path="id"/>
	
		<table>
			<tr>
				<td><label>First Name</label></td>
				<td><frm:input path="firstName"/> </td>
			</tr>
			<tr>
				<td><label>Last Name</label></td>
				<td><frm:input path="lastName"/> </td>
			</tr>
			<tr>
				<td><label>Email</label></td>
				<td><frm:input path="email"/> </td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save" class="save" /> </td>
			</tr>
			
		</table>
	</frm:form>


	<div id="content">
	
	<button onclick="window.location.href='${pageContext.request.contextPath}/student/list'" class="back">Back To List</button>
		
	</div>
</div>
	
	
</body>
</html>