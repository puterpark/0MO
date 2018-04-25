<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 여기에 사이드 우측 바디에 들어갈 컨텐츠를 작성 -->

<c:choose>
	<c:when test="${SESS_ASEQ != null && SESS_AGRADE == 'Super'}">
<script>
	$(function(){
		$(document).on("click",".upBtn",function(){
			var jbSplit = $(this).attr("id").split("-");
			var aseq = jbSplit[1];
			
			var obj = new Object();
			obj.aseq = aseq;
			
			$.ajax({
				url: "/admin_grade_up.do",
				headers:{
	                     'Content-Type':'application/json'
	            },
				type: "post",
				data: JSON.stringify(obj),
				success: function(result){
					$("#agrade"+aseq).empty();
					$("#agrade"+aseq).append(result);
				}
			});
			swal("등급 수정이 완료되었습니다.");
		});
	});
	
	$(function(){
		$(document).on("click",".downBtn",function(){
			var jbSplit = $(this).attr("id").split("-");
			var aseq = jbSplit[1];
			
			var obj = new Object();
			obj.aseq = aseq;
			
			$.ajax({
				url: "/admin_grade_down.do",
				headers:{
	                     'Content-Type':'application/json'
	            },
				type: "post",
				data: JSON.stringify(obj),
				success: function(result){
					$("#agrade"+aseq).empty();
					$("#agrade"+aseq).append(result);
				}
			});
			swal("등급 수정이 완료되었습니다.");
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
				<h1>관리자</h1>
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
					<button type="button" class="btn btn-outline btn-primary mb-2 totalBtn" id="totalBtn" onclick="location.href='/admin_admin_list.do'">전체보기</button>
					<!-- onclick="location.href='/index.do'" -->
				</div>
			</div>
			<table class="table table-hover">
				<col style="width: 10%;"></col>
				<col style="width: 15%;"></col>
				<col style="width: 15%;"></col>
				<col style="width: 15%;"></col>
				<col style="width: 15%;"></col>
				<thead>
					<tr>
						<th>#</th>
						<th>아이디</th>
						<th>이름</th>
						<th>등급</th>
						<th>활성상태</th>
						<th>가입일자</th>
						<th>액션</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${alist}" var="alist">
					<tr>
						<td style="vertical-align: middle;">${alist.aseq}</td>
						<td style="vertical-align: middle;">${alist.aid}</td>
						<td style="vertical-align: middle;">${alist.aname}</td>
						<td id="agrade${alist.aseq}" style="vertical-align: middle;">${alist.agrade}</td>
						<td style="vertical-align: middle;">
						<c:choose>
							<c:when test="${alist.aack== 'y'}">
								활성
							</c:when>
							<c:otherwise>
								비활성
							</c:otherwise>
						</c:choose>
						</td>
						<td style="vertical-align: middle;">${alist.aregdate}</td>
						<td style="vertical-align: middle;">
							<button type="button" class="btn btn-outline btn-primary mb-2 upBtn" id="upBtn-${alist.aseq}"><i class="fas fa-arrow-up"></i></button>
							<button type="button" class="btn btn-outline btn-primary mb-2 downBtn" id="downBtn-${alist.aseq}"><i class="fas fa-arrow-down"></i></button>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<hr class="short">
			
			<div style="width: 200px; margin: auto;">
				${paging}
			</div>
			
			<div class="header-search d-none d-md-block">
				<form id="searchMember" action="/admin_admin_search.do" method="get">
					<div class="input-group" style="width: 350px; margin: auto;">
						<input type="text" class="form-control" name="searchStr" id="searchStr" placeholder="검색어를 입력하세요." value="${searchStr}" required>
						<span class="input-group-append">
							<button class="btn btn-light" type="submit"><i class="fas fa-search"></i></button>
						</span>
					</div>
				</form>
			</div>
			
			<hr class="tall">
		</div>
	</div>
</div>
</c:when>
	<c:otherwise>
	<%@ include file="/tiles/admin_error.jsp" %>
	</c:otherwise>
</c:choose>