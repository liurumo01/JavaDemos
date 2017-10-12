<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="space.snowwolf.struts2.ex.DAO"%>
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
		<%
			DAO dao = new DAO();
			request.setAttribute("departments", dao.getDepartment());
			request.setAttribute("roles", dao.getRole());
		%>
		<s:form action="ex-emp-details.action" method="post" theme="xhtml">
			<s:textfield name="name" label="Name"></s:textfield>
			<s:password name="password" label="Password"></s:password>
			<s:radio name="gender" label="Gender" list="#{'0':'Male','1':'Famale'}"></s:radio>
			<s:select name="department" list="#request.departments" listKey="id" listValue="name"></s:select>
			<s:checkboxlist name="role" list="#request.roles" listKey="id" listValue="name"></s:checkboxlist>
			<s:textarea name="description"></s:textarea>
			<s:submit></s:submit>
		</s:form>
	</body>
</html>
