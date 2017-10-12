<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>step 1</title>
		<style type="text/css">
			table {
				font-size: 30px;
			}
		</style>
	</head>
	
	<body>
		<h1>step 1:选择要购买的图书</h1>
		
		<form action="<%= request.getContextPath() %>/ProcessStep1Controller" method="post">
			<table border="1" cellpadding="10" cellspacing="0">
				<tr>
					<td>书名</td>
					<td>购买</td>
				</tr>
				<tr>
					<td>Java</td>
					<td><input type="checkbox" name="book" value="Java"></td>
				</tr>
				<tr>
					<td>Oracle</td>
					<td><input type="checkbox" name="book" value="Oracle"></td>
				</tr>
				<tr>
					<td>Struts</td>
					<td><input type="checkbox" name="book" value="Struts"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="提交"/></td>
				</tr>
			</table>
		</form>
	</body>
</html>
