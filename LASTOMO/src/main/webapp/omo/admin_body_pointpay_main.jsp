<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<h1>결제/포인트</h1>
			</div>
		</div>
	</div>
</section>

<div role="main" class="main">
	<div class="container">
		<div class="col-12 mb-4 mb-lg-0">
			<div>
				<button type="button" class="btn btn-outline btn-primary mb-2" onclick="location.href='/admin_pay.do'">
				<i class="far fa-check-circle"></i>&nbsp;결제</button>
			</div>
			<table class="table table-hover">
				<col style="width: 25%;"></col>
				<col style="width: 25%;"></col>
				<col style="width: 25%;"></col>
				<col style="width: 25%;"></col>
				<thead>
					<tr>
						<th>ID</th>
						<th>결제금액</th>
						<th>결제수단</th>
						<th>결제날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${LVL_PAYLSIT}" var="pavo">
					<tr>
						<td>${pavo.mid}</td>
						<td>${pavo.pamoney}</td>
						<td>${pavo.ptname}</td>
						<td>${pavo.paregdate}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<hr class="tall">
		
		<div class="col-12 mb-4 mb-lg-0">
			<div>
				<button type="button" class="btn btn-outline btn-primary mb-2" onclick="location.href='/admin_point.do'">
				<i class="far fa-user-circle"></i>&nbsp;포인트</button>
			</div>
			<table class="table table-hover">
				<col style="width: 25%;"></col>
				<col style="width: 25%;"></col>
				<col style="width: 25%;"></col>
				<col style="width: 25%;"></col>
				<thead>
					<tr>
						<th>ID</th>
						<th>포인트</th>
						<th>포인트 내역</th>
						<th>날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${LVL_POINTLIST}" var="povo">
					<tr>
						<td>${povo.mid}</td>
						<td>${povo.popoint}</td>
						<td>${povo.updetail}</td>
						<td>${povo.poregdate}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<hr class="tall">
	</div>
</div>
</c:when>
	<c:otherwise>
	<%@ include file="/tiles/admin_error.jsp" %>
	</c:otherwise>
</c:choose>