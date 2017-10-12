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
		<a href="upload.jsp">文件上传</a>
		<a href="download.jsp">文件下载</a>
	</body>
</html>
