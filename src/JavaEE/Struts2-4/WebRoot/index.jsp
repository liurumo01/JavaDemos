<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
		<a href="testTag.action?name=snowwolf">Test Tag</a>
		
		<%
			session.setAttribute("date", new Date());
		%>
		
		<form action="testTag.action" method="post">
			<input type="text" name="username"/><br/><br/>
			<input type="submit" value="Submit"/><br/><br/>
		</form>
		
		<a href="testTag2.action">Test Tag 2</a>
	</body>
</html>
