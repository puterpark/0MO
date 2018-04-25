<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 여기에 사이드 우측 바디에 들어갈 컨텐츠를 작성 -->
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
	    $("#ups").click(function(){
	    	var gsday = $("#sdate").val();   
			var geday = $("#edate").val();
			
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
					$("#userpointsearch").submit();
				}
			}
	    });
	});
</script>

<div class="col-lg-9">
	<div class="container">
		<font size="5"><b>포인트 내역</b></font>
		<hr class="short">
	</div>
	
	<div class="container">
	<br>
		<table class="table table-bordered">
			<col style="width:30%"></col>
			<thead>
				<tr>
					<td align="center">
						<strong>현재 보유 포인트</strong>
					</td>
					<td align="center">
						<strong>${LVL_POINTSUM}p</strong>
					</td>
				</tr>
			</thead>
		</table>
	</div>
	<hr class="tall">
	<form action="/my_body_pointsearchlook.do" method="get" id="userpointsearch">
		<div class="container">
			<div style="float:left; width:30%;">
				<button class="btn btn-quaternary mb-2" type="button" 
				style="width:120pt; height:25pt;" onclick="location.href='/my_body_pointlook.do'">포인트 전체내역조회</button>
			</div>
			<div style="float:right; vertical-align: middle;">
				<font class="mb-0" size="4">조회기간 : </font> 
				<input type="date" id="sdate" name="sdate" /> ~ <input type="date" id="edate" name="edate" />
				<button class="btn btn-quaternary mb-2" type="button" style="height:25pt;" id="ups">조회</button>
			</div>
		</div>
	</form>
	
		
	<div class="container">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>일자</th>
						<th>상세내역</th>
						<th>거래 포인트</th>
						<th>거래 후 포인트</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${LVL_USERPOINTLIST}" var="apovo">
						<tr>
							<td>${apovo.poregdate}</td>
							<td>${apovo.updetail}</td>
							<td>${apovo.popoint}</td>
							<td>${apovo.afterpoint}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<div style="width: 200px; margin: auto;">
				${LVL_PAGING}
			</div>
	</div>
</div>

