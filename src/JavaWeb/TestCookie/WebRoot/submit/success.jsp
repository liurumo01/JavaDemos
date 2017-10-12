<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" session="false"%>
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
		<h1>Success Page</h1>
	</body>
</html>
