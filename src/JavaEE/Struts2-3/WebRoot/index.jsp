<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
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
		<form action="TestResult">
			<input type="text" name="number"/>
			<input type="submit" value="Submit"/>
		</form>
		
		<a href="UserAction-add">User Add</a><br/><br/>
		<a href="UserAction-delete">User Delete</a><br/><br/>
		<a href="UserAction-update">User Update</a><br/><br/>
		<a href="UserAction-query">User Query</a><br/><br/>
	</body>
</html>
