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
		
		<s:form action="app-emp-add.action">
			<s:textfield name="name" label="Name"></s:textfield>
			<s:textfield name="email" label="Email"></s:textfield>
			<s:submit></s:submit>
		</s:form>
		
		<table cellpadding="10" cellspacing="0" border="1">
			<tr>
				<td>id</td>
				<td>name</td>
				<td>email</td>
				<td>edit</td>
				<td>delete</td>
			</tr>
			<s:iterator value="#request.emps">
				<tr>
					<td>${id}</td>
					<td>${name}</td>
					<td>${email}</td>
					<td><a href="app-emp-edit?id=${id}">Edit</a></td>
					<td><a href="app-emp-delete?id=${id}">Delete</a></td>
				</tr>
			</s:iterator>
		</table>
	</body>
</html>
