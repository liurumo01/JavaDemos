<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
	
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<script src="scripts/jquery-1.12.1.min.js"></script>
		<script>
			$(function() {

				$("#testJSON").click(function() {

					var url = this.href;
					var args = {};
					$.post(url, args, function(data) {

						for(var i=0;i<data.length;i++) {

							var id = data[i].id;
							var name = data[i].name;

							alert(id + " " + name);

						}
						
					})

					return false;

				})
				
			})
		</script>
		
	</head>
	
	<body>
	
		<a href="emps">List All Employees</a>
		
		<br/><br/>
		
		<a href="testJSON" id="testJSON">Test JSON</a>
		
		<br/><br/>
		
		<form action="testHttpMessageConverter" method="post" enctype="multipart/form-data">
			File:<input type="file" name="file"/>
			Description:<input type="text" name="description"/>
			<input type="submit" value="Submit">
		</form>
		
		<br/><br/>
		
		<a href="testResponseEntity">Test ResponseEntity</a>
		
		<br/><br/>
		
		<a href="i18n">I18N Page</a>
		
		<br/><br/>
		
		<form action="testFileUpload" method="post" enctype="multipart/form-data">
			File:<input type="file" name="file"/>
			Description:<input type="text" name="description"/>
			<input type="submit" value="Submit">
		</form>
		
		<br/><br/>
		
		<a href="testExceptionHandlerExceptionResolver?i=10">Test ExceptionHandlerExceptionResolver</a>
		
		<br/><br/>
		
		<a href="testResponseStatusExceptionResolver?i=10">Test ResponseStatusExceptionResolver</a>
		
		<br/><br/>
		
		<a href="testDefaultHandlerExceptionResolver">Test DefaultHandlerExceptionResolver</a>
		
		<br/><br/>
		
		<a href="testSimpleMappingExceptionResolver?i=2">Test SimpleMappingExceptionResolver</a>
		
	</body>
	
</html>