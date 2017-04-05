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
<script type="text/javascript">
function gopage(mypage){
	var emppage=document.getElementById("emppage").value;
	if(parseInt(mypage)>=1&&parseInt(mypage)<=emppage){
		document.getElementById("pn").value=mypage;
		myform.submit();
	}else{
		alert("没有更多的页面了");
	}
	
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<h2>显示emp表信息</h2>
<body>
	<table width="800" border="1" cellspacing="0" >
	<tr height="40" >
		<th>编号</th>
		<th>名字</th>
		<th>职位</th>
		<th>部门</th>
	</tr>
	<c:forEach items="${emplist }" var="emp" >
	<tr height="35">
		<td align="center">${emp.empid}</td>
		<td align="center">${emp.ename }</td>
		<td align="center">${emp.job }</td>
		<td align="center">${emp.dept.dname }</td>
	</tr>
	</c:forEach>
</table>
<form id="myform" name="myform" action="ec/empsplit" method="post">
	<input type="hidden" value="${pn }" name="pn" id="pn" />
	<input type="hidden" value="${ps }" name="ps" id="ps" />
	<input type="hidden" value="${count }" name="count" id="count" />
	<input type="hidden" value="${emppage }" name="emppage" id="emppage" />
	<table>
	<tr>
		<td align="left" width="680">
		[<a href="javaScript:void(0);" onclick="gopage('1');">首页</a> 
      	|<a href="javaScript:void(0);" onclick="gopage('${pn-1}');">上一页</a> 
      	|<a href="javaScript:void(0);" onclick="gopage('${pn+1}');">下一页</a> 
      	|<a href="javaScript:void(0);" onclick="gopage('${emppage}');">末页</a>]
		<%-- <input type="button" value="首页" onclick="gopage('1');" />
		<input type="button" value="上一页" onclick="gopage('${pn-1}');" />
		<input type="button" value="下一页" onclick="gopage('${pn+1}');" />
		<input type="button" value="尾页" onclick="gopage('${emppage}');" /> --%>
		</td>
		<td>
		<p>共 <span><font size="3" color="red">${emppage}</font></span> 页 | 第 <font size="3" color="red">${pn}</font> 页</p>
		</td>
	</tr>
	</table>
</form> 
</body>
</html>