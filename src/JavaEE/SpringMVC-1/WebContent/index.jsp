<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
	
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		
	</head>
	
	<body>
	
		<a href="helloworld">Hello World</a>
		
		<br/><br/>
		
		<a href="springmvc/testRequestMapping">Test RequestMapping</a>
		
		<br/><br/>
		
		<form action="springmvc/testMethod" method="post">
			<input type="submit" value="Test Method"/>
		</form>
		
		<br/><br/>
		
		<a href="springmvc/testParamsAndHeaders?username=atguigu&age=11">Test Params And Headers</a>
		
		<br/><br/>
		
		<a href="springmvc/testAntPath/asdf/abc">Test Ant Path</a>
		
		<br/><br/>
		
		<a href="springmvc/testPathVariable/1">Test Path Variable</a>
		
		<br/><br/>
		
		<a href="springmvc/testRest/1">Test Rest Get</a>
		
		<br/><br/>
		
		<form action="springmvc/testRest" method="post">
			<input type="submit" value="Test Rest Post"/>
		</form>
		
		<br/><br/>
		
		<form action="springmvc/testRest/1" method="post">
			<input type="hidden" name="_method" value="delete">
			<input type="submit" value="Test Rest Delete"/>
		</form>
		
		<br/><br/>
		
		<form action="springmvc/testRest/1" method="post">
			<input type="hidden" name="_method" value="put">
			<input type="submit" value="Test Rest Put"/>
		</form>
		
		<br/><br/>
		
		<a href="springmvc/testRequestParam?name=atguigu&age=11">Test Request Param</a>
		
		<br/><br/>
		
		<a href="springmvc/testRequestHeader">Test Request Header</a>
		
		<br/><br/>
		
		<a href="springmvc/testCookieValue">Test Cookie Value</a>
		
		<br/><br/>
		
		<form action="springmvc/testPojo" method="post">
			username:<input type="text" name="username"/>
			password:<input type="password" name="password"/>
			email:<input type="text" name="email"/>
			age:<input type="text" name="age"/>
			province:<input type="text" name="address.province"/>
			city:<input type="text" name="address.city"/>
			<input type="submit" value="Test Pojo"/>
		</form>
		
		<br/><br/>
		
		<a href="springmvc/testServletAPI">Test Servlet API</a>
		
		<br/><br/>
		
		<a href="springmvc/testModelAndView">Test ModelAndView</a>
		
		<br/><br/>
		
		<a href="springmvc/testMap">Test Map</a>
		
		<br/><br/>
		
		<a href="springmvc/testSessionAttributes">Test SessionAttributes</a>
		
		<br/><br/>
		
		<form action="springmvc/testModelAttribute" method="post">
			<input type="hidden" name="id" value="1"/>
			username:<input type="text" name="username" value="Tom"/>
			email:<input type="text" name="email" value="tom@163.com"/>
			age:<input type="text" name="age" value="12"/>
			<input type="submit" value="Test ModelAttribute"/>
		</form>
		
		<br/><br/>
		
		<a href="springmvc/testViewAndViewResolver">Test ViewAndViewResolver</a>
		
		<br/><br/>
		
		<a href="springmvc/testView">Test View</a>
		
		<br/><br/>
		
		<a href="springmvc/testRedirect">Test Redirect</a>
				
	</body>
	
</html>