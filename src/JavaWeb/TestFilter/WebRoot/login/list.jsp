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
		<ul>
			<li><a href="login/a.jsp">AAA</a></li>
			<li><a href="login/b.jsp">BBB</a></li>
			<li><a href="login/c.jsp">CCC</a></li>
			<li><a href="login/d.jsp">DDD</a></li>
			<li><a href="login/e.jsp">EEE</a></li>
		</ul>
	</body>
</html>
