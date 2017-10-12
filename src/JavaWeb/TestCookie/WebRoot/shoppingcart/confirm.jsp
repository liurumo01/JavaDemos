<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="space.snowwolf.controller.Customer" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<title>confirm</title>
		<style type="text/css">
			table {
				font-size: 30px;
			}
		</style>
	</head>
	
	<body>
		<h1>step 3:确认订单信息</h1>
		<%
			Customer customer = (Customer) session.getAttribute("customer");
			String[] books = (String[]) session.getAttribute("books");
		%>
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<td>顾客姓名</td>
				<td><%= customer.getName() %></td>
			</tr>
			<tr>
				<td>寄送地址</td>
				<td><%= customer.getAddress() %></td>
			</tr>
			<tr>
				<td>信用卡卡号</td>
				<td><%= customer.getCard() %></td>
			</tr>
			<tr>
				<td>信用卡类型</td>
				<td><%= customer.getType() %></td>
			</tr>
			<tr>
				<td>选择的书：</td>
				<td>
					<%
						for(String book : books) {
							out.println(book + "<br/>");
						}
					%>
				</td>
			</tr>
		</table>
	</body>
</html>
				