<%@ taglib uri="http://www.snowwolf.space/mytag/core" prefix="snowwolf"%>
<%@ page import="space.snowwolf.controller.Person"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" session="false"%>
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
    	<%-- <snowwolf:hello value="${param.name}" count="10"/>
    	<snowwolf:max num1="5" num2="10"/>
    	<snowwolf:fileoutput src="/main.c"/> --%>
    	<snowwolf:testJspFragment>
    		Hello world
    	</snowwolf:testJspFragment>
	</body>
</html>
