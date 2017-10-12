<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>用户登录</title>
	</head>
  
	<body>
		<%
			Cookie[] cookies = request.getCookies();
			if(cookies != null && cookies.length > 0) {
	    		for(Cookie cookie : cookies) {
	    			if(cookie.getName().equals("user")) {
	    				session.setAttribute("user", cookie.getValue());
	    				response.sendRedirect("main.jsp");
	    				return;
	    			}
	    		}
	    	}
		%>
		<form method="POST" action="UserController">
			用户名：<input type="text" name="username"/><br/>
			<input type="submit" value="登录"/><br/>
		</form>
	</body>
</html>
