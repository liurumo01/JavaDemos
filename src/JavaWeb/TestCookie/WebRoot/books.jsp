<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>书籍列表</title>
	</head>
  
	<body>
		<h1>Books Page</h1>
		<ul style="font-size: 30px;">
			<li><a href="book.jsp?book=JavaWeb">JavaWeb</a></li>
			<li><a href="book.jsp?book=Java">Java</a></li>
			<li><a href="book.jsp?book=Oracle">Oracle</a></li>
			<li><a href="book.jsp?book=Ajax">Ajax</a></li>
			<li><a href="book.jsp?book=Javascript">Javascript</a></li>
			<li><a href="book.jsp?book=Android">Android</a></li>
			<li><a href="book.jsp?book=Jbpm">Jbpm</a></li>
			<li><a href="book.jsp?book=Struts">Struts</a></li>
			<li><a href="book.jsp?book=Hibernate">Hibernate</a></li>
			<li><a href="book.jsp?book=Spring">Spring</a></li>
		</ul>
		<%
			Cookie[] cookies = request.getCookies();
			if(cookies != null) {
				for(Cookie cookie : cookies) {
					System.out.println(cookie.getName() + "  " + cookie.getValue());
					if(cookie.getName().contains("book_")) {
						out.println(cookie.getValue() + "<br/>");
					}
				}
			}
		%>
	</body>
</html>
