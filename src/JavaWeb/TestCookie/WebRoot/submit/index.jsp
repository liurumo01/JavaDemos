<%@page import="space.snowwolf.controller.TokenProcessor"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title></title>
	</head>
  
	<body>
		<%
			String value = Math.random() + "";
			session.setAttribute("token", value);
		%>
	    <form method="post" action="<%= path %>/TokenController">
	   		<input type="hidden" name="TOKEN_KEY" value="<%= TokenProcessor.getInstance().saveToken(request) %>">
	    	name: <input type="text" name="name"/>
	    	<input type="submit" value="submit"/>
	    </form>
	</body>
</html>
