<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 여기에 인덱스 부분 바디에 글을 작성 -->
<c:choose>
	<c:when test="${SESS_ASEQ != null}">
<script type="text/javascript">

$(function(){
	$(".add_row").click(function(){
	    $("#field_table tbody:last-child").append("<tr><td style='vertical-align: middle;'></td><td style='vertical-align: middle;'><input type='text' id='newField'></td><td style='vertical-align: middle;'><button type='button' class='btn btn-outline btn-primary btn-sm mb-2' id='insertBtn'>추가</button></td></tr>");
	 });
});

$(function(){
	$(document).on("click",".btnz",function(){  
		var jbSplit = $(this).attr("id").split('-');
		var fseq = jbSplit[1];
   		
   		if($("#"+"edit-"+fseq).text() == "수정") {
	   		var vv =  "editable"+fseq;
	   		console.log(vv +"," + $("#"+vv).text());
   		
	   	  	$("#"+"editable"+fseq).attr("contenteditable", "true").focus();
			$("#"+"edit-"+fseq).empty();
			$("#"+"edit-"+fseq).append("확인");
   		} else {
   			var obj = new Object();
   			obj.fseq = fseq;
   			obj.fname = $("#"+"editable"+fseq).text();
   			console.log("fseq: " + obj.fseq + "       fname: " + obj.fname);
   			
   			$.ajax({
				url: "/admin_gongmo_field_update.do",
				headers:{
	                     'Content-Type':'application/json'
	            		},
				type: "post",
				data: JSON.stringify(obj),
				success: function(result){
					console.log(result);
					if(result == 1) {
						$("#"+"editable"+obj.fseq).text(obj.fname);
					} 
					
					$("#"+"editable"+fseq).attr("contenteditable", "false");
					$("#"+"edit-"+fseq).empty();
					$("#"+"edit-"+fseq).append("수정");
				}
			});
   		}
	});
});

$(function(){
	$(document).on("click", "#insertBtn", function(){
		var fname = $("#newField").val();
		fname = $.trim(fname);
		console.log("눌림      " + fname);
		var newField = $("#newField").val();
		
		if(fname == "") {
			swal("분야명을 입력하세요.");
			$("newField").focus();
		} else {
			var obj = new Object();
			obj.fname = newField;
			
			$.ajax({
				url: "/admin_gongmo_field_insert.do",
				headers:{
	            		'Content-Type':'application/json'
				},
				type: "post",
				data: JSON.stringify(obj),
				success: function(result){
			
					var htmlStr="";
					$.map(result, function(v, i){
					console.log(v.fseq);
						htmlStr += "<tr>";
						htmlStr += "<td style='vertical-align: middle;'>"+v.fseq+"</td>";
						htmlStr += "<td style='vertical-align: middle;' id='editable"+v.fseq+"'>"+v.fname+"</td>";
						htmlStr += "<td style='vertical-align: middle;'>";
						htmlStr += "<button type='button' class='btn btn-primary btn-sm mb-2 btnz' id='edit-"+v.fseq+"'>수정</button>";
						htmlStr += "</td>";
						htmlStr += "</tr>";
					});
					
					$("#fieldTable").html(htmlStr);
				}
			});
		}
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
		<div style="margin-bottom: 1px">
			<button type="button" class="btn btn-outline btn-light mb-2" onclick="javascript:history.back()">«이전</button>
		</div>
		
		<div class="row">
			<div class="col-6">
				<section class="card card-admin">
					<div class="card-body">
						<table class="table table-hover" id="field_table">
							<col style="width: 10%;"></col>
							<col style="width: 40%;"></col>
							<col style="width: 20%;"></col>
							<thead>
								<tr>
									<th>#</th>
									<th>분야</th>
									<th>선택</th>
								</tr>
							</thead>
							<tbody id="fieldTable">
								<c:forEach items="${flist}" var="flist">
								<tr>
									<td style="vertical-align: middle;">${flist.fseq}</td>
									<td style="vertical-align: middle;" id="editable${flist.fseq}">${flist.fname}</td>
									<td style="vertical-align: middle;">
										<button type="button" class="btn btn-primary btn-sm mb-2 btnz" id="edit-${flist.fseq}">수정</button>
									</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
						<button type="button" class="btn btn-primary btn-sm mb-2 add_row"><i class="fas fa-plus"></i></button>
					</div>
				</section>
			</div>
		</div>
		<div style="margin-top: 5px">
			<button type="button" class="btn btn-outline btn-light mb-2" onclick="javascript:history.back()">«이전</button>
		</div>
	</div>
	<hr class="tall" style="visibility: hidden;">
</div>
</c:when>
	<c:otherwise>
	<%@ include file="/tiles/admin_error.jsp" %>
	</c:otherwise>
</c:choose>