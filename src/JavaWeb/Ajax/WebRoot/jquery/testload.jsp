<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>Ajax Test Load</title>
		<script src="scripts/jquery-1.7.2.min.js"></script>
		<script>
			$(function() {
				$("a").click(function() {
					var url = this.href;
					var args = {"time" : new Date()};
					$("#content").load(url,args);
					return false;
				})
			})
		</script>
	</head>
		
	<body>
		<a href="HelloAjax.txt">Hello Ajax</a>
		<div id="content"></div>
	</body>
</html>
