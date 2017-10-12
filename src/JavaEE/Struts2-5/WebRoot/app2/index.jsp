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
		<s:form action="app2-testConversion" theme="simple">
			Age : <s:textfield name="age" label="Age"></s:textfield><br/>
			<s:fielderror fieldName="age"></s:fielderror>
			<br/>
			Birth : <s:textfield name="birth"></s:textfield><br/>
			<s:fielderror fieldName="birth"></s:fielderror>
			<br/>
			<s:submit></s:submit>
		</s:form>
	</body>
</html>
