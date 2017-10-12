<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

	<head>
	
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		
	</head>
	
	<body>
	
	
		<form action="testConversionServiceConverter" method="post">
			<!-- GG-gg@163.com-0-105 -->
			Employee:<input type="text" name="employee"/><input type="submit" value="提交"/>
		</form>
	
		<br/><br/>
	
		<%
			Map<String, String> genders = new HashMap<String, String>();
			genders.put("1", "Male");
			genders.put("0", "Famale");
			
			request.setAttribute("genders", genders);
		%>
				
		<form:form action="emp" method="post" modelAttribute="employee">
			
			<c:if test="${employee.id == null}">
			
				Name:<form:input path="name"/><form:errors path="name"></form:errors>
				
				<br/><br/>
			
			</c:if>
			
			<c:if test="${employee.id != null}">
			
				<form:hidden path="id"/>
				<input type="hidden" name="_method" value="put"/>
			
			</c:if>
			
			Email:<form:input path="email"/><form:errors path="email"></form:errors>
			
			<br/><br/>
			
			Gender:<form:radiobuttons path="gender" items="${genders}"/>
			
			<br/><br/>
			
			Department:<form:select path="department.id" items="${departments}" itemLabel="name" itemValue="id"></form:select>
			
			<br/><br/>
			
			Birth:<form:input path="birth"/><form:errors path="birth"></form:errors>
			
			<br/><br/>
			
			Salary:<form:input path="salary"/>
			
			<br/><br/>
			
			<input type="submit" value="提交"/>
			
		</form:form>
	
	</body>
	
</html>