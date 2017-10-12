<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="space.snowwolf.struts2.valuestack.City"%>
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
			List<City> cities = new ArrayList<City>();
			cities.add(new City(1001, "Beijing"));
			cities.add(new City(1002, "Shanghai"));
			cities.add(new City(1003, "Shenyang"));
			cities.add(new City(1004, "Hangzhou"));
			request.setAttribute("cities", cities);
		%>
		<s:form action="save">
			<s:hidden name="userId"></s:hidden>
			<s:textfield name="username" label="Username"></s:textfield>
			<s:password name="password" label="Password"></s:password>
			<s:textarea name="desc" label="Desc"></s:textarea>
			<s:checkbox name="married" label="Married"></s:checkbox>
			<s:radio name="gender" list="#{'1':'Male','0':'Famale'}" label="Gender"></s:radio>
			<s:checkboxlist name="cities" list="#request.cities" listKey="cityId" listValue="cityName" label="City"></s:checkboxlist>
			<s:select list="{11,12}" headerKey="" headerValue="请选择" name="age" label="Age">
				<s:optgroup label="21-30" list="#{21:21,22:22}"></s:optgroup>
				<s:optgroup label="31-40" list="#{31:31,32:32}"></s:optgroup>
			</s:select>
			<s:submit></s:submit>
		</s:form>	
	</body>
</html>
