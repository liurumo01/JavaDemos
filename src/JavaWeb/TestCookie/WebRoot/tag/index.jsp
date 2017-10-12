<%@page import="space.snowwolf.controller.Person"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" session="false"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>simple tag</title>
		<%
    		List<Person> persons = new ArrayList<Person>();
    		persons.add(new Person(1,"常子欣"));
    		persons.add(new Person(2,"沈诗瑶"));
    		persons.add(new Person(3,"宇文杉月"));
    		persons.add(new Person(4,"欧阳明远"));
    		persons.add(new Person(5,"夏若帆"));
    		
    		request.setAttribute("persons", persons);
    		System.out.println(persons);
    	%>
	</head>
  
	<body>
    	<jsp:forward page="person.jsp"></jsp:forward>
	</body>
</html>
