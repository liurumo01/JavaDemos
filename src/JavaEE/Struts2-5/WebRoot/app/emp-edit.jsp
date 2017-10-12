<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		<s:debug></s:debug>
		
		<s:form action="app-emp-update.action">
			<s:hidden name="id"></s:hidden>
			<s:textfield name="name" label="Name"></s:textfield>
			<s:textfield name="email" label="Email"></s:textfield>
			<s:submit></s:submit>
		</s:form>
	</body>
</html>
