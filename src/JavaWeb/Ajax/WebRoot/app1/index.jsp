<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<script src="${pageContext.request.contextPath}/scripts/jquery-1.7.2.min.js"></script>
		<script>
			$(function() {
				$(":text").change(function() {
					var val = $(this).val();
					val = $.trim(val);
					
					if(val != "") {
						var url = "${pageContext.request.contextPath}/ValidateUsername";
						
						var args = {
							"username" : val,
							"time" : new Date()
						};
						$.post(url,args,function(data) {
							$("#msg").html(data);
						})
					}
				})
			})
		</script>
	</head>
  
	<body>
		<form action="" method="post">
			username : <input type="text" name="username"/>
			<br/>
			<div id="msg"></div>
			<br/>
			<input type="submit" value="Submit">
		</form>
	</body>
</html>
