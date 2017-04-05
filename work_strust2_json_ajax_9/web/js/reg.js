//定义一个全局变量 来保存核心对象
	var xmlhttp;
	//创建核心对象
	function createXmlHttp(){
		//IE5.5以后，都提供了XMLHttpRequest这个核心对象
		if(window.XMLHttpRequest){
			xmlhttp=new XMLHttpRequest();
		}else{
			xmlhttp =new ActiveXObject("Microsoft.XMLHTTP"); 
		}
	}	
	//验证用户名是否可用
	function checkname(){
		//1.创建核心对象
		createXmlHttp();
		//2.获取用户输入的用户名,并通过核心对象设置提交路径和参数，以及提交方式
		var uname=$("uname").value;
		xmlhttp.open("post", "us?uname="+uname);
		//3.设置回调函数
		xmlhttp.onreadystatechange=function(){
			if(xmlhttp.readyState==4&&xmlhttp.status==200){
				var text=xmlhttp.responseText;
				if(text=="false"){
					$("nameinfo").innerHTML="<font color='green'>用户名可用</font>";
				}else{
					$("nameinfo").innerHTML="<font color='red'>用户名不可用</font>";
				}
			}
		};
		//4.发起请求（调用send方法，此方法可以传参也可以不传 ；传参时格式为：变量名=值&变量名=值...）
		xmlhttp.send();
	}
	
	function $(id){
		return document.getElementById(id);
	}