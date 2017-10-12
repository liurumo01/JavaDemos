<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
    
		<title>My JSP 'index.jsp' starting page</title>
	</head>
  
	<body>
		Exercise:<br/>
		<a href="ex-emp-input.action">Employee Input</a><br/><br/>
		
		Application:<br/>
		<a href="app-emp-list.action">Employee List</a><br/><br/>
	</body>
</html>
