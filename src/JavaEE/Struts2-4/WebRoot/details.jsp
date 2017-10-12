<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
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
		Product Name : <s:property value="[1].name"/><br/><br/>
		Product Desc : <s:property value="[1].desc"/><br/><br/>
		Product Price : <s:property value="price"/><br/><br/>
		
		Product Name1 : ${sessionScope.product.name}<br/><br/>
		Product Name1 : <s:property value="#session.product.name"/><br/><br/>
		<%-- Product Desc1 : <s:property value="[1].desc"/><br/><br/>
		Product Price1 : <s:property value="price"/><br/><br/> --%>
		
		Product Name2 : ${requestScope.test.name}<br/><br/>
		Product Name2 : <s:property value="#request.test.name"/><br/><br/>
		<%-- Product Desc2 : <s:property value="[1].desc"/><br/><br/>
		Product Price2 : <s:property value="price"/><br/><br/> --%>
		
		PI : <s:property value="@java.lang.Math@PI"/><br/><br/>
		cos(0) : <s:property value="@java.lang.Math@cos(0)"/><br/><br/>
		
		<s:property value="setName('ABM')"/>
		<s:debug></s:debug>
		Product Name1 : ${sessionScope.product.name}<br/><br/>
		Product Name2 : ${requestScope.test.name}<br/><br/>
		
		<%
			String[] names = new String[]{"aa","bb","cc","dd"};
			request.setAttribute("names", names);
		%>
		length : <s:property value="#attr.names.length"/><br/><br/>
		names[1] : <s:property value="#attr.names[1]"/><br/><br/>
		
		<%
			Map<String,String> letters = new HashMap<String,String>();
			request.setAttribute("letters", letters);
			
			letters.put("AA","a");
			letters.put("BB","b");
			letters.put("CC","b");
		%>
		Map Size : <s:property value="#attr.letters.size"/><br/><br/>
		AA : <s:property value="#attr.letters['AA']"/><br/><br/>
	</body>
</html>
