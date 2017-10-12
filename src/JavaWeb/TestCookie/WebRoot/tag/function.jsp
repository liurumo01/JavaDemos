<%@page import="space.snowwolf.controller.Person"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://www.snowwolf.space/mytag/core" prefix="snowwolf"%>
<%@ page isELIgnored="false" %>
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
    	${snowwolf:concat(param.str1,param.str2)}
	</body>
</html>
