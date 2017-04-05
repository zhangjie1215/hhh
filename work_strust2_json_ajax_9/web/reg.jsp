<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户注册</title>
<!-- <script type="text/javascript" src="js/reg.js" charset="gbk"></script> -->
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/reg2.js" charset="gbk"></script>
</head>
<s:debug></s:debug>
<body>
	<h2>请注册</h2>
	<form action="isreg" method="post">
		用户名：<input type="text" id="uname" name="uname"/>
		<span id="nameinfo"><font color="red"><b><i>${fieldErrors["uname"][0]}</i></b></font></span>
		<br/><br/>
		密&nbsp;码：<input type="password" id="upwd" name="upwd"/><br/><br/>
		地&nbsp;址：<select name="province" id="province" >
					<option value="0">---请选择省份---</option>
				  </select>
				  <select name="city" id="city">
					<option value="0">---请选择城市---</option>
				  </select>
				  <select name="area" id="area">
					<option value="0">---请选择县/区---</option>
				  </select>
		<input type="text" name="add"  /><br/>
		<input type="submit" value="注册"/>
	</form>
</body>
</html> 