$(function(){
		$("#uname").keyup(function(){
			 $.post("us","uname="+$("#uname").val(),function(data){
				if(data=="true"){
					$("#nameinfo").html("<font color='red' size='2'><b>用户名已经存在</b></font>");
				}else{
					$("#nameinfo").html("<font color='green' size='2'><b>用户名可以使用</b></font>");
				}
			},"json");
		});
		$.post("findAllprovince",function(data){
			var arr = $.parseJSON(data);
			 $.each(arr,function(i,n){
				 $("#province").append("<option value='"+n.provinceId+"'>"+n.province+"</option>");
			 });
		 },"json");
		$("#province").change(function(){
			if($(this).val()==0){
				$("#city option:gt(0)").remove();
				$("#area option:gt(0)").remove();
			}
			if($(this).val()!=0){
				$("#city option:gt(0)").remove();
				$("#area option:gt(0)").remove();
				$.post("findCitsByProId",{"provinceid":$(this).val()},function(data){
					var arr=$.parseJSON(data);
					$.each(arr,function(i,n){
						$("#city").append("<option value='"+n.cityId+"'>"+n.city+"</option>");
					});
				},"json");
			}
		});
		$("#city").change(function(){
			if($(this).val()==0){
				$("#area option:gt(0)").remove();
			}
			if($(this).val()!=0){
				$("#area option:gt(0)").remove();
				$.post("findAeraByCityId",{"cityid":$(this).val()},function(data){
					var arr=$.parseJSON(data);
					$.each(arr,function(i,n){
						$("#area").append("<option value='"+n.areaId+"'>"+n.area+"</option>");
					});
					
				},"json");
			}
		});
	}); 