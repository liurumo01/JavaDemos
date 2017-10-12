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
		<title>step 2</title>
		<style type="text/css">
			table {
				font-size: 30px;
			}
		</style>
	</head>
	
	<body>
		<h1>step 2:请输入寄送地址和信用卡信息</h1>
		
		<form action="<%= request.getContextPath() %>/ProcessStep2Controller" method="post">
			<table border="1" cellpadding="10" cellspacing="0">
				<tr>
					<td colspan="2">寄送信息</td>
				</tr>
				<tr>
					<td>姓名</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>寄送地址</td>
					<td><input type="text" name="address"></td>
				</tr>
				<tr>
					<td colspan="2">信用卡信息</td>
				</tr>
				<tr>
					<td>种类</td>
					<td>
						<input type="radio" name="type" value="visa">Visa
						<input type="radio" name="type" value="master">Master
					</td>
				</tr>
				<tr>
					<td>卡号</td>
					<td><input type="text" name="card"/></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="提交"/></td>
				</tr>
			</table>
		</form>
	</body>
</html>
				