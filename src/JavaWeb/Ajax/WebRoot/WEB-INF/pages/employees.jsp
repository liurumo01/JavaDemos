<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>Ajax Hello world</title>
		<script src="${pageContext.request.contextPath}/scripts/jquery-1.7.2.min.js"></script>
		<script src="${pageContext.request.contextPath}/scripts/jquery.blockUI.js"></script>
		<script>
			$(function() {
			
				$(document).ajaxStart(function() {
					$.blockUI({
						message : $("#loading"),
						css : {
							top : ($(window).height() - 400) / 2 + "px",
							left : ($(window).width() - 400) / 2 + "px",
							width : "400px",
							border : "none"
						}, overlayCSS : {
							backgroundColor: "#FFF"
						}
					})
				}).ajaxStop($.unblockUI);
				
				var emps;
			
				$("#city").change(function() {
					$("#department option:not(:first)").remove();
					var city = $(this).val();
					if(city != "") {
						var url = "EmployeeServlet?method=listDepartments";
						var args = {
							"locationId" : city,
							"time" : new Date()
						};
						
						$.getJSON(url,args,function(data) {
							if(data.length == 0) {
								alert("当前城市没有部门");
							} else {
								for(var i=0;i<data.length;i++) {
									var deptId = data[i].id;
									var deptName = data[i].name;
									$("#department").append("<option value='" + deptId + "'>" + deptName + "</option>");
								}
							}
						})
					}
				})
				
				$("#department").change(function() {
					$("#employee option:not(:first)").remove();
					var department = $(this).val();
					if(department != "") {
						var url = "EmployeeServlet?method=listEmployees";
						var args = {
							"departmentId" : department,
							"time" : new Date()
						};
						
						$.getJSON(url,args,function(data) {
							emps = data;
							if(data.length == 0) {
								alert("当前部门没有员工");
							} else {
								for(var i=0;i<data.length;i++) {
									var empId = data[i].id;
									var empName = data[i].lastName;
									var empSalary = data[i].salary;
									$("#employee").append("<option value='" + empId + "'>" + empName + "</option>");
								}
							}
						})
					}
				})
				
				$("#employee").change(function() {
					
					for(var i=0;i<emps.length;i++) {
						//alert(emps[i].id,);
						if(emps[i].id == $(this).val()) {
							//alert(emps[i].id);
							$("#id").text(emps[i].id);
							$("#name").text(emps[i].lastName);
							$("#salary").text(emps[i].salary);
							return;
						}
					}
				})
			})
		</script>
	</head>
		
	<body>
		<img alt="" id="loading" src="${pageContext.request.contextPath}/images/loading.gif" style="display: none;">
		<center>
			<br/><br/>
			City:
			
			<select id="city">
				<option value="">请选择...</option>
				<c:forEach items="${locations}" var="location">
					<option value="${location.id}">${location.city}</option>
				</c:forEach>
			</select>
			
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			
			Department:
			<select id="department">
				<option value="">请选择...</option>
			</select>
			
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			
			Employee:
			<select id="employee">
				<option value="">请选择...</option>
			</select>
			
			<br/><br/>
			
			<table id="empdetails" border="1" cellspacing="0" cellpadding="5" style="display: none;">
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Salary</th>
				</tr>
				<tr>
					<td id="id"></td>
					<td id="name"></td>
					<td id="salary"></td>
				</tr>
			</table>
			
		</center>
	</body>
</html>
