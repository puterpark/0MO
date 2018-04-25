<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 여기에 사이드 우측 바디에 들어갈 컨텐츠를 작성 -->
<c:choose>
	<c:when test="${SESS_ASEQ != null}">
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
				<h1>구직게시판</h1>
			</div>
		</div>
	</div>
</section>

<div role="main" class="main">
	<div class="container">
		<div class="col-12 mb-4 mb-lg-0">
			<div style="margin-bottom: 1px">
				<button type="button" class="btn btn-outline btn-light mb-2" onclick="javascript:history.back()">«이전</button>
				
			</div>
			<table class="table table-hover">
				<col style="width: 35%;"></col>
				<col style="width: 40%;"></col>
				<col style="width: 10%;"></col>
				<col style="width: 15%;"></col>
				<thead>
					<tr>
						<th>공모전</th>
						<th>주최</th>
						<th>회원</th>
						<th>등록일자</th>
					</tr>
				</thead>
				<tbody>
					<tr onclick="location.href='/admin_gongmo_detail.do'" style="cursor:pointer">
						<td style="vertical-align: middle;">(주)쿠우쿠우 캐릭터 공모전</td>
						<td style="vertical-align: middle;">(주)쿠우쿠우 프랜차이즈 그룹</td>
						<td style="vertical-align: middle;">system</td>
						<td style="vertical-align: middle;">2018.01.01</td>
					</tr>
					<tr onclick="location.href='/gongmo_detail.do'" style="cursor:pointer">
						<td style="vertical-align: middle;">(주)쿠우쿠우 캐릭터 공모전</td>
						<td style="vertical-align: middle;">(주)쿠우쿠우 프랜차이즈 그룹</td>
						<td style="vertical-align: middle;">system</td>
						<td style="vertical-align: middle;">2018.01.01</td>
					</tr>
					<tr onclick="location.href='/gongmo_detail.do'" style="cursor:pointer">
						<td style="vertical-align: middle;">(주)쿠우쿠우 캐릭터 공모전</td>
						<td style="vertical-align: middle;">(주)쿠우쿠우 프랜차이즈 그룹</td>
						<td style="vertical-align: middle;">system</td>
						<td style="vertical-align: middle;">2018.01.01</td>
					</tr>
					<tr onclick="location.href='/gongmo_detail.do'" style="cursor:pointer">
						<td style="vertical-align: middle;">(주)쿠우쿠우 캐릭터 공모전</td>
						<td style="vertical-align: middle;">(주)쿠우쿠우 프랜차이즈 그룹</td>
						<td style="vertical-align: middle;">system</td>
						<td style="vertical-align: middle;">2018.01.01</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
</c:when>
	<c:otherwise>
	<%@ include file="/tiles/admin_error.jsp" %>
	</c:otherwise>
</c:choose>