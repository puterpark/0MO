<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 여기에 사이드 우측 바디에 들어갈 컨텐츠를 작성 -->
<c:choose>
	<c:when test="${SESS_ASEQ != null}">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
	    $("#aps").click(function(){
	    	console.log("sakdsaldhjkl");
	    	var gsday = $("#sdate").val();   
			var geday = $("#edate").val();
			var mid = $("#mid").val();
			
			var tgsday = gsday.replace(/-/gi, "");   
			var tgeday = geday.replace(/-/gi, "");
			console.log(gsday);
			console.log(geday);
			console.log(tgsday);
			console.log(tgsday);
			
			if ((tgeday - tgsday) < 0) {
			   swal("기간설정을 확인하세요.");
			   $("#sdate").focus();
			} else {
				if(gsday =="" && geday != "") {
					swal("시작날짜를 확인하세요.");
					$("#sdate").focus();
				} else {
					$("#adminsearch").submit();
				}
			}
	    });
	});
</script>
</head>

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
				<h1>포인트</h1>
			</div>
		</div>
	</div>
</section>

<div role="main" class="main">
	<div class="container">
		<div style="margin-bottom: 1px">
				<button type="button" class="btn btn-outline btn-light mb-2" onclick="javascript:history.back()">«이전</button>
		</div>
		
		<div>
			<button class="btn btn-quaternary mb-2" type="button" 
			style="width:120pt; height:25pt;" onclick="location.href='/admin_point.do'" >포인트 전체내역조회</button>
		</div>
		
		<form action="/admin_point_search.do" method="get" id="adminsearch">
			<table>
				<tr>
					<th>
						<font class="mb-0" size="4">기간설정 : </font> 
						<input type="date" name="sdate" id="sdate" /> ~ <input type="date" name="edate" id="edate" />
				        
					</th>
				</tr>
				
				<tr>
					<th>
					<div class="input-group input-search">
						<input name="mid" class="form-control" id="mid" type="text" placeholder="아이디입력">
						<span class="input-group-btn">
							<button class="btn btn-default" type="button" id="aps"><i class="fa fa-search"></i></button>
						</span>
					</div>
				</th>	
				</tr>
				
			</table>
		</form>
	</div>
	<hr class="short">
	
	<div class="container" id="adminPointList">
			<table class="table table-hover">
				<col style="width: 25%;"></col>
				<col style="width: 25%;"></col>
				<col style="width: 25%;"></col>
				<col style="width: 25%;"></col>
				<thead>
					<tr>
						<th>회원seq</th>
						<th>ID</th>
						<th>포인트 내역</th>
						<th>날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${LVL_APOINTLIST}" var="apovo">
						<tr>
							<td>${apovo.mseq}</td>
							<td>${apovo.mid}</td>
							<td>${apovo.popoint}</td>
							<td>${apovo.poregdate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<hr class="short">
			
			<div style="width: 200px; margin: auto;">
				${LVL_PAGING}
			</div>
			
	</div>
</div>
</c:when>
	<c:otherwise>
	<%@ include file="/tiles/admin_error.jsp" %>
	</c:otherwise>
</c:choose>















