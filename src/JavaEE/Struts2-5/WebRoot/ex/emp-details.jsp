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
		Employee<br/><br/>
		id : <s:property value="#session.employee.id"/><br/>
		name : <s:property value="#session.employee.name"/><br/>
		password : <s:property value="#session.employee.password"/><br/>
		gender : <s:property value="#session.employee.gender"/><br/>
		department : <s:property value="#session.employee.department"/><br/>
		role : <s:property value="#session.employee.role"/><br/>
		description : <s:property value="#session.employee.description"/><br/>
	</body>
</html>
