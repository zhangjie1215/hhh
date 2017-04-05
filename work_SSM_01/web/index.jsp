<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>" >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function(){
		$("#uname").blur(function(){
			if($(this).val()==""){
				$("#nameinfo").html("<font color='red' size='1'>用户名不能为空</font>");
			}
		});
	});
</script>
</head>
<body>
	<form action="uc/cl" method="post">
		用户名：<input type="text" value="zhangsan" name="uname" id="uname"/>
		<span id="nameinfo"></span>
		<br/><br/>
		密&nbsp;码：<input type="password" value="123" name="upwd" /><br/><br/>
		<input type="submit" value="登录"/>
	</form>
</body>
</html>