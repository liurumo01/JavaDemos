<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="space.snowwolf.struts2.valuestack.Person"%>
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
		push 标签：<br/><br/>
		<%
			Person person = new Person();
			person.setName("snowwolf");
			person.setAge(20);
			request.setAttribute("person", person);
		%>
		<s:push value="#request.person">
			<s:debug></s:debug>
			${name}
		</s:push><br/><br/>
		
		<br/><br/>
		
		iterator 标签<br/><br/>
		<%
			/* List<Person> persons = new ArrayList<Person>();
			persons.add(new Person("AA",10));
			persons.add(new Person("BB",20));
			persons.add(new Person("CC",30));
			persons.add(new Person("DD",40));
			persons.add(new Person("EE",50));
			request.setAttribute("persons", persons); */
		%>
		<s:iterator value="#request.persons">
			${name} - ${age}<br/>
		</s:iterator>
		<s:iterator value="products">
			${name} - ${desc} - ${price}<br/>
		</s:iterator>
	</body>
</html>
