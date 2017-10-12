<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="space.snowwolf.struts2.valuestack.Person"%>
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
		property 标签：<br/><br/>
		<s:property value="name"/><br/><br/>
		<s:property value="#session.date"/><br/><br/>
		<s:property value="#parameters.name[0]"/><br/><br/>
		
		<br/><br/>
		
		url 标签：<br/><br/>
		<s:url value="/getProduct" var="url">
			<s:param name="name" value="'CPU'"></s:param>
			<s:param name="date" value="#session.date"></s:param>
		</s:url>
		${url}<br/><br/>
		
		<s:url value="/getProduct" var="url2">
			<s:param name="desc" value="desc"></s:param>
		</s:url>
		${url2}<br/><br/>
		
		<s:url value="/getProduct" var="url3">
			<s:param name="msg" value="'abcde'"></s:param>
		</s:url>
		${url3}<br/><br/>
		
		<s:url action="testAction" namespace="/helloworld" method="save" var="url4"></s:url>
		${url4}<br/><br/>
		
		<s:url value="testUrl" var="url5" includeParams="all"></s:url>
		${url5}<br/><br/>
		
		<br/><br/>
		
		set 标签：<br/><br/>
		<s:set name="name" value="name" scope="request"></s:set>
		${requestScope.name}<br/><br/>
		
		<br/><br/>
		
		if-else 标签<br/><br/>
		<s:if test="price>1000">i7处理器</s:if>
		<s:elseif test="price>800">i5处理器</s:elseif>
		<s:else>i3处理器</s:else>
	</body>
</html>
