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
		<s:form action="testComplextProperty">
			<s:textfield name="name" label="Department Name"></s:textfield>
			<s:textfield name="manager.name" label="Manager Name"></s:textfield>
			<s:textfield name="manager.birth" label="Manager Birth"></s:textfield>
			<s:submit></s:submit>
		</s:form>
	</body>
</html>
