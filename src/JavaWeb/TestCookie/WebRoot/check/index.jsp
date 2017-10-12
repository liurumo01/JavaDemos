<%@ page import="space.snowwolf.controller.TokenProcessor"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title></title>
	</head>
  
	<body>
		<font color="red">
			<%= session.getAttribute("message") == null ? "" : session.getAttribute("message") %>
		</font>
		<form method="post" action="<%= path %>/CheckCodeController">
			name: <input type="text" name="name"/><br/>
			check code: <input type="text" name="CHECK_CODE_PARAM_NAME"/><br/>
			<img src="<%= path %>/ValidateColorController"/><br/>
			<input type="submit" value="submit"/><br/>
		</form>
	</body>
</html>
