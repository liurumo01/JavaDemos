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
		<a href="product-input.do">Product Input</a><br/><br/>
		<a href="TestActionContext?name=snowwolf">Test ActionContext</a><br/><br/>
		<a href="TestAware.action">Test Aware</a><br/><br/>
		<a href="LoginUI.do">Login</a><br/><br/>
		<a href="TestActionSupport.do">Test Action Support</a><br/><br/>
		
		<%
			if(application.getAttribute("date") == null) {
				application.setAttribute("date", new Date());
			}
		%>
	</body>
</html>
