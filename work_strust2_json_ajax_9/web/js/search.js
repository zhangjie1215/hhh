$(function(){
	$("#info").css({"margin-left":(parseInt($("#mydiv").css("margin-left"))+2)+"px"});
	$("#info").innerWidth($("#mytext").innerWidth()-2);
	$("#mytext").keyup(function(){
		$("#info").html("");
		if($(this).val()!=""){
			$.post("searchByKw",{"kw":$("#mytext").val()},function(data){ 
				var arr=$.parseJSON(data);
				var info="<ul>";
				$.each(arr,function(i,n){
					info+="<li>"+n.city+"</li>";
				});
				info+="</ul>";
				$("#info").show().append(info);
				$("#info ul li").click(function(){
					$("#mytext").val($(this).html());
					$("#info").html("").hide();
				});
			},"json");
		}else{
			$("#info").html("").hide();
		}
	});
});