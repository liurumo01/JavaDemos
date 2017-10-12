<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="space.snowwolf.controller.Person"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.snowwolf.space/mytag/core" prefix="snowwolf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>simple tag</title>
	</head>
  
	<body>
		<snowwolf:forEach items="${persons}" var="person">
			${person.getId()}, ${person.getName()}<br/>
		</snowwolf:forEach>
	</body>
</html>
