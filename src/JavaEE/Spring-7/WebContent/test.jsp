<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page import="space.snowwolf.spring.struts2.bean.Person" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
	
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		
	</head>
	
	<body>
	
		<%
		
			ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
			Person person = context.getBean(Person.class);
			person.hello();
			
		%>
	
	</body>
	
</html>