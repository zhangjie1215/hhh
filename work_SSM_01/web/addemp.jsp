<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		/* $(function(){
			$("#ename").keyup(function(){
			 $.post("ec/checkname",{"ename":$("#ename").val()},function(data){
				if(data){
					$("#nameinfo").html("<font color='red' size='3'>该员工已存在</font>");
				}else{
					$("#nameinfo").html("<font color='green' size='3'>可以添加</font>");
				}
			},"josn");
		});
	});   */
	 $(function(){
		$("#ename").keyup(function(){
			$.post("ec/checkname",{"ename":$("#ename").val()},function(data){
				if(data){
					$("#nameinfo").html("<font color='red' size='2'><b>用户名已经存在</b></font>");
				}else{
					$("#nameinfo").html("<font color='green' size='2'><b>用户名可以使用</b></font>");
				}
			},"json");
		});
	}); 
</script>
</head>
<body>
	<h2>添加员工</h2>
	<form action="">
		<table>
			<tr>
				<td>员工姓名：</td>
				<td>
					<input type="text" name="ename" id="ename"/>
					<span id="nameinfo"></span>
					
				</td>
			</tr>
			<tr>
				<td>员工职位：</td>
				<td><input type="text" name="job"/></td>
			</tr>
			<tr>
				<td>员工部门：</td>
				<td><select name="dept.deptno">
					<option value="0">---请选择部门---</option>
					<c:forEach items="${deptlist }" var="dept">
						<option value="${dept.deptno }">${dept.dname }</option>
					</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="添加员工"/></td>
			</tr>
		</table>
	</form>
</body>
</html>