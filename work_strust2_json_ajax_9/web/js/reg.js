//����һ��ȫ�ֱ��� ��������Ķ���
	var xmlhttp;
	//�������Ķ���
	function createXmlHttp(){
		//IE5.5�Ժ󣬶��ṩ��XMLHttpRequest������Ķ���
		if(window.XMLHttpRequest){
			xmlhttp=new XMLHttpRequest();
		}else{
			xmlhttp =new ActiveXObject("Microsoft.XMLHTTP"); 
		}
	}	
	//��֤�û����Ƿ����
	function checkname(){
		//1.�������Ķ���
		createXmlHttp();
		//2.��ȡ�û�������û���,��ͨ�����Ķ��������ύ·���Ͳ������Լ��ύ��ʽ
		var uname=$("uname").value;
		xmlhttp.open("post", "us?uname="+uname);
		//3.���ûص�����
		xmlhttp.onreadystatechange=function(){
			if(xmlhttp.readyState==4&&xmlhttp.status==200){
				var text=xmlhttp.responseText;
				if(text=="false"){
					$("nameinfo").innerHTML="<font color='green'>�û�������</font>";
				}else{
					$("nameinfo").innerHTML="<font color='red'>�û���������</font>";
				}
			}
		};
		//4.�������󣨵���send�������˷������Դ���Ҳ���Բ��� ������ʱ��ʽΪ��������=ֵ&������=ֵ...��
		xmlhttp.send();
	}
	
	function $(id){
		return document.getElementById(id);
	}