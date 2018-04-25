<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 여기에 사이드 우측 바디에 들어갈 컨텐츠를 작성 -->
<c:choose>
	<c:when test="${SESS_ASEQ != null}">
<script type="text/javascript">

$(function(){ //전체선택 체크박스 클릭 
	$(".checkAll").click(function(){ 
		if($(".checkAll").prop("checked")){
			$("input[type=checkbox]").prop("checked", true);
		} else {
			$("input[type=checkbox]").prop("checked", false);
		}
	});
	
	$(document).on("click", "#dbBtn", function(){
		var val = [];
		var test = [];
		test = $(":checkbox:checked");
		console.log("var length : " + test.length);
		$("#flength").attr("value", test.length);
		var str = "";
		
		
		 for (var i=1; i<$("table tr").length; i++) {
			 var chk = $("table tr").eq(i).children().find("input[type='checkbox']").is(":checked");
			 if (chk == true) {
				 var data = new Object();
				 var index = i;
				 console.log("index" + index);
				 data.gtitle = document.getElementById("gtitle"+index).value;
					data.gposter = document.getElementById("gposter"+index).value;
					data.gspon = document.getElementById("gspon"+index).value;
					data.glink = document.getElementById("glink"+index).value;
					data.gsday = document.getElementById("gsday"+index).value;
					data.geday = document.getElementById("geday"+index).value;
					data.gbody = document.getElementById("gbody"+index).value;
					console.log(data);
					
					$.ajax({
						url:"/admin_gongmo_insert.do",
						headers:{
		                      'Content-Type':'application/json'
		                   },
						type: "post",
						data: JSON.stringify(data),
						success: function(result){
							console.log(result);
							
							swal("입력이 완료되었습니다.")
						}
					});
			 } 
			 
		 }
		
		
	/* 	if(test.length <= 10 && test.length > 0) {
			$(":checkbox:checked").each(function(i) {
				var index = i+1;
				
				console.log("index" + index);
				var data = new Object();
/* 				var gtitle = document.getElementById("gtitle"+index).value;
				var gposter = document.getElementById("gposter"+index).value;
				var gspon = document.getElementById("gspon"+index).value;
				var glink = document.getElementById("glink"+index).value;
				var gsday = document.getElementById("gsday"+index).value;
				var geday = document.getElementById("geday"+index).value;
				var gbody = document.getElementById("gbody"+index).value; 
				
				data.gtitle = document.getElementById("gtitle"+index).value;
				data.gposter = document.getElementById("gposter"+index).value;
				data.gspon = document.getElementById("gspon"+index).value;
				data.glink = document.getElementById("glink"+index).value;
				data.gsday = document.getElementById("gsday"+index).value;
				data.geday = document.getElementById("geday"+index).value;
				data.gbody = document.getElementById("gbody"+index).value;
				console.log(data);
				
				$.ajax({
					url:"/admin_gongmo_insert.do",
					headers:{
	                      'Content-Type':'application/json'
	                   },
					type: "post",
					data: JSON.stringify(data),
					success: function(result){
						console.log(result);
						$("table tr").eq(i).remove();
					}
				});
				
				
				/* console.log(val[i]);
				$("#farr").attr("value", val[i]); 
				str += val[i] + ",";
			});
			console.log(str);
			$("#checkbox").val(str);
			console.log("=========="+$("#checkbox").val());
			//$("#insertform").submit(); 
			} else {
				alert("분야를 1 ~ 3개로 선택해주세요.");
			} */
	});
});

</script>

<section class="page-header">
	<div class="container">
		<div class="row" style="visibility: hidden;">
			<div class="col" >
				<ul class="breadcrumb">
					<li><a href="#">hidden</a></li>
					<li class="active">hidden</li>
				</ul>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<h1>공모전</h1>
			</div>
		</div>
	</div>
</section>

<div role="main" class="main">
	<div class="container">
		<div class="col-12 mb-4 mb-lg-0">
			<div style="margin-bottom: 1px">
				<button type="button" class="btn btn-outline btn-light mb-2" onclick="javascript:history.back()">«이전</button>
				<div style="float: right;">
					<button type="button" class="btn btn-primary mb-2" id="dbBtn">DB로</button>
				</div>
			</div>
			<form class="form-horizontal form-bordered insertform" id="insertform" action="/admin_gongmo_insert.do" method="post">
			${html}
			</form>
		</div>
	</div>
	<hr class="tall">
</div>
</c:when>
	<c:otherwise>
	<%@ include file="/tiles/admin_error.jsp" %>
	</c:otherwise>
</c:choose>