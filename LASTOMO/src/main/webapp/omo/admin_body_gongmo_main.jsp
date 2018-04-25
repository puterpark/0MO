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
				<h1>공모전</h1>
			</div>
		</div>
	</div>
</section>

<div role="main" class="main">
	<div class="container">
		<div class="col-12 mb-4 mb-lg-0">
			<div>
				<button type="button" class="btn btn-outline btn-primary mb-2" onclick="location.href='/admin_gongmo_admin_list.do'"><i class="far fa-check-circle"></i>&nbsp;공식 공모전</button>
			</div>
			<table class="table table-hover">
				<col style="width: 50%;"></col>
				<col style="width: 30%;"></col>
				<col style="width: 20%;"></col>
				<thead>
					<tr>
						<th>공모전</th>
						<th>주최</th>
						<th>진행상태</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${alist}" var="alist">
					<tr onclick="location.href='/admin_gongmo_detail.do?gseq=${alist.gseq}'" style="cursor:pointer">
						<td>
							<b>${alist.gtitle}</b>&nbsp;&nbsp;<i class="fas fa-heart"></i>${alist.lvo.lcnt}
						</td>
						<td>${alist.gspon}</td>
						<td>${alist.gregdate}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<hr class="tall">
		
		<div class="col-12 mb-4 mb-lg-0">
			<div>
				<button type="button" class="btn btn-outline btn-primary mb-2" onclick="location.href='/admin_gongmo_user_list.do'"><i class="far fa-user-circle"></i>&nbsp;유저 공모전</button>
			</div>
			<table class="table table-hover">
				<col style="width: 50%;"></col>
				<col style="width: 30%;"></col>
				<col style="width: 20%;"></col>
				<thead>
					<tr>
						<th>공모전</th>
						<th>주최</th>
						<th>진행상태</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ulist}" var="ulist">
					<tr onclick="location.href='/admin_gongmo_detail.do?gseq=${ulist.gseq}'" style="cursor:pointer">
						<td>
							<b>${ulist.gtitle}</b>&nbsp;&nbsp;<i class="fas fa-heart"></i>${ulist.lvo.lcnt}
						</td>
						<td>${ulist.gspon}</td>
						<td>${ulist.gregdate}</td></tr>
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