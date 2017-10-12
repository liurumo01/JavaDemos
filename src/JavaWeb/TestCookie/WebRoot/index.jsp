<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" session="false"%>
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
    <%
    	//1.创建一个Cookie对象
    	//Cookie cookie = new Cookie("name","snowwolf");
    	
    	//2.调用response的一个方法把cookie传给客户端
    	//response.addCookie(cookie);
    	
    	//3.获取Cookie
    	Cookie[] cookies = request.getCookies();
    	if(cookies != null && cookies.length > 0) {
    		for(Cookie cookie : cookies) {
    			out.println(cookie.getName() + ":" + cookie.getValue() + "<br/>");
    		}
    	}
    	else {
    		out.println("没有一个Cookie，正在创建并返回<br/>");
    		Cookie cookie = new Cookie("name","snowwolf");
    		cookie.setMaxAge(30);
    		response.addCookie(cookie);
    	}
    %>
	</body>
</html>
