<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<script src="scripts/jquery-1.12.1.min.js"></script>
		<script>

			$(function() {

				$(".delete").click(function() {

					var href = $(this).attr("href");
					$("form").attr("action", href).submit();
					return false;
					
				})

			})
		
		</script>
	
	</head>
	
	<body>
	
		<c:if test="${empty employees}">
			没有任何员工信息
		</c:if>
		
		<c:if test="${!empty employees}">
			<table border="1" cellpadding="10" cellspacing="0">
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>EMAIL</th>
					<th>GENDER</th>
					<th>DEPARTMENT</th>
					<th>EDIT</th>
					<th>DELETE</th>
				</tr>
				<c:forEach items="${employees}" var="emp">
					<tr>
						<th>${emp.id}</th>
						<th>${emp.name}</th>
						<th>${emp.email}</th>
						<th>${emp.gender == 0 ? "Female" : "Male"}</th>
						<th>${emp.department.name}</th>
						<th><a href="emp/${emp.id}">Edit</a></th>
						<th><a href="emp/${emp.id}" class="delete">Delete</a></th>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		
		<br/><br/>
		
		<a href="emp">Add New Employee</a>
		
		<form method="post">
		
			<input type="hidden" name="_method" value="delete"/>	
		
		</form>
	
	</body>

</html>