<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>Ajax Hello world</title>
		<script>
		window.onload = function() {
			document.getElementsByTagName("a")[0].onclick = function() {
				
				xmlHttpRequest = new XMLHttpRequest();
				var url = this.href + "?" + Math.random();
				//alert(url);
				var method = "POST";
				xmlHttpRequest.open(method,url);
				xmlHttpRequest.setRequestHeader("ContentType", "application/x-www-form-urlencoded");
				xmlHttpRequest.send("name='atguigu'");
				
				xmlHttpRequest.onreadystatechange = function() {
					if(xmlHttpRequest.readyState == 4 && (xmlHttpRequest.status == 200 || xmlHttpRequest.status == 304)) {
						//alert(xmlHttpRequest.responseText);
					}
				}
				
				return false;
			}
		}
		</script>
	</head>
		
	<body>
		<a href="HelloAjax.txt">Hello Ajax</a>
	</body>
</html>
