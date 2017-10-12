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
			boolean flag = false;
			String user = (String) session.getAttribute("user");
			Cookie[] cookies = request.getCookies();
			if(cookies != null && cookies.length > 0) {
	    		for(Cookie cookie : cookies) {
	    			if(cookie.getName().equals("user")) {
	    				flag = true;
	    				user = cookie.getValue();
	    				break;
	    			}
	    		}
	    	}
			if(!flag && (user == null || user.equals(""))) {
				response.sendRedirect("login.jsp");
			}
			
		%>
		用户：<%= user %>
	</body>
</html>
