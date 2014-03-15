<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String context = request.getContextPath();
	request.setAttribute("context", context);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.9.0.js"></script>
<script type="text/javascript">
	//处理AJAX的session过期问题  
	$.ajaxSetup({
		contentType : "application/x-www-form-urlencoded;charset=utf-8",
		cache : false,
		complete : function(XHR, TS) {
			var resText = XHR.responseText;
			alert(resText);
			if (resText != null && resText.indexOf("success:false") > 0) {
				alert("您的登录已超时, 请点确定后重新登录！");
			}
		}
	});	
</script>

<script type="text/javascript">
$(document).ready(function() {
	$("#register").click(function(){
		var p1=$("#password").val();
		var p2=$("#password2").val();
		if(p1!=p2){
			alert("Passwords must match");
			return;
		}
		$.ajax({
			 url:"${context}/login/register.html",
			 type:"post",
			 data:$("#form1").serialize(),
			 async:false,
			 success:function(returnData){
				 //alert(returnData);
				 console.log(returnData);
					 if(returnData.success){
						 //window.location.href = "${context}/login.html";
					 }else
					 	alert(returnData.message);
					 },
			 error:function(data,text){
				 //alert(data);
				 //alert(text);
			 },
			 dataType:"json"
		});
	});
});
</script>
</head>
<body>
	<form action="${context }/testHello.html" method="post">
		UserName:<input name="username" type="text" id="username" /><br>
		<button id="register" name="register">改变内容</button>
		<br> <input type="submit" name="submit" id="submit" />
	</form>
</body>
</html>