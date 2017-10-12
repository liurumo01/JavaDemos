<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>文件上传</title>
		<script src="${pageContext.request.contextPath}/scripts/jquery-1.7.2.js"></script>
		<script>
			$(function() {
				var i=2;	
				$("#addFile").click(function() {
					$(this).parent().parent().before("<tr class='file'><td>File"
						+ i + ":</td><td><input type='file' name='file"
						+ i + "'/></td></tr>"
						+ "<tr class='desc'><td>Desc"
						+ i + ":</td><td><input type='text' name='desc"
						+ i + "'/><input id='delete"
						+ i + "' type='button' value='删除'/></td></tr>"
					);
					$("#delete" + i).click(function() {
						var $tr = $(this).parent().parent();
						$tr.prev("tr").remove();
						$tr.remove();
						
						$(".file").each(function(index) {
							var n = index + 1;
							$(this).find("td:first").text("File" + n + ":");
							$(this).find("td:last input").attr("name","file" + n);
						});
						
						$(".desc").each(function(index) {
							var n = index + 1;
							$(this).find("td:first").text("Desc" + n + ":");
							$(this).find("td:last input").attr("name","desc" + n);
						});
						i--;
					});
					i++;
				});
				
			});
		</script>
	</head>

	<body>
		<font color="red">${message}</font>
		<form action="./app/FileUploadServlet" method="post" enctype="multipart/form-data">
			
			<input type="hidden" id="fileNum" value="1"/><br/><br/>
			
			<table>
				<tr class="file">
					<td>File1:</td>
					<td><input type="file" name="file1"/></td>
				</tr>
				<tr class="desc">
					<td>Desc1:</td>
					<td><input type="text" name="desc1"/></td>
				</tr>
				<tr id="add">
					<td><input type="submit" id="submit" value="提交"/></td>
					<td><input type="button" id="addFile" value="新增一个附件"></td>
				</tr>
			</table>
			
		</form>
	</body>
</html>
