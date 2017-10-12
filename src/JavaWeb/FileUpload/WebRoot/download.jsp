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
		<a href="xyz.txt">Download xyz.txt</a>
		<br/><br/>
		<a href="test.jsp">Download test.jsp</a>
		<br/><br/>
		<a href="FileDownloadServlet">Download abcd.jsp</a>
	</body>
</html>
