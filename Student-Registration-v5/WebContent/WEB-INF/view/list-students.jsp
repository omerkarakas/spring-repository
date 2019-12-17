<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
    pageEncoding="ISO-8859-9"%>
<!-- SEARCH -->
<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-9">
<title>Student List</title>

<link type="text/css"  rel="stylesheet" 
    href="${pageContext.request.contextPath}/resources/css/style.css"/>
    
</head>
<body>


<div id="wrapper">
	<div id="header">
		<h1> Student Registration System </h1>
	</div>
</div>


<div id="container">
	<div id="content">
		
		
<!-- SEARCH -->
 		<table width=100%>
 			<tr>
 			  <td> <button onclick="window.location.href='addStudentForm'" class="add-button">Add Student</button> </td>
<frm:form action="searchStudents" method="GET">
 			  <td></td>
 			  <td align="right" width=50%> Search by Name or Surname : </td>
 			  <td> <input type="text" name="searchName" /></td>
 			  <td align="left"> <input type="submit" value="Search" class="search-button" /> </td>
 			</tr>
 		</table>
               
</frm:form>	
	
	
		<!-- add html table -->
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Action1</th>
				<th>Action2</th>
				
			</tr>

			<!--  print students -->
			<c:forEach var="stdnt" items="${students}">
			
				<c:url var="updatelink" value ="/student/updateStudentForm">
					<c:param name="studentId" value="${stdnt.id}" />
				</c:url>
				<c:url var="deletelink" value ="/student/deleteStudent">
					<c:param name="studentId" value="${stdnt.id}" />
				</c:url>				
				<tr>
					<td>${stdnt.firstName}</td>
					<td>${stdnt.lastName}</td>
					<td>${stdnt.email}</td>
					<td> <a href="${updatelink}">Update</a> 
					   | 
					   <!-- v1
					   <a href="${deletelink}">Delete</a> 
					    -->
					   <a href="${deletelink}"  onclick="if (!(confirm('Are you sure?'))) return false ">Delete</a>
					    
					</td>
					<td>	
						<button onclick="window.location.href='${updatelink}'" class="update-button">Manage</button>
					   |
					   
					   <!-- v1
					   <button onclick="window.location.href='${deletelink}'" class="delete-button">Delete</button>
					    -->
					   <button onclick="if ((confirm('Are you sure?'))) window.location.href='${deletelink}'" class="delete-button">Delete</button>
					</td>
				</tr>
				
			</c:forEach>


		</table>
	</div>
</div>


</body>
</html>