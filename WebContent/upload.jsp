<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <% String context = request.getContextPath();
    request.setAttribute("context", context);
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action= "upload/file" method="post" enctype="multipart/form-data" >
文件名:<input name = "file" type="file" accept="image/gif, image/jpeg"  /><br>
提交:<input name = "submit" type = "submit" value= "submit"/><br>
</form>
</body>
</html>