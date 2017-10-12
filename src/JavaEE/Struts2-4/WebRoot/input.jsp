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
		<s:debug></s:debug>
		<%-- <s:property value="exceptionStack"/><br/><br/> --%>
		<s:property value="exception"/><br/><br/>
		<s:property value="exception.message"/><br/><br/>
		${exception}<br/><br/>
		${exception.message}<br/><br/>
		<form action="product-save.action" method="post">
			ProductName <input type="text" name="name"/><br/><br/>
			ProductDesc <input type="text" name="desc"/><br/><br/>
			ProductPrice <input type="text" name="price"/><br/><br/>
			<input type="submit" value="Submit"/>
		</form>
	</body>
</html>
