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
		<h1>Test Aware Page</h1>
		application : ${applicationScope.applicationKey2}<br/><br/>
		<%-- session : ${sessionScope.sessionKey}<br/><br/>
		request : ${requestScope.requestKey}<br/><br/>
		param: ${parameters.name}<br/><br/>
		param: ${parameters.age}<br/><br/> --%>
	</body>
</html>
