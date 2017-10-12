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
			
				var flag = "${sessionScope.cart == null}";
				if(flag) {
					$("#cartStatus").hide();
				} else {
					$("#cartStatus").show();
					$("#bookName").text("${sessionScope.cart.bookName}");
					$("#totalBookNumber").text("${sessionScope.cart.totalBookNumber}");
					$("#totalMoney").text("${sessionScope.cart.totalMoney}");
				}
			
				$("a").click(function() {
					
					$("#cartStatus").show();
				
					var url = this.href;
					var args = {"time" : new Date()};
					
					$.getJSON(url,args,function(data) {
						$("#bookName").text(data.bookName);
						$("#totalBookNumber").text(data.totalBookNumber);
						$("#totalMoney").text(data.totalMoney);
					})
					
					return false;
				})
			})
		</script>
	</head>
  
	<body>
		<div id="cartStatus">
			您已将&nbsp;<span id="bookName"></span>&nbsp;加入到购物车中，
			购物车中的书有&nbsp;<span id="totalBookNumber"></span>&nbsp;本，
			总价格&nbsp;<span id="totalMoney"></span>&nbsp;元<br/><br/>
		</div>
	
		Java&nbsp;&nbsp;<a href="AddToCartServlet?id=Java&price=100">加入购物车</a><br/><br/>
		
		Oracle&nbsp;&nbsp;<a href="AddToCartServlet?id=Oracle&price=100">加入购物车</a><br/><br/>
		
		Structs2&nbsp;&nbsp;<a href="AddToCartServlet?id=Struts2&price=100">加入购物车</a><br/><br/>
		
	</body>
</html>
