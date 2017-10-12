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
		<style type="text/css">
			span {
				font-size: 30px;
			}	
		</style>
	</head>
  
	<body>
		<%
			String book = request.getParameter("book");
			List<Cookie> cookies = new ArrayList<Cookie>();
			for(Cookie cookie : request.getCookies()) {
				if(cookie.getName().contains("book_")) {
					cookies.add(cookie);
				}
				if(cookie.getName().equals("book_" + book)) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
			if(cookies.size() >= 5) {
				cookies.get(0).setMaxAge(0);
				response.addCookie(cookies.get(0));
			}
			Cookie cookie = new Cookie("book_" + book,book);
			cookie.setMaxAge(120);
			response.addCookie(cookie);
		%>
		<h1>Book Detail Page</h1>
		<span>Book: <%= request.getParameter("book") %></span><br/>
		<span><a href="books.jsp">Return</a></span>
	</body>
</html>
