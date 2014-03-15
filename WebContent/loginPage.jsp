<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String context = request.getContextPath();
	request.setAttribute("context", context);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

</head>
<body>
	<form action="${context }/checkUser.html" method="post">
		UserName:<input name="username" type="text" id="username" /><br>
		ImageCode:<input name="code" type="text">
		<img alt="" src="${context }/imageCode.html"><br>
		
		<!-- <button id="register" name="register">改变内容</button> -->
		<br> <input type="submit" name="submit" id="submit" />
	</form>
</body>
</html>